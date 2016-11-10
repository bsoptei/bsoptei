import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Workshop13 {

    public static void main(String[] args) {

        System.out.println("Please provide an absolute path and I will list the contents of it! (Type 'q' to quit)");

        Scanner userInput = new Scanner(System.in);

        String pathToList;

        System.out.print("Path: ");

        while(userInput.hasNextLine()){
            pathToList = userInput.nextLine();
            if(pathToList.equals("q"))
                break;
            printDirectoryContents(pathToList);
            System.out.print("Path: ");
        }
    }

    private static void printDirectoryContents(String pathToList) {
        File directory = new File(pathToList);
        String[] files = directory.list();
        for (String file: files) {
            System.out.println(file);
        }


        // Implement this function
        // List all files and directories at the specified path
        // If a specified path does not exist write "The specified path does not exists!"
        // If a specified path is a file and not a directory then list all the contents of the specified file's parent
        // directory (example: input is c:\myfolder\myfile.txt then the function should list contents of c:\myfolder\
    }
}