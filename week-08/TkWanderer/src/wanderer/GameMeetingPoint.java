package wanderer;

/**
 * Created by Söp on 2016.12.07. Contains essential data
 */
interface GameMeetingPoint {
    Area gameArea = Creator.gameArea;
    Board board = Creator.drawPad ;
    GameLogic controller = Creator.controller;
    int imageSize = 72;
}
