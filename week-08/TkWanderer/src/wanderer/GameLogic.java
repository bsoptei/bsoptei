package wanderer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05.. The logic behind the game
 */
public class GameLogic {

    public Area gameArea;
    public boolean keyHolderKilled;
    public boolean bossKilled;
    private Hero hero;

    public GameLogic() {

    }

    public boolean keyHolderIsKilled() {
        return !gameArea.getKeyHolder().isAlive();
    }

    public boolean bossIsKilled() {
        return !gameArea.getBoss().isAlive();
    }


    public void setGameArea(Area gameArea) {
        this.gameArea = gameArea;
    }

    void update() {
        if (hero.getNumberOfMoves() % 2 == 0) {
            moveEnemiesRandomly();
        }

        if (bossIsKilled() && keyHolderIsKilled()) {
            gameArea.reset();
        }
        Toolkit tk = Toolkit.getDefaultToolkit();
        if (gameArea.isInSamePosition()) {
            tk.beep();
            System.out.println(gameArea.getBattleEnemy());
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
