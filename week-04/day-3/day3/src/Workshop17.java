import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Workshop17 {
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the Source filename: ");
        File sourceFile = new File(userInput.nextLine());
        System.out.print("Enter the Destination filename: ");
        File destinationFile = new File(userInput.nextLine());
        try {
            copyFileUsingApacheCommonsIO(sourceFile, destinationFile);
        } catch (IOException e){
            System.out.println("IOException!!!!!!!!!!");
        }
    }

    private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
        String confirm = "";
        while (!confirm.equalsIgnoreCase("N") && !confirm.equalsIgnoreCase("Y")) {
            System.out.printf("Writing from %s to %s. Press Y to confirm, N to abort: ", source, dest);
            confirm = userInput.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                Files.copy(source.toPath(), dest.toPath());
                System.out.printf("Done, copied %d bytes.", dest.length());
            }
        }
    }
}
