package com.lml.util;

import com.lml.result.Result;
import com.lml.result.ResultEnum;

public class ResultUtil<T> {
    public static<T> Result<T> success(T object){
        System.out.println(object);
        Result<T> result=new Result<>(object);
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    public static<T> Result<T> success(){
        return success(null);
    }

    public static<T> Result<T> success(T object,String msg){
        Result<T> result=new Result<>();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static<T> Result<T> error(Integer code,String msg,T object){
        Result<T> result=new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static<T>Result<T>  error(ResultEnum resultEnum, T object){
        return error(resultEnum.getCode(),resultEnum.getMsg(),object);
    }

    public static<T> Result<T> error(T describe){
        return error(ResultEnum.ERROR_SYSTEM_REJECT,describe);
    }
}
