package pcd.lab10.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Counter extends Remote {
	void inc() throws RemoteException;
	int getValue() throws RemoteException;
}
