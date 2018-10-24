import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
    String balance() throws RemoteException;
    String addMoney(int money) throws RemoteException;
    String withdrawMoney(int money) throws RemoteException;
}