package com.lml.result;

public enum ResultEnum {
    /**
     * 成功
     */
    success(200,"成功"),
    CREATE(201,"新建或修改数据成功"),
    Accepted(202,"请求已排入后台排队"),

/**
 * test pull
 * */

    /**
     * 服务器报错
     */
    ERROR_SERVER_SUSPENSION(503,"服务器暂停服务！"),
    ERROR_INTERNAL_SERVER_ERROR(500,"服务器内部错误，无法完成请求"),

    /**
     *
     */
    ERROR_SYSTEM_REJECT(403,"系统拒绝！"),
    ERROR_UNAUTHORIZED(401,"系统拒绝！"),
    ERROR_BAD_REQUEST(400,"客户端请求的语法错误，服务器无法理解！"),
    ERROR_ACCESS_TIMEOUT(408,"访问超时！"),

    ;

    private Integer code;


    private String msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode(){return code;}

    public String getMsg(){return msg;}
}