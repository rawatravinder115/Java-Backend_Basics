package com.example.jpabean.jpabean;

public class HelloWorld {

    private String msg;
    private String data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public HelloWorld(String msg, String data) {
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "msg = " + this.msg + " , data = " + this.data;
    }
}
