package com.stars.sea.work.common;

import lombok.Data;


public class ResponseVO {
    private int code;
    private String msg;
    private Object data;
    private int size;
    public ResponseVO(){
        this.code=400;
        this.msg = "系统异常，操作失败";
    }
   public void isOK(){
       this.code=200;
       this.msg = "操作成功";
   }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        isOK();
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
