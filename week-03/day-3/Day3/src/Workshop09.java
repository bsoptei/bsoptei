public class Workshop09{
    public static void main(String[] args) {
        int[] ag = new int[] { 3, 4, 5, 6, 7 };
        // please double all the elements of the list
        for (int a = 0; a < ag.length; a++) {
            ag[a] *= 2;
            System.out.println(ag[a]);
        }
    }
}