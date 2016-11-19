package sample;

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
    private ArrayList<String> storedGameData = new ArrayList<>();
    private FileManager gameFiles = new FileManager();

    Game() {
        this.gameRunning = true;
        checkData();
        this.riddle = generateRiddle();
        setLettersHidden();
        this.storedGameData = gameFiles.getDataFromFile(Paths.get("src/sample/docs/stored.txt"), true);
    }

    private void checkData() {
        if (riddles.isEmpty()) {
            riddles = gameFiles.getDataFromFile(Paths.get("src/sample/docs/source.txt"), false);
        }
        if (goodRemarks.isEmpty()) {
            goodRemarks = gameFiles.getDataFromFile(Paths.get("src/sample/docs/good.txt"), false);
        }
        if (badRemarks.isEmpty()) {
            badRemarks = gameFiles.getDataFromFile(Paths.get("src/sample/docs/bad.txt"), false);
        }
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

    void setWinOrLose(int winOrLose) {
        this.winOrLose = winOrLose;
    }

    void terminate() {
        gameFiles.writeGameDataToFile(getStoredGameData(), true);
        this.gameRunning = false;
    }

    ArrayList<String> getStoredGameData() {
        return storedGameData;
    }

    void setStoredGameData(int won, int lost) {
        this.storedGameData.set(0, Integer.toString(won));
        this.storedGameData.set(1, Integer.toString(lost));
    }

    int checkIfGameShouldEnd() {
        if (numberOfWrongGuesses >= 7) {
            return -1;
        } else if (!lettersHidden.toString().contains("_")) {
            return +1;
        } else {
            return 0;
        }
    }
}
