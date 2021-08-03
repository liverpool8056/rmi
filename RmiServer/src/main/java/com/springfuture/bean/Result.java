package com.springfuture.bean;

import java.io.Serializable;
import java.util.HashMap;

public class Result {

//    private static final long serialVersionUID = 227L;
    private boolean success;
    private HashMap<String, Object> attr;

    public boolean isSuccess() {
        return success;
    }

    public Result(boolean success) {
        this.success = success;
        this.attr = new HashMap<>();
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getAttribute(String attrName){
        return attr.get(attrName);
    }

    public Object setAttribute(String attrName, Object o){
        return attr.put(attrName, o);
    }
}
