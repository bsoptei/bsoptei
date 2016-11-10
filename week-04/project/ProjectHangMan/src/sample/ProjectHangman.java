//package sample;
//
//import java.io.*;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//
//public class ProjectHangman{
//    static Scanner userGuess = new Scanner(System.in);
//    static int numberOfWrongGuesses = 0;
//    static String riddle;
//    static ArrayList<Character> lettersOfRiddle = new ArrayList<>();
//    static StringBuilder lettersHidden = new StringBuilder();
//    static ArrayList<String> wordList = new ArrayList<>();
//
//    public static void main(String[] args) {
//        System.out.println("Welcome to H4NGM4N!");
//        System.out.println("Generating your word...");
//
//        riddle = getRiddle();
//
//        for (int index = 0; index < riddle.length(); index++) {
//            lettersOfRiddle.add(riddle.charAt(index));
//            lettersHidden.append("_");
//        }
//        displayRiddle();
//        while (numberOfWrongGuesses < riddle.length() + 2 && lettersHidden.toString().contains("_")) {
//
//            playGame();
//        }
//    }
//
//    static String getRiddle() {
//        Path file = Paths.get("C:\\Users\\Söp\\IdeaProjects\\ProjectHangMan\\src\\sample\\source.txt");
//        Charset charset = Charset.forName("UTF-8");
//        String riddle = null;
//        try (
//                BufferedReader reader = Files.newBufferedReader(file, charset)) {
//
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                wordList.add(line);
//            }
//
//        } catch (
//                IOException x) {
//            System.err.format("IOException: %s%n", x);
//        }
//        Random r = new Random();
//        int low = 0;
//
//        int high = wordList.size();
//        int Result = r.nextInt(high - low) + low;
//        riddle = wordList.get(Result);
//        return riddle;
//    }
//
//    static void displayRiddle() {
//        for (int index = 0; index < lettersOfRiddle.size(); index++) {
//            if (lettersHidden.charAt(index) == '_') {
//                System.out.print(" _ ");
//            } else {
//                System.out.printf(" %s ", lettersOfRiddle.get(index));
//            }
//        }
//    }
//
//    static void playGame() {
//        String guess;
//        System.out.printf("(%s)", riddle);
//        System.out.println("\n");
//        System.out.print("Enter a letter:");
//        guess = userGuess.nextLine().toUpperCase();
//        if (riddle.contains(guess)) {
//            for (int index = 0; index < lettersOfRiddle.size(); index++) {
//                if (riddle.charAt(index) == guess.charAt(0)) {
//                    lettersHidden.setCharAt(index, guess.charAt(0));
//                }
//            }
//        } else {
//            numberOfWrongGuesses++;
//        }
//        displayRiddle();
//    }
//}
//
