package triplet;

import javax.swing.*;

/**
 * Created by Söp on 2016.11.24. triplet. Display
 */
public class Display extends JFrame {
    private GameBoard gameBoard;

    public Display() {
        this.setTitle("TripleT");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        gameBoard = new GameBoard();


        this.add(gameBoard);


        this.setVisible(true);
    }


    public void showBoard() {

    }

}
