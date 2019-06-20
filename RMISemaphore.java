import java.rmi.*;

public interface ICount extends Remote{

	public acquire(int permits) throws RemoteException, InterruptedException;
    public void release(int permits) throws RemoteException;
}