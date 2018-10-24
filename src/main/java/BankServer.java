import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class BankServer implements Bank {

    public BankServer() {
        String user = "Client";
        int balance = 0;
    }

    public String balance() {
        return "Your current balance is: " + balance;
    }

    public int addMoney(int money) throws RemoteException {
        balance = balance + money;
        return balance;

    }

    public int withdrawMoney(int money) throws RemoteException {
        balance = balance - money;
        return balance;
    }

    public String
    public static void main(String args[]) {

        try {
            BankServer obj = new BankServer();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            LocateRegistry.createRegistry(1099);
            // Bind the remote object's stub in the registry
            //System.setProperty("java.rmi.server.hostname","192.168.1.1");
            //Registry registry = LocateRegistry.getRegistry();
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

