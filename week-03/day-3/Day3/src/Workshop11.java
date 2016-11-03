public class Workshop11{
    public static void main(String[] args) {
        String[] ah = new String[] { "kuty", "macsk", "cic" };
        // add to all elements an 'a' on the end
        for (int a = 0; a < ah.length; a++) {
            ah[a] = ah[a].concat("a");
            System.out.println(ah[a]);
        }
    }
}