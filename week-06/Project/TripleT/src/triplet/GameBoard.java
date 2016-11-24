package triplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.24. GameBoard
 */
public class GameBoard extends JPanel{
    ArrayList<JLabel> board = new ArrayList<>();

    public GameBoard() {
        this.setLayout(new GridLayout(3,3));

        for (int i = 1; i <= 9; i++) {

        }

    }

}
