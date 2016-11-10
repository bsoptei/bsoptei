public class Workshop08 {


    public static void main(String args[]) {
        try {
            System.out.println("try - first statement");
            myMethod(7);
        } catch (Exception e) {
            System.out.println("An Exception Occurred");
        } finally {
            System.out.println("Finally I did this instead");
        }
        System.out.println("::::FINISH LINE:::: ");
    }

    static void myMethod(int inNumber) throws Exception {
        System.out.println("start - myMethod");
        inNumber = inNumber / 0;
    }
}