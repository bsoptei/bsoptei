package triplet;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Söp on 2016.11.24. triplet. Display
 */
public class Display {
    private TGame myGame;


    public Display() {
        JFrame display = new JFrame();
        display.setTitle("TripleT");
        display.setSize(600, 400);
        display.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        display.setLocationRelativeTo(null);
        display.setResizable(false);
        display.setLayout(new BorderLayout());


        JPanel menuPanel = new JPanel();

        menuPanel.setBackground(Color.WHITE);

        menuPanel.setSize(new Dimension(100, 100));
        menuPanel.setLayout(new BorderLayout());
        // Setup game menu
        JMenuBar gameMenuBar = new JMenuBar();

        myGame = new TGame();
        GameBoard gameBoard = new GameBoard(myGame);


        JMenu gameMenu = new JMenu("Game");
        JMenuItem newGame = new JMenuItem("New");
        JMenuItem exit = new JMenuItem("Exit");

        newGame.addActionListener(e -> {
            myGame.reset();
            gameBoard.reset();
        });


        exit.addActionListener(e -> System.exit(0));


        gameMenu.add(newGame);
        gameMenu.add(exit);
        gameMenuBar.add(gameMenu);

        menuPanel.add(gameMenuBar);



        display.add(menuPanel, BorderLayout.NORTH);
        display.add(gameBoard, BorderLayout.CENTER);

        display.pack();
        display.setVisible(true);
    }

}
