import java.util.Arrays;
import java.util.HashSet;

public class HashSetter {
    public static void main(String[] args) {
        HashSet<Long> phoneNumbers = new HashSet<>();
        phoneNumbers.add(Long.valueOf(301234567));
        phoneNumbers.add(Long.valueOf(209876543));

        System.out.println(phoneNumbers.toString());
    }
}