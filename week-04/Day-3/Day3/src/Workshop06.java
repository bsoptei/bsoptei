/**************************************************************************************************
 * Workshop: Practice Exceptions: Nested Try Catch - 2nd situation
 *
 * Run this and explain what is going on
 *
 * The iteration at line15 results in an Array Index Out Of Boundary Exception
 * The catch blocks between line 18 and 33 deal with Arithmetic Exception only.
 * Thus, this other type of exception is caught only in the main block.
 *
 **************************************************************************************************/

public class Workshop06{
    public static void main(String[] args){
        try{
            try{
                try{
                    int arr[]= {1,2,3,4};
                    System.out.println(arr[10]);
                }catch(ArithmeticException e){
                    System.out.print("Arithmetic Exception");
                    System.out.println(" handled in try-block3");
                }
            }
            catch(ArithmeticException e){
                System.out.print("Arithmetic Exception");
                System.out.println(" handled in try-block2");
            }
        }
        catch(ArithmeticException e3){
            System.out.print("Arithmetic Exception");
            System.out.println(" handled in main try-block");
        }
        catch(ArrayIndexOutOfBoundsException e4){
            System.out.print("ArrayIndexOutOfBoundsException");
            System.out.println(" handled in main try-block");
        }
        catch(Exception e5){
            System.out.print("Exception");
            System.out.println(" handled in main try-block");
        }
    }

}
