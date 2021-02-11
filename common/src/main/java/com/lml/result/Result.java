package com.lml.result;

public class Result<T> {

    /**  错误码。 */
    private Integer code;

    /**  提示信息 */
    private String msg;

    /**  具体的内容*/
    private T data;

    public Result(T t){
        this.data = t;
    }
    public Result(){
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Result{"+
                "code="+code+
                ".msg'"+msg+'\''+
                ",data="+data+
                '}';
    }
}