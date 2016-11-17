package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

class Game {
    private static ArrayList<String> goodRemarks = new ArrayList<>();
    private static ArrayList<String> badRemarks = new ArrayList<>();
    private static ArrayList<String> riddles = new ArrayList<>();
    private StringBuilder lettersHidden = new StringBuilder();
    private String riddle;
    private int numberOfWrongGuesses = 0;
    private boolean gameRunning = false;
    private int winOrLose = 0;

    Game() {
        this.gameRunning = true;
        riddles = getDataFromFile(Paths.get("src/sample/docs/source.txt"));
        this.riddle = generateRiddle();
        setLettersHidden();
        goodRemarks = getDataFromFile(Paths.get("src/sample/docs/good.txt"));
        badRemarks = getDataFromFile(Paths.get("src/sample/docs/bad.txt"));
    }

    boolean isGameRunning() {
        return gameRunning;
    }

    private String generateRiddle() {
        riddle = riddles.get(generateRandomNumber(riddles.size()));
        return riddle;
    }

    String getRiddle() {
        return riddle;
    }

    String getFunnyRemarks(boolean goodAnswer) {
        if (goodAnswer) {
            return goodRemarks.get(generateRandomNumber(goodRemarks.size()));
        } else {
            return badRemarks.get(generateRandomNumber(badRemarks.size()));
        }
    }

    StringBuilder getLettersHidden() {
        return lettersHidden;
    }

    private void setLettersHidden() {
        for (int index = 0; index < riddle.length(); index++) {
            this.lettersHidden.append("_");
        }
    }

    private ArrayList<String> getDataFromFile(Path path) {
        ArrayList<String> wordList = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        try (
                BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (
                IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return wordList;
    }

    private int generateRandomNumber(int upperLimit) {
        Random random = new Random();
        return random.nextInt(upperLimit);
    }

    boolean checkInput(String guess) {
        if (riddle.contains(guess.toUpperCase())) {
            for (int i = 0; i < riddle.length(); i++) {
                if (riddle.charAt(i) == guess.toUpperCase().charAt(0)) {
                    lettersHidden.setCharAt(i, guess.toUpperCase().charAt(0));
                }
            }
            return true;
        } else {
            numberOfWrongGuesses++;
            return false;
        }
    }

    int getNumberOfWrongGuesses() {
        return numberOfWrongGuesses;
    }

    int getWinOrLose() {
        return winOrLose;
    }

    void setWinOrLose(int winOrLose) {
        this.winOrLose = winOrLose;
    }

    void terminate() {
        this.gameRunning = false;
    }

}
