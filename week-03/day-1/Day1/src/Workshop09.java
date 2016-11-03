public class Workshop09{
    public static void main(String[] args) {
        long i = 1357988018575474L;
        // tell if it has 11 as a divisor
        long modulo = i % 11;
        if (modulo == 0) {
            System.out.println("Yes it has it!");
        } else {
            System.out.println("Not.");
        }
    }
        //        System.out.println(modulo);
}