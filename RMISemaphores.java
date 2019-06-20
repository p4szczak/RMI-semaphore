import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class RMISemaphores extends UnicastRemoteObject implements IRMISemaphores, Serializable{

	ArrayList<RMISemaphore> semaphoreList = new ArrayList<RMISemaphore>();

    public RMISemaphores() throws RemoteException {
        super();
        this.semaphoreList = new ArrayList<RMISemaphore>();
    }

    @Override
    public synchronized boolean createSemaphore(int id, int maxState) throws RemoteException{
        RMISemaphore localsem = new RMISemaphore(id, maxState);

        for(int i = 0; i < this.semaphoreList.size(); i++){
            if(localsem.getId() == this.semaphoreList.get(i).getId()) return false;
        }
        this.semaphoreList.add(localsem);
        return true;
    }


    @Override
    public IRMISemaphore getSemaphore(int id){
        return semaphoreList.get(id);
    }

    public ArrayList<RMISemaphore> getSemphoreList(){
        return this.semaphoreList;
    }
}