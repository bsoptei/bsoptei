public class Workshop09 {

    public static void main(String args[]) {
        try {
            myMethod(1);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    static void myMethod(int inNumber) throws Exception {
        Exception err = new Exception("This is my unique error message!");
        throw err;
    }

}