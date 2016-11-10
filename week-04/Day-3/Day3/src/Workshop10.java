public class Workshop10 {

    public static void main(String args[]) {
        Exception e = new Exception("nope");

        String strTest = null;
        try {
            System.out.println("Hurdle 01");
            System.out.println(strTest.length());
        } catch (Exception err1) {
            System.out.println(e.getMessage());
        }
        try {
        strTest = "The quick brown fox jump over the lazy dog";
        System.out.println("Hurdle 02: Setup");
        System.out.println(strTest.length());

        char c = strTest.charAt(0);
        System.out.println("Char 0 = " + c);

        System.out.println("Hurdle 02: Catch");

            c = strTest.charAt(strTest.length());
        } catch (Exception err2) {
            System.out.println(e.getMessage());
        }

        System.out.println("Hurdle 03");
        try {
            int num = Integer.parseInt(strTest);
        } catch (Exception err3) {
            System.out.println(e.getMessage());
        }
        System.out.println(":::: FINISH LINE ::::");
    }

}
