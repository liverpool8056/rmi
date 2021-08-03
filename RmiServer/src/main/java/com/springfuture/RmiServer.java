package com.springfuture;

import com.springfuture.service.RmiService;
import com.springfuture.service.RmiServiceA;
import com.springfuture.service.RmiServiceAandB;
import com.springfuture.service.RmiServiceB;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

    private final static String rmiUrl = "rmi://127.0.0.1:8090/service";
    private InitialContext initialContext;

    public static void main(String[] args) {
        String mode = "serviceA-prefer"; // serviceA-only, serviceA-prefer, serviceB-only
        RmiServer rmiServer = new RmiServer();
        try {
            rmiServer.registry(mode);
        } catch (Exception e) {
            System.out.println("Fail to start server");
            e.printStackTrace();
        }
    }

    public void registry(String mode) throws RemoteException, MalformedURLException, AlreadyBoundException, NamingException {
        LocateRegistry.createRegistry(8090);
        RmiServiceA rmiServiceA = new RmiServiceA();
        RmiServiceB rmiServiceB = new RmiServiceB();
        RmiService rmiServiceAandB = new RmiServiceAandB(rmiServiceA, rmiServiceB);
        switch (mode){
            case "serviceA-prefer":
                Naming.bind(rmiUrl, rmiServiceAandB);
                break;
            case "serviceB-only":
                Naming.bind(rmiUrl, rmiServiceB);
                break;
            default: //"serviceA-only"
                Naming.bind(rmiUrl, rmiServiceA);
                break;
        }
        while(true);
    }

}
