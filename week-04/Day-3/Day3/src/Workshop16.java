///**
// * File I/O: Dont forget to Write
// * <p>
// * There was once just ones and zeroes.  And it was bad, to tell the machine anything was a long
// * process of toggling these little switches Up or Down and then pressing a "Master" button.
// * Oh, but to be the head boy (there weren't any girls in our computer club back then) that got to
// * restart the computer...
// * <p>
// * This challenge, back in the day, would have been awe inspiring.  You're going to take input
// * from the scanner and copy such to a file.
// * <p>
// * This is how it should work, but NOTE ...
// * >>> means that what the computer does; and
// * <<< is what you the user does.
// * <p>
// * >>> Enter the filename (assuming writing to C:\TEMP\)?
// * <<< Test.txt
// * >>> Writing to Test.txt; when done press enter 3 times.
// * <<< Mary had a little lamb
// * <<< Her fleece as white as snow
// * <<< And everywhere that Mary went
// * <<< Her lamb was sure to go.
// * <<<
// * <<<
// * <<<
// * >>> Done, wrote 102 Characters to C:\TEMP\Test.txt.
// * <p>
// * There's also a little challenge of how to pass a variable into a routine and then
// * return it back (that's why I'm using Integer, the object)
// */
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Scanner;
//
//public class Workshop16 {
//
//    public static void main(String[] args) {
//        Scanner userInput = new Scanner(System.in);
////        System.out.println("Enter the filename (assuming writing to C:\\TEMP\\), or q to Quit");
//
//
//        String stuff = "";
//        String strNameOfFile = "";
////        Integer ctCharacters = new Integer(0);
////        ctCharacters = 0;
//
//        System.out.print("Path: ");
//        strNameOfFile = userInput.nextLine();
//        System.out.println("Contents: ");
//        stuff = userInput.nextLine();
//
//        try {
//            writeStuff(strNameOfFile, stuff);
//        } catch (IOException e) {
//            System.out.println("Sum-ting-wong");
//            System.exit(1);
//        }
//
//        //complete this, remember the ctCharacters
//    }
//
//
//
//
//    private static void writeStuff(String pathToList, String whatToWrite) throws IOException {
//        File file = new File(pathToList);
//
//        // creates the file
//        file.createNewFile();
//
//        // creates a FileWriter Object
//        FileWriter writer = new FileWriter(file);
//
//        // Writes the content to the file
//        writer.write(whatToWrite);
//        writer.flush();
//        writer.close();
//
//        // Creates a FileReader Object
//        FileReader fr = new FileReader(file);
//        char[] a = new char[50];
//        fr.read(a);   // reads the content to the array
//
//        for (char c : a)
//            System.out.print(c);   // prints the characters one by one
//        fr.close();
//    }
//
//}