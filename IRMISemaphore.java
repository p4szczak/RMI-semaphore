import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.lang.Thread;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.Semaphore;


public interface IRMISemaphore extends Remote {

	public void p(int state) throws RemoteException, InterruptedException;
    public void v(int state) throws RemoteException;

}