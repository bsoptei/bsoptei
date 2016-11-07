import java.util.HashMap;
import java.util.Map;

public class HashMapper {

    static HashMap<String, Double> bankAccounts = new HashMap<>();

    public static void main(String[] args) {
        bankAccounts.put("John", 100000.00);
        bankAccounts.put("Joanna", 200000.00);

        for (String client: bankAccounts.keySet()) {
            System.out.println(client);
        }
        for (double balance: bankAccounts.values()) {
            System.out.println(balance);
        }
        for (Map.Entry clientData: bankAccounts.entrySet()) {
            System.out.println(clientData);
        }
        bankAccounts.remove("John");
        bankAccounts.put("Joanna", 110000.00);
        System.out.println(bankAccounts.get("Joanna"));
    }
}