package com.springfuture.service;

import com.springfuture.bean.LogBean;
import com.springfuture.bean.Result;

public class RmiServiceA implements RmiService {
    @Override
    public Result login() {
        Result result = new Result(false);
        LogBean logBean = new LogBean();
        logBean.setFilename("f1");
        result.setAttribute("logBean", logBean);
        return result;
    }
}
