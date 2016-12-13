package wanderer;

import javax.swing.*;

/**
 * Created by Söp on 2016.12.09.. Send you messages
 */
public class Courier {
    static void showWelcome() {
        JOptionPane.showMessageDialog(null, "Welcome to my maze!\nNeed help? Press F1 any time during the game.");
    }

    static void showHelp() {
        JOptionPane.showMessageDialog(null, "Help:\nYou are the green-haired fella. \n" +
                "You can move with the arrow keys.\n" +
                "When you're on the same tile with an enemy,\n" +
                "you can use spacebar to strike.\n" +
                "If you kill the keyholder and the boss, you can move to the next area.\n" +
                "F2 starts new game.\n" +
                "Esc quits.");
    }

    static void showGameOver() {
        JOptionPane.showMessageDialog(null, "Game Over!\n You can start new game by pressing F2");
    }

    static void showAreaClearedMessage() {
        JOptionPane.showMessageDialog(null, "Congrats! You have cleared the area!\n Get ready for the next one!");
    }
}
