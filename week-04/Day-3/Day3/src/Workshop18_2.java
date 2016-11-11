import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Söp on 2016.11.11..
 * A different approach for the comparison of two separate, but already sorted arrays
 */
public class Workshop18_2 {
    public static void main(String[] args) {
        BufferedReader bufferA = null;
        BufferedReader bufferB = null;
        try {
            bufferA = new BufferedReader(new FileReader("src/W18A.txt"));
            bufferB = new BufferedReader(new FileReader("src/W18B.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        try {
            String lineA = bufferA.readLine();
            String lineB = bufferB.readLine();
            boolean end = false;
            while (!end) {
                int a = Integer.parseInt(lineA);
                int b = Integer.parseInt(lineB);
                if (a < b) {
                    System.out.println(a);
                    lineA = bufferA.readLine();
                } else {
                    System.out.println(b);
                    lineB = bufferB.readLine();
                }
                if (lineA == null || lineB == null) {
                    end = true;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException!!!!!!!!!!");
        }

    }
}

