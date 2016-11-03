public class Workshop15{
    public static void main(String[] args) {
        int af = 123;
        // create a function that doubles it's input
        // double af with it
        af = doubler(af);
        System.out.println(af);
    }
    public static int doubler(int numberToDouble) {
        return numberToDouble * 2;
    }
}