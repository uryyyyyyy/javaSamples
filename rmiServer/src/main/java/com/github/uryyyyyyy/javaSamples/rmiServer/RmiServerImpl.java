package com.github.uryyyyyyy.javaSamples.rmiServer;

import com.github.uryyyyyyy.javaSamples.rmiObject.Messenger;
import com.github.uryyyyyyy.javaSamples.rmiObject.MessengerImpl;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RmiServerImpl {

    private String host;
    private int port;
    private String serverName;
    private Remote remoteObject;

    public RmiServerImpl(String host, int port, String serverName, Remote remoteObject){
        this.host = host;
        this.port = port;
        this.serverName = serverName;
        this.remoteObject = remoteObject;
    }

    public void start() throws RemoteException, MalformedURLException{
        start(host, port, serverName, remoteObject);
        //startViaProcess(host, port, serverName, remoteObject);
    }

    public static void main(String[] args){

        try {

            //String host = "localhost";
            String host = InetAddress.getLocalHost().getHostAddress();
            int port = 1099;
            String serverName = "server";
            Messenger messenger = new MessengerImpl();

            RmiServerImpl server = new RmiServerImpl(host, port, serverName, messenger);
            server.start();

        } catch (UnknownHostException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void start(String host, int port, String serverName, Remote remoteObject) throws RemoteException{

        // rmi url
        String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;

        // bind remote object to rmiregistry
        System.out.println("bind \"" + url + "\" to rmiregistry");
        Registry rmiregistry = LocateRegistry.createRegistry(port);
        rmiregistry.rebind(url, remoteObject);

        System.out.println("Rmi server starting...");

    }

    public void startViaProcess(String host, int port, String serverName, Remote remoteObject) throws RemoteException, MalformedURLException{

        // rmi url
        String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;

        // bind remote object to rmiregistry
        System.out.println("bind \"" + url + "\" to rmiregistry");
        Naming.rebind(url, remoteObject);

        System.out.println("Rmi server starting...");

    }

}