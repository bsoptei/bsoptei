package wanderer;

import javax.swing.*;

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
        if (hero.getNumberOfMoves() % 2 == 0) {
            moveEnemiesRandomly();
        }

        if (bossIsKilled() && keyHolderIsKilled()) {
            gameArea.reset();
        }
        if (gameArea.isInSamePosition()) {
            gameArea.getBattleEnemy().strike();
            hero.setCurrentOpponent(gameArea.getBattleEnemy());
        } else {
            hero.setCurrentOpponent(null);
        }
        if (!hero.isAlive()) {
            JOptionPane.showMessageDialog(null, "Game Over!");
        }
    }

    private void moveEnemiesRandomly() {
        for (GameObject enemy : gameArea.getEnemies()) {
            if (dice.nextInt(2) == 0) {
                enemy.move(dice.nextInt(3) - 1, 0);
            } else {
                enemy.move(0, dice.nextInt(3) - 1);
            }
        }
    }

    void setHero(Hero hero) {
        this.hero = hero;
    }
}
