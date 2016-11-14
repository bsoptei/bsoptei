package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    @FXML
    private Button myButton;
    @FXML
    private Text numberOfRemainingChances;
    @FXML
    private Text numberOfGamesWon;
    @FXML
    private Text numberOfGamesLost;

    private ArrayList<String> goodRemarks = new ArrayList<>();
    private ArrayList<String> badRemarks = new ArrayList<>();
    private ArrayList<String> riddles = new ArrayList<>();
    private StringBuilder lettersHidden = new StringBuilder();
    private String riddle;
    private int numberOfWrongGuesses;
    private boolean gameRunning = false;
    private int gamesWon;
    private int gamesLost;
    private HashMap<Integer, String> whichBackground = new HashMap<Integer, String>() {{
        put(0, "-fx-background-image: url(/sample/images/0.png);");
        put(1, "-fx-background-image: url(/sample/images/1.png);");
        put(2, "-fx-background-image: url(/sample/images/2.png);");
        put(3, "-fx-background-image: url(/sample/images/3.png);");
        put(4, "-fx-background-image: url(/sample/images/4.png);");
        put(5, "-fx-background-image: url(/sample/images/5.png);");
        put(6, "-fx-background-image: url(/sample/images/6.png);");
        put(7, "-fx-background-image: url(/sample/images/7.png);");
    }};

    public void buttonPress() {
        if (!gameRunning) {
            outputText.setText("");
            numberOfGamesWon.setText("Games won: " + gamesWon);
            numberOfGamesLost.setText("Games lost: " + gamesLost);
            numberOfWrongGuesses = 0;
            myHBox.setStyle(whichBackground.get(numberOfWrongGuesses));
            lettersHidden.delete(0, lettersHidden.length());
            gameRunning = true;
            myButton.setText("Submit");
            riddle = getRiddle();

        } else {
            checkInput(inputField.getText());
        }
        inputField.setText("");
        displayRiddle();
    }

    private void displayRiddle() {
        riddleText.setText(lettersHidden.toString());
        numberOfRemainingChances.setText("Remaining chances of failure: " + (7 - numberOfWrongGuesses));
        if (numberOfWrongGuesses > 0) {
            myHBox.setStyle(whichBackground.get(numberOfWrongGuesses));
        }
    }

    private String getRiddle() {
        if (riddles.isEmpty()) {
            riddles = getDataFromFile(Paths.get("src/sample/docs/source.txt"));
        }
        riddle = riddles.get(generateRandomNumber(riddles.size()));
        setHiddenContent();
        return riddle;
    }

    private void setHiddenContent() {
        for (int index = 0; index < riddle.length(); index++) {
            lettersHidden.append("_");
        }
    }

    private void checkIfGameShouldEnd() {
        if (numberOfWrongGuesses >= 7) {
            gameEnds(false);
        } else if (!lettersHidden.toString().contains("_")) {
            gameEnds(true);
        }
    }

    private void gameEnds(boolean userWon) {
        if (userWon) {
            outputText.setText("You won the game. I am devastated.");
            gamesWon++;
        } else {
            outputText.setText("You are dead! Hooray! The word was " + riddle);
            gamesLost++;
        }
        gameRunning = false;
        myButton.setText("New game");
    }

    private void checkInput(String guess) {
        if (riddle.contains(guess.toUpperCase())) {
            for (int i = 0; i < riddle.length(); i++) {
                if (riddle.charAt(i) == guess.toUpperCase().charAt(0)) {
                    lettersHidden.setCharAt(i, guess.toUpperCase().charAt(0));
                }
            }
            outputText.setText(getFunnyRemarks(true));
        } else {
            numberOfWrongGuesses++;
            outputText.setText(getFunnyRemarks(false));
        }
        checkIfGameShouldEnd();
    }

    private String getFunnyRemarks(boolean goodAnswer) {
        if (goodRemarks.isEmpty()) {
            goodRemarks = getDataFromFile(Paths.get("src/sample/docs/good.txt"));
        }
        if (badRemarks.isEmpty()) {
            badRemarks = getDataFromFile(Paths.get("src/sample/docs/bad.txt"));
        }
        if (goodAnswer) {
            return goodRemarks.get(generateRandomNumber(goodRemarks.size()));
        } else {
            return badRemarks.get(generateRandomNumber(badRemarks.size()));
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

}