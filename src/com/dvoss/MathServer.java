package com.dvoss;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Dan on 11/4/16.
 */

/*
* debugging from source code at https://blog.udemy.com/java-projects/
*/

public class MathServer extends UnicastRemoteObject implements MathInterface {

    public MathServer() throws RemoteException {

        System.out.println("Initializing Server");
    }
    public int add(int a, int b) {
        return(a+b);
    }
    public int subt(int a, int b) {
        return(a-b);
    }
    public int mult(int a, int b) {
        return(a*b);
    }
    public int div(int a, int b) {
        return(a/b);
    }

    public static void main(String args[]) {

        try {
            MathServer ms = new MathServer();
            // the following line of code, from stack overflow, doesn't do the trick
            System.setProperty("java.rmi.server.hostname", "10.0.0.9");
            java.rmi.Naming.rebind("MathServ", ms);
            System.out.println("Server Ready");
        }

        catch(RemoteException RE) {
            System.out.println("Remote Server Error: "+ RE.getMessage());
            System.exit(0);
        }

        catch(MalformedURLException ME) {
            System.out.println("Invalid URL");
        }
    }
}
