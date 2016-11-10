import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Workshop13 {

    public static void main(String[] args) {

        System.out.println("Please provide an absolute path and I will list the contents of it! (Type 'q' to quit)");

        Scanner userInput = new Scanner(System.in);

        String pathToList;

        System.out.print("Path: ");

        while (userInput.hasNextLine()) {
            pathToList = userInput.nextLine();
            if (pathToList.equals("q"))
                break;
            decider(pathToList);
            System.out.print("Path: ");
        }
    }

    private static void decider(String pathToList) {
        File fileOrDirectory = new File(pathToList);
        if (fileOrDirectory.exists()) {
            if (!fileOrDirectory.isFile()) {
                printDirectoryContents(fileOrDirectory);
            } else {
                File fileParent = new File(fileOrDirectory.getParent());
                printDirectoryContents(fileParent);
            }
        } else {
            System.out.println("The specified path does not exist!");
        }
    }

    private static void printDirectoryContents(File directory) {
        String[] files = directory.list();
        for (String file : files) {
            System.out.println(file);
        }
    }
}
