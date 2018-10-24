import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
    String balance() throws RemoteException;
    String addMoney() throws RemoteException;
    String withdrawMoney() throws RemoteException;
}