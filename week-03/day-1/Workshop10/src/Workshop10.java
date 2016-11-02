public class Workshop10{
    public static void main(String[] args) {
        int j1 = 10;
        int j2 = 3;
        // tell if j1 is between j2 squared and j2 cubed
        boolean myBoolean = (j1 > Math.pow(j2, 2)) && (j1 < Math.pow(j2, 3));
        System.out.println(myBoolean);
    }
}
