package com.springfuture.service;

import com.springfuture.bean.LogBeanNew;
import com.springfuture.bean.Result;

public class RmiServiceB implements RmiService {
    @Override
    public Result login() {
        Result result = new Result(true);
        LogBeanNew logBeanNew = new LogBeanNew();
        logBeanNew.setFilename("f2");
        result.setAttribute("logBean", logBeanNew);
        return result;
    }
}
