package com.github.uryyyyyyy.javaSamples.rmiObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessengerImpl extends UnicastRemoteObject implements Messenger{

    public MessengerImpl() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 1L;

}