package wanderer;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    public Area gameArea = new Area(1);
    public GameObject hero = gameArea.getHero();

    public Board() {
        setProperties();
        this.setLayout(new BorderLayout());

        JPanel statPanel = new JPanel();
        statPanel.setPreferredSize(new Dimension(200,300));
        JLabel statText = new JLabel();


        statPanel.setLocation(720, 200);
        statText.setText("kurvaanyad");

        statPanel.add(statText);

        this.add(statPanel, BorderLayout.EAST);
        addKeyListenerToBoard();

        this.setVisible(true);
    }

    public void setProperties(){
        this.setPreferredSize(new Dimension(720, 720));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
    }

    private void addKeyListenerToBoard() {
        ListenForKeyPress boardKeyListener = new ListenForKeyPress();
        this.addKeyListener(boardKeyListener);
        boardKeyListener.setBoard(this);
        boardKeyListener.setGameObject(hero);
    }

    @Override
    public void paint(Graphics graphics) {
        for( GameElement gameElement : gameArea.getTiles()) {
            gameElement.getTileImage().draw(graphics);
        }
        hero.getTileImage().draw(graphics);
    }
}