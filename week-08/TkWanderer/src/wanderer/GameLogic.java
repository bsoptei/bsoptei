package wanderer;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Söp on 2016.12.05.. The logic behind the game
 */
class GameLogic implements GameMeetingPoint {

    void update() {
        gameArea.updatePlayerPositions();
        if (hero.getNumberOfMoves() % 2 == 0) {
            moveEnemiesRandomly();
        }

        if (bossIsKilled() && keyHolderIsKilled()) {
            gameArea.generateMap();
            gameArea.reset();
            Courier.showAreaClearedMessage();
        }
        if (gameArea.isInSamePosition()) {
            gameArea.getBattleEnemy().strike();
            hero.setCurrentOpponent(gameArea.getBattleEnemy());
        } else {
            hero.setCurrentOpponent(null);
        }
        if (!hero.isAlive()) {
            Courier.showGameOver();
        }
    }

    private boolean keyHolderIsKilled() {
        return !gameArea.getKeyHolder().isAlive();
    }

    private boolean bossIsKilled() {
        return !gameArea.getBoss().isAlive();
    }

    void heroMove(int xDirection, int yDirection) {
        hero.move(xDirection, yDirection);
    }

    void heroStrike() {
        hero.strike();
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

    void startNewGame() {
        hero.initHero();
        Area.level = 0;
        gameArea.reset();
    }

    void saveGame() {
        ArrayList<Integer> numericDataToSave = new ArrayList<>();
    }

    void loadGame() {
        ArrayList<String> loadedRawData = FileManager.readFile("src/wanderer/savedgame/savedgame.txt");
        ArrayList<Integer> loadedNumericData =
                loadedRawData.stream().map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }
}
