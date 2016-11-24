package triplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Söp on 2016.11.24. Tiles in board
 */
class BoardTile extends JPanel {
    private JLabel tileText;


    BoardTile(TGame game) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setAlignmentY(CENTER_ALIGNMENT);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        this.tileText = new JLabel();
        this.tileText.setText(" ");
        this.tileText.setFont(new Font("Courier New", Font.BOLD, 120));
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tileText.getText().equals(" ")) {
                    if (game.getRound() % 2 == 0) {
                        tileText.setForeground(Color.MAGENTA);
                        tileText.setText("X");
                    } else {
                        tileText.setForeground(Color.DARK_GRAY);
                        tileText.setText("O");
                    }
                    game.incrementRound();
                } else {
                    tk.beep();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (tileText.getText().equals(" ")) {
                    setBackground(Color.GREEN);
                } else {
                    setBackground(Color.RED);
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.WHITE);
            }
        });
        this.add(tileText);

    }

    void setTileText(String text) {
        this.tileText.setText(text);
    }


}
