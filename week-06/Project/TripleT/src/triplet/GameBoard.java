package triplet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.24. GameBoard
 */
class GameBoard extends JPanel {
    private ArrayList<BoardTile> board = new ArrayList<>();

    GameBoard(TGame game) {
        game.setBoard(this);
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridLayout(3, 3));

        for (int i = 1; i <= 9; i++) {
            this.board.add(new BoardTile(game, i));
            this.add(getTile(i - 1));
        }
        setMessage("HELLO!   ");

    }

    private BoardTile getTile(int n) {
        return board.get(n);
    }

    void reset() {
        for (int i = 0; i < board.size(); i++) {
            getTile(i).setTileText(" ");
            getTile(i).colorTileB(Color.WHITE);
        }
    }

    void setMessage(String message) {
        for (int i = 0; i < board.size(); i++) {
            getTile(i).colorTileB(Color.BLACK);
            getTile(i).colorTileF(Color.YELLOW);
            getTile(i).setTileText(String.valueOf(message.charAt(i)));
        }
    }

}
