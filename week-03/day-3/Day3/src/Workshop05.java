public class Workshop05{
    public static void main(String[] args) {
        int[] t = new int[] {1, 2, 3, 4, 5};
        // increment the 3rd element
        t[2]++;
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
    }
}