package com.mmall.common;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by kexi955 on 4/24/2024.
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候， 如果是null的对象，key也会消失。
public class ServerResponse<T> implements Serializable{
    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status){
        this.status = status;

    }
    private ServerResponse(int status, T data){
        this.status = status;
        this.data = data;
    }
    private ServerResponse(int status, String msg){
        this.status = status;
        this.msg = msg;
    }
    private ServerResponse(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @jsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.GetCode();
    }

    public int GetStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.GetCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.GetCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.GetCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.GetCode(),msg, data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.GetCode(),ResponseCode.ERROR.GetDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.GetCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }


}
