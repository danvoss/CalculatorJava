package com.dvoss;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Dan on 11/4/16.
 */

public interface MathInterface extends Remote {

    int add(int a,int b) throws RemoteException;
    int subt(int a,int b) throws RemoteException;
    int mult(int a,int b) throws RemoteException;
    int div(int a,int b) throws RemoteException;

}
