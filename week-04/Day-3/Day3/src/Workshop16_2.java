import java.io.*;
import java.util.Scanner;

public class Workshop16_2 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
//        System.out.println("Enter the filename (assuming writing to C:\\TEMP\\), or q to Quit");


        String stuff = "";
        String strNameOfFile = "";
//        Integer ctCharacters = new Integer(0);
//        ctCharacters = 0;

        System.out.print("Path: ");
        strNameOfFile = userInput.nextLine();
        System.out.println("Contents: ");
        stuff = userInput.nextLine();

        try {
            writeStuff(strNameOfFile, stuff);
        } catch (IOException e) {
            System.out.println("IOException!");
            System.exit(1);
        }

        //complete this, remember the ctCharacters
    }


    private static void writeStuff(String pathToList, String whatToWrite) throws IOException {

        BufferedWriter bw = null;
        try {
            String mycontent = whatToWrite;
            //Specify the file name and path here
            File file = new File(pathToList);

	 /* This logic will make sure that the file
      * gets created if it is not present at the
	  * specified location*/
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(mycontent);
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

}

