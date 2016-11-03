import sun.plugin.javascript.navig.Array;

public class Workshop04{
    public static void main(String[] args) {
        int[] s = new int[] { 1, 2, 3, 8, 5, 6 };
        // change the 8 to 4
        s[3] = 4;
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + ", ");
        }
    }
}