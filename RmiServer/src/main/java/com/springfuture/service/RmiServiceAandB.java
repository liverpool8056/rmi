package com.springfuture.service;

import com.springfuture.bean.Result;

public class RmiServiceAandB implements RmiService {

    private final RmiServiceA rmiServiceA;
    private final RmiServiceB rmiServiceB;

    public RmiServiceAandB(RmiServiceA rmiServiceA, RmiServiceB rmiServiceB) {
        this.rmiServiceA = rmiServiceA;
        this.rmiServiceB = rmiServiceB;
    }

    @Override
    public Result login() {
        Result result = rmiServiceA.login();
        if(result.isSuccess()) return result;
        result = rmiServiceB.login();
        return result;
    }
}
