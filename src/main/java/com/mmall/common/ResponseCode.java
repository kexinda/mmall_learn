package com.mmall.common;

/**
 * Created by kexi955 on 4/24/2024.
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;
    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int GetCode(){
        return code;
    }
    public String GetDesc(){
        return desc;
    }

}
