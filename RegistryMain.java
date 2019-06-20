import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.lang.Thread;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class RegistryMain{

    public static void main(String[] args){
            try{
                IRMISemaphores c = new RMISemaphores();
                Registry r = LocateRegistry.createRegistry(1099);

                r.rebind("RMISemaphore", c);
                System.out.print("Bind completed");
            } catch(Exception ex){
                ex.printStackTrace();
                System.out.print("Bind error");
            }
        }
}