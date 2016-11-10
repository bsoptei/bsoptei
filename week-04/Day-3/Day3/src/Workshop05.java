/**************************************************************************************************
 * Workshop: Practice Exceptions: Nested Try Catch
 *
 * Run this and explain the what the heck is going on
 *
 * ADD YOUR EXPLANATION HERE -----------------------------------
 *  1. The program performs a division by zero in block1
 *  2. This is caught as an Arithmetic Exception in block1
 *  3. Another Arithmetic Exception arises in block2
 *  4. It is caught in the parent block
 *  5. "Next statement..." is printed outside the try-catch blocks
 *
 **************************************************************************************************/


public class Workshop05 {
    public static void main(String[] args) {

        try {
            try {
                System.out.println("Inside block1");
                int b = 45 / 0;
                System.out.println(b);
            } catch (ArithmeticException e1) {
                System.out.println("Exception: e1");
            }
            try {
                System.out.println("Inside block2");
                int b = 45 / 0;
                System.out.println(b);
            } catch (ArrayIndexOutOfBoundsException e2) {
                System.out.println("Exception: e2");
            }
            System.out.println("Just other statement");
        } catch (ArithmeticException e3) {
            System.out.println("Arithmetic Exception");
            System.out.println("Inside parent try catch block");
        } catch (ArrayIndexOutOfBoundsException e4) {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println("Inside parent try catch block");
        } catch (Exception e5) {
            System.out.println("Exception");
            System.out.println("Inside parent try catch block");
        }
        System.out.println("Next statement..");
    }

}

