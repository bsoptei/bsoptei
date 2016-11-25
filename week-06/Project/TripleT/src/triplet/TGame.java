package triplet;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Söp on 2016.11.24. Diz iz da game
 */
class TGame {
    private int round;
    private HashMap<Integer, String> status = new HashMap<>();
    private String winner;
    private boolean active;
    private GameBoard board;
    private boolean drawGame;

    TGame() {
        this.round = 0;
        this.winner = "";
        this.active = false;
        setDrawGame(true);
    }

    private void setRound(int n) {
        this.round = n;
    }

    int getRound() {
        return round;
    }

    void incrementRound() {
        this.round++;
    }

    void reset() {
        this.setRound(0);
        setDrawGame(true);
        this.status.clear();
        this.winner = "";
        setActive(true);
    }

    void updateStatus(int index, String value) {
        this.status.put(index, value);
        checkWinner();
    }

    private void checkWinner() {
        compareElementsInStatusMap(1, 7, 3, 1);
        compareElementsInStatusMap(1, 3, 1, 3);
        compareElementsInStatusMap(1, 1, 1, 4);
        compareElementsInStatusMap(3, 3, 1, 2);
        if (status.size() > 8 && getDrawGame()) {
            setDraw();
        }
    }

    private void compareElementsInStatusMap(int start, int end, int increment, int diff) {
        for (int i = start; i <= end; i += increment) {
            if (status.containsKey(i)) {
                if (Objects.equals(status.get(i), status.get(i + diff)) &&
                        Objects.equals(status.get(i + diff), status.get(i + 2 * diff))) {
                    setDrawGame(false);
                    setWinner(status.get(i));
                }
            }
        }

    }

    private void setWinner(String winnerChar) {
        this.winner = winnerChar;
        board.setMessage(winner + "==WINNER");
        setActive(false);
    }

    private void setDraw() {
        setActive(false);
        board.setMessage("LOSERS!!!");
    }

    void setBoard(GameBoard board) {
        this.board = board;
    }

    boolean getActive() {
        return active;
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    private void setDrawGame(boolean isItDraw) {
        this.drawGame = isItDraw;
    }

    private boolean getDrawGame(){
        return drawGame;
    }
}
