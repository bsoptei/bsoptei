public class Workshop35 {
    public static void main(String[] args) {
        // Write a program which has this output
        // 1******
        // 12*****
        // 123****
        // 1234***
        // 12345**
        // 123456*
        // 1234567
        String output = "";
        for (int i = 1; i <= 7; i++) {
            String newOut = "";

            String o = String.valueOf(i);
            output = output.concat(o);
//            int j = 7 - i;
            for (int j = 7 - i; j > 0; j--) {
                newOut = newOut.concat("*");
            }
            String concat = output + newOut;
            System.out.println(concat);
        }
    }
}