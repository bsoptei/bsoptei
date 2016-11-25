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
    private String actualChar;

    BoardTile(TGame game, int id) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setAlignmentY(CENTER_ALIGNMENT);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        this.tileText = new JLabel();
        this.tileText.setText(" ");
        this.setDefaultFont();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (game.getActive()) {
                    if (tileText.getText().equals(" ")) {
                        if (game.getRound() % 2 == 0) {
                            actualChar = "\u2601";
                            tileText.setForeground(Color.BLUE);
                        } else {
                            actualChar = "\u2602";
                            tileText.setForeground(Color.DARK_GRAY);
                        }
                        tileText.setText(actualChar);
                        game.updateStatus(id, actualChar);
                        game.incrementRound();
                    } else {
                        tk.beep();
                    }
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
                if (game.getActive()) {
                    tileText.setFont(new Font("", Font.BOLD, 110));
                    if (tileText.getText().equals(" ")) {
                        setBackground(Color.GREEN);
                    } else {
                        setBackground(Color.BLACK);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (game.getActive()) {
                    setRandomBackground();
                    setDefaultFont();
                }
            }
        });
        this.add(tileText);
    }

    void setDefaultFont() {
        this.tileText.setFont(new Font("", Font.PLAIN, 100));
    }

    void setTileText(String text) {
        this.tileText.setText(text);
    }

    void colorTileB(Color background) {
        this.setBackground(background);
    }

    void colorTileF(Color foreground) {
        this.tileText.setForeground(foreground);
    }

    void setRandomBackground() {
        this.setBackground(Color.getHSBColor((float)Math.random(), (float)Math.random(), (float)Math.random()));
    }
}
