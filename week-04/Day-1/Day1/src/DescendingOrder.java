import java.util.*;

public class DescendingOrder {
    public static void main(String[] args) {
        System.out.println(sortDesc(1254859723));
        System.out.println(sortDesc(15));
        System.out.println(sortDesc(123456789));
    }
    public static long sortDesc(final int num) {
        int i = num;
        List<Integer> digits = new ArrayList<Integer>();
        while (i > 0) {
            digits.add(i % 10);
            i /= 10;
        }
        Comparator cmp = Collections.reverseOrder();
        Collections.sort(digits, cmp);
        long output = 0;
        for (int digit : digits) {
            output = output * 10 + digit;
        }
        return output;
    }
}