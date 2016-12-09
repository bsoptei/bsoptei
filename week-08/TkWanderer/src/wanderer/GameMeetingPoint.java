package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07. Contains essential data
 */
interface GameMeetingPoint {
    Area gameArea = Creator.gameArea;
    Board board = Creator.board;
    GameLogic controller = Creator.controller;
    int imageSize = 40;
    Random dice = new Random();
    Hero hero = Creator.hero;
}
