package com.springfuture.service;

import com.springfuture.bean.Result;

import java.io.Serializable;
import java.rmi.Remote;

public interface RmiService extends Remote, Serializable {
    Result login();
}
