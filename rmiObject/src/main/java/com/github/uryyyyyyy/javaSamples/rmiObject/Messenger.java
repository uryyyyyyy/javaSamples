package com.github.uryyyyyyy.javaSamples.rmiObject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Messenger extends Remote{

    String send(String message) throws RemoteException;

}
