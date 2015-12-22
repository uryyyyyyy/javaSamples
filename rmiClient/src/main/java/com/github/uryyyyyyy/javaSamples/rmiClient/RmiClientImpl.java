package com.github.uryyyyyyy.javaSamples.rmiClient;

import com.github.uryyyyyyy.javaSamples.rmiObject.Messenger;
import com.github.uryyyyyyy.javaSamples.rmiObject.MessengerImpl;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RmiClientImpl {

    private String host;
    private int port;
    private String serverName;

    public RmiClientImpl(String host, int port, String serverName){
        this.host = host;
        this.port = port;
        this.serverName = serverName;
    }

    public Remote lookup() throws RemoteException, NotBoundException, MalformedURLException{
        return lookup(host, port, serverName);
        //return lookupViaProcess(host, port, serverName);
    }

    public static void main(String[] args){

        String message = "Hey, Keid!";

        try {

            //String host = "localhost";
            String host = InetAddress.getLocalHost().getHostAddress();
            int port = 1099;
            String serverName = "server";

            RmiClientImpl client = new RmiClientImpl(host, port, serverName);
            Messenger messenger = (Messenger) client.lookup();
            System.out.println(messenger.send(message));

        } catch (UnknownHostException | RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public Remote lookup(String host, int port, String serverName) throws RemoteException, NotBoundException{

        // rmi url
        String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;

        // lookup remote object from rmiregistry
        System.out.println("lookup \"" + url + "\" from rmiregistry");
        Registry rmiregistry = LocateRegistry.getRegistry(port);

        return rmiregistry.lookup(url);

    }

    public Remote lookupViaProcess(String host, int port, String serverName) throws RemoteException, NotBoundException, MalformedURLException{

        // rmi url
        String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;

        // lookup remote object from rmiregistry
        System.out.println("lookup \"" + url + "\" from rmiregistry");

        return Naming.lookup(url);

    }

}