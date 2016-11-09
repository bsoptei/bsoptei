import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTest {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.print("Enter regex to search: ");
            Pattern pattern = Pattern.compile(userInput.next());
            System.out.print("Enter your string to search in: ");
            Matcher matcher = pattern.matcher(userInput.next());

            boolean found = false;
            while (matcher.find()) {
                System.out.printf("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if (!found) {
                System.out.printf("No match found.%n");
            }
            System.out.print("Enter \"N\" for new search, or anything else to quit: ");
            String wantNewSearch = userInput.next();
            if (!(wantNewSearch.equalsIgnoreCase("N"))) {
                continueLoop = false;
            }
        }
    }
}