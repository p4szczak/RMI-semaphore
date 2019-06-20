import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.lang.Thread;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.Semaphore;

public class RMISemaphore extends UnicastRemoteObject implements IRMISemaphore{
	private Semaphore localSemaphore;
	private int id;

    
    public RMISemaphore(int id, int maxState) throws RemoteException{
		super();
		this.id = id;
        this.localSemaphore = new Semaphore(maxState, true); //true -> FIFO
	}

    @Override
	public void p(int state) throws InterruptedException {
        this.localSemaphore.acquire(state);
    }

    @Override
    public void v(int state){
        this.localSemaphore.release(state);
    }

    public int getId(){
        return this.id;
    }
}
