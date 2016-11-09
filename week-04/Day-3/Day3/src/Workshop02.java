public class Workshop02{
    public static void main(String[] args){
        String[] numbers = new String[] { "one", "two", "three", "four", "five"};
        try {
            for (int i = 0; i <= numbers.length; i++) {
                System.out.printf("%d=%s\n", i, numbers[i]);

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("EXCEPTION %s: index is out of bounds!\n", e.toString());
        }
        System.out.println("::::FINISH LINE::::");
    }
}
