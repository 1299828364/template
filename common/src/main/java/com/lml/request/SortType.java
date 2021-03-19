package com.lml.request;

/**
 * @ClassName SortType
 * @Description
 * @Author lml
 * @Date2021/3/17 16:38
 * @Version V1.0
 **/
public enum SortType {

    ASC("asc"),

    DESC("desc");

    private final String value;

    private SortType(String value){
        this.value = value;
    }

    public String toValue(){
        return this.value;
    }
}
