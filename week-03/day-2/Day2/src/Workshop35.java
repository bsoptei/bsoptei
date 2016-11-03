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
        String output = "*******";
        for (int i = 1; i <= 7; i++) {
            output = output.replaceFirst("[*]", Integer.toString(i));
            System.out.println(output);
        }
    }
}