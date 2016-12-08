package wanderer;

import javax.swing.*;
//import java.awt.*;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05.. The logic behind the game
 */
class GameLogic implements GameMeetingPoint {
    private Hero hero;

    private boolean keyHolderIsKilled() {
        return !gameArea.getKeyHolder().isAlive();
    }

    private boolean bossIsKilled() {
        return !gameArea.getBoss().isAlive();
    }

    void update() {
        gameArea.updateCharacterPositions();
        if (!hero.isAlive()) {
            JOptionPane.showMessageDialog(null, "Game Over!");
        }
        if (hero.getNumberOfMoves() % 2 == 0) {
            moveEnemiesRandomly();
        }

        if (bossIsKilled() && keyHolderIsKilled()) {
            gameArea.reset();
        }
//        Toolkit tk = Toolkit.getDefaultToolkit();
        if (gameArea.isInSamePosition()) {
            hero.setCurrentOpponent(gameArea.getBattleEnemy());
//            System.out.println(gameArea.getBattleEnemy());
        } else {
            hero.setCurrentOpponent(null);
        }
    }

    private void moveEnemiesRandomly() {
        Random randomMove = new Random();
        for (GameObject enemy : gameArea.getEnemies()) {
            if (randomMove.nextInt(2) == 0) {
                enemy.move(randomMove.nextInt(3) - 1, 0);
            } else {
                enemy.move(0, randomMove.nextInt(3) - 1);
            }
        }
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
