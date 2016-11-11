package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Controller {
    @FXML
    private Text riddleText;
    @FXML
    private Text outputText;
    @FXML
    private TextField inputField = null;
    @FXML
    private HBox myHBox;

    private static ArrayList<String> goodRemarks = new ArrayList<>();
    private static ArrayList<String> badRemarks = new ArrayList<>();
    private static StringBuilder lettersHidden = new StringBuilder();
    private static String riddle = getRiddle();
    private static int numberOfWrongGuesses = 0;
    private static int status = 0;

    private static HashMap<Integer, String> whichBackground = new HashMap<Integer, String>() {{
        put(1, "-fx-background-image: url(/sample/images/1.png);");
        put(2, "-fx-background-image: url(/sample/images/2.png);");
        put(3, "-fx-background-image: url(/sample/images/3.png);");
        put(4, "-fx-background-image: url(/sample/images/4.png);");
        put(5, "-fx-background-image: url(/sample/images/5.png);");
        put(6, "-fx-background-image: url(/sample/images/6.png);");
        put(7, "-fx-background-image: url(/sample/images/7.png);");
    }};

    public void displayRiddle() {
        riddleText.setText(lettersHidden.toString());
        if (numberOfWrongGuesses > 0) {
            myHBox.setStyle(whichBackground.get(numberOfWrongGuesses));
        }
    }

    public void submitUserGuess() {
        if (lettersHidden.toString().contains("_") && inputField.getText().length() > 0 && numberOfWrongGuesses < 7) {
            checkInput(inputField.getText());
        }
        inputField.setText("");
        displayRiddle();
        outputText.setText(getFunnyRemarks());
        if (!lettersHidden.toString().contains("_")) {
            outputText.setText("You won the game. I am devastated.");
        }
        if (numberOfWrongGuesses >= 7) {
            outputText.setText("You are dead! Hooray!");
        }
    }

    private static String getRiddle() {
        ArrayList<String> riddles = getDataFromFile(Paths.get("src/sample/docs/source.txt"));
        riddle = riddles.get(generateRandomNumber(riddles.size()));
        setGameVars();
        return riddle;
    }

    private static void setGameVars() {
        for (int index = 0; index < riddle.length(); index++) {
            lettersHidden.append("_");
        }
    }

    private static void checkInput(String guess) {
        if (riddle.contains(guess.toUpperCase())) {
            for (int i = 0; i < riddle.length(); i++) {
                if (riddle.charAt(i) == guess.toUpperCase().charAt(0)) {
                    lettersHidden.setCharAt(i, guess.toUpperCase().charAt(0));
                }
                status = 2;
            }
        } else {
            numberOfWrongGuesses++;
            status = 1;
        }
    }

    private static String getFunnyRemarks() {
        if (goodRemarks.isEmpty()) {
            goodRemarks = getDataFromFile(Paths.get("src/sample/docs/good.txt"));
        }
        if (badRemarks.isEmpty()) {
            badRemarks = getDataFromFile(Paths.get("src/sample/docs/bad.txt"));
        }
        if (status == 2) {
            return goodRemarks.get(generateRandomNumber(goodRemarks.size()));
        } else if (status == 1) {
            return badRemarks.get(generateRandomNumber(badRemarks.size()));
        } else {
            return "Start.";
        }
    }

    private static ArrayList<String> getDataFromFile(Path path) {
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

    private static int generateRandomNumber(int upperLimit) {
        Random random = new Random();
        return random.nextInt(upperLimit);
    }

}