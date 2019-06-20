import java.io.Serializable;
import java.rmi.*;

public interface IRMISemaphores extends Remote, Serializable {

	public boolean createSemaphore(int id, int maxState) throws RemoteException, InterruptedException;
    public IRMISemaphore getSemaphore(int id) throws RemoteException, InterruptedException;
}