import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
    String balance() throws RemoteException;
    int addMoney(int money) throws RemoteException;
    int withdrawMoney(int money) throws RemoteException;
}