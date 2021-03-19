package com.lml.util.dao;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName Util
 * @Description
 * @Author lml
 * @Date2021/3/17 17:04
 * @Version V1.0
 **/

public class Util {


    // 这个有什么用呢，从代码看，他是用来获取对象有哪些属性是空的，从功能来看，他是用来在更新对象的时候不会更新前端传来的为空的字段
    public static String[] getNullPropertyNames(Objects source){
        final BeanWrapper src = new BeanWrapperImpl(source);

        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd: pds){
            Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue ==null){
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);

    }
}
