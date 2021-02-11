package com.lml.util;

import java.lang.reflect.Method;

public class TestParse {
    public static String parse(Class targetClass, String methodName,Object[] args) throws Exception{
        String methodAccess = "";
        /*
         * 为简单起见，这里考虑该方法没有参数
         */
        Method method;
        if(args==null||args.length==0){
            method = targetClass.getMethod(methodName);
        }
        else {
            Class[] classes = new Class[args.length];
            for (int i = 0 ;i<args.length;i++ ){
                classes[i] = args[i].getClass();
            }
            method = targetClass.getMethod(methodName,classes);
        }

        //判断方法上是否有Privilege注解
        if (method.isAnnotationPresent(RoleTest.class)) {
            //得到方法上的注解
            RoleTest test = method.getAnnotation(RoleTest.class);
            methodAccess = test.hasRole();
        }
        return methodAccess;
    }
}
