package com.springfuture;

import com.springfuture.bean.LogBean;
import com.springfuture.bean.LogBeanNew;
import com.springfuture.bean.Result;
import com.springfuture.service.RmiService;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RmiClient {

    private final static String rmiUrl = "rmi://localhost:8090/service";
    public static void main(String[] args) throws NamingException {
        InitialContext initialContext = new InitialContext();
        RmiService rmiService = (RmiService) initialContext.lookup(rmiUrl);
        Result result = rmiService.login();
//        LogBean logBean = (LogBean) result.getAttribute("logBean");
//        System.out.println("Result is " + result.isSuccess() + ", attr is " + logBean.getFilename());

        LogBeanNew logBeanNew = (LogBeanNew) result.getAttribute("logBean");
        System.out.printf("Result is " + result.isSuccess() + ", attr is " + logBeanNew.getFilename());
    }
}
