import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Workshop15 {
    static File fileToOpen;
    public static void main(String[] args) {
        System.out.println("Enter the file path, or q to Quit");
        Scanner userInput = new Scanner(System.in);
        String filePath;
        System.out.print("File path: ");
        while(userInput.hasNextLine()){
            filePath = userInput.nextLine();
            if(filePath.equals("q"))
                break;
            printFileContent(filePath);
            System.out.print("File path: ");
        }
    }
    private static void printFileContent (String filePath) {
        ArrayList<String> contents = new ArrayList<>();
        fileToOpen = new File(filePath);
        Charset charset = Charset.forName("UTF-8");
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                contents.add(line);
            }
        } catch ( IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        System.out.println(contents);
    }
}