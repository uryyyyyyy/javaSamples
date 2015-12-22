package com.github.uryyyyyyy.javaSamples.rmiObject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Messenger extends Remote{

    default String send(String message) throws RemoteException{
        System.out.println("client says \"" + message + "\".");
        return "send \"" + message + "\" to server.";
    }

}
