package pcd.lab10.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyClass2 extends Remote {

	int get() throws RemoteException;

	void update(int c) throws RemoteException;
	
}