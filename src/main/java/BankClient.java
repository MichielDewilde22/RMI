import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankClient {
    private BankClient() {}

    public static void main(String[] args) {

        String command = (args.length < 1) ? null : args[0];
        String am = (args.length < 1) ? null : args[1];
        int amount = Integer.parseInt(am);


        switch(command.toLowerCase()) {
            case "add":     {
                                try {
                                    Registry registry = LocateRegistry.getRegistry("192.168.1.1", 1099);
                                    Bank stub = (Bank) registry.lookup("addMoney");
                                    String response = stub.addMoney(amount);
                                    System.out.println("response: " + response);
                                } catch (Exception e) {
                                    System.err.println("Client exception: " + e.toString());
                                    e.printStackTrace();
                                }
                            }
                            break;
            case "withdraw":{
                                try {
                                    Registry registry = LocateRegistry.getRegistry("192.168.1.1", 1099);
                                    Bank stub = (Bank) registry.lookup("withdrawMoney");
                                    String response = stub.withdrawMoney(amount);
                                    System.out.println("response: " + response);
                                } catch (Exception e) {
                                    System.err.println("Client exception: " + e.toString());
                                    e.printStackTrace();
                                }
                            }
                            break;
            case "balance":{
                                try {
                                    Registry registry = LocateRegistry.getRegistry("192.168.1.1", 1099);
                                    Bank stub = (Bank) registry.lookup("balance");
                                    String response = stub.balance();
                                    System.out.println("response: " + response);
                                } catch (Exception e) {
                                    System.err.println("Client exception: " + e.toString());
                                    e.printStackTrace();
                                }
                            }
                            break;
            default:        System.err.println("Invalid command");
                            break;
        }

        /*try {
            Registry registry = LocateRegistry.getRegistry("192.168.1.1", 1099);
            Bank stub = (Bank) registry.lookup("Hello");
            String response = stub.balance();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }*/
    }
}
