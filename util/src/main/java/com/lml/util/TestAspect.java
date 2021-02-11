package com.lml.util;

import com.lml.model.User;
import com.lml.model.UserRole;
import com.lml.result.ResultEnum;
import com.lml.util.dao.RoleDao;
import com.lml.util.dao.UserRoleDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Slf4j
@Component
public class TestAspect{
    private List<RoleTest>  tests;

    public List<RoleTest> getTests(){
        return tests;
    }

    public void setTests(List<RoleTest> tests){
        this.tests = tests;
    }

    @Pointcut("execution(* com.lml.controller.*.*(..))")
    public void controllerMethod() {
    }

    @Autowired
    RequestUtil requestUtil;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserRoleDao userRoleDao;

    @Around(value = "controllerMethod()")
    public Object process(ProceedingJoinPoint joinPoint)throws Throwable {
        Class targetClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        String methodAccess = TestParse.parse(targetClass, methodName, args);

        if(StringUtils.isBlank(methodAccess)){
            return joinPoint.proceed();
        }

        User userInfo = requestUtil.getUserInfo();
        List<UserRole> list = userRoleDao.findByUid(userInfo.getUserId());
        boolean isAcc=false;
        for (UserRole userRole : list){
                if(roleDao.findById(userRole.getRoleId()).get().getRoleName().equals(methodAccess)){
                return joinPoint.proceed();
            }
        }
        System.out.println("這裏出錯了");
        log.error("這裏出錯了");
        return ResultUtil.error(ResultEnum.ERROR_UNAUTHORIZED,null);
    }

}
