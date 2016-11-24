package triplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


/**
 * Created by Söp on 2016.11.24. GameBoard
 */
class GameBoard extends JPanel{
    private ArrayList<BoardTile> board = new ArrayList<>();

    GameBoard(TGame game) {

        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridLayout(3,3));

        for (int i = 1; i <= 9; i++) {
            this.board.add(new BoardTile(game));
            this.add(getTile(i - 1));
        }

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    private BoardTile getTile(int n) {
        return board.get(n);
    }

    void reset() {
        for(int i = 0; i < board.size(); i++) {
            getTile(i).setTileText(" ");
        }
    }


}
