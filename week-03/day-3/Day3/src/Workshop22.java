public class Workshop22{
    public static void main(String... args) {
        // create a function which prints the input String parameters (can have multiple number of arguments)
        String myString = "Green Fox";
        stringParam(myString);
    }
    public static void stringParam(String inputString) {
        inputString = inputString.trim();
        if (inputString.isEmpty()) {
            System.out.println("The string is empty.");
        }
        else {
            System.out.printf("Length of the string is: %d characters \n", inputString.length());
            System.out.printf("First character of the string is: %s\n", inputString.charAt(0));
            System.out.printf("Last character of the string is: %s", inputString.charAt(inputString.length() - 1));
        }
    }
}