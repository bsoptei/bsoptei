package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;

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

    private ArrayList<Game> games = new ArrayList<>();
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
        if (games.isEmpty() || (!games.isEmpty() && !currentGame().isGameRunning())) {
            games.add(new Game());
            outputText.setText("");
            numberOfGamesWon.setText("Games won: " + gamesWon);
            numberOfGamesLost.setText("Games lost: " + gamesLost);
            myHBox.setStyle(whichBackground.get(currentGame().getNumberOfWrongGuesses()));
            myButton.setText("Submit");
        } else {
            if (!inputField.getText().isEmpty()) {
                if (currentGame().checkInput(inputField.getText())) {
                    outputText.setText(currentGame().getFunnyRemarks(true));
                } else {
                    outputText.setText(currentGame().getFunnyRemarks(false));
                }
                if (currentGame().getNumberOfWrongGuesses() >= 7) {
                    gameEnds(false);
                } else if (!currentGame().getLettersHidden().toString().contains("_")) {
                    gameEnds(true);
                }
            }
            inputField.setText("");
            inputField.requestFocus();
        }
        displayRiddle();
    }

    private void displayRiddle() {
        riddleText.setText(currentGame().getLettersHidden().toString());
        numberOfRemainingChances.setText("Remaining chances of failure: " + (7 - currentGame().getNumberOfWrongGuesses()));
        if (currentGame().getNumberOfWrongGuesses() > 0) {
            myHBox.setStyle(whichBackground.get(currentGame().getNumberOfWrongGuesses()));
        }
    }

    private void gameEnds(boolean userWon) {
        if (userWon) {
            outputText.setText("You won the game. I am devastated.");
            gamesWon++;
        } else {
            outputText.setText("You are dead! Hooray! The word was " + currentGame().getRiddle());
            gamesLost++;
        }
        myButton.setText("New game");
        currentGame().terminate();
    }

    private Game currentGame() {
        return games.get(games.size() - 1);
    }
}