import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.lang.Thread;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Random;


public class Main{
    public static void main(String[] args){
		try{
            Registry r = LocateRegistry.getRegistry(1099);
            IRMISemaphores semaphores = (IRMISemaphores) r.lookup("RMISemaphore");
            int[] stateTab = {1};
            for(int i = 0 ; i < stateTab.length; i++){
                boolean res = semaphores.createSemaphore(i,stateTab[i]);
                if(res)
                    System.out.printf("Semaphore with id: %d with state: %d has been created\n", i, stateTab[i]);
            }

            Random rand = new Random();
            while(true){
                int semId = rand.nextInt(stateTab.length);
                int state = 1 + rand.nextInt(stateTab[semId]);
                IRMISemaphore lock = semaphores.getSemaphore(semId);
//                System.out.printf("@@@@ Try to Lock P on semaphore %d with state: %d\n", semId, state);
                lock.p(state);
                System.out.printf("!!!! Lock P on semaphore %d with state: %d\n", semId, state);
                Thread.sleep((1 + rand.nextInt(2)) * 1000);
                lock.v(state);
                System.out.printf("@@@@ Lock V on semaphore %d with state: %d\n", semId, state);
                Thread.sleep((1 + rand.nextInt(2)) * 1000);
            }
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}