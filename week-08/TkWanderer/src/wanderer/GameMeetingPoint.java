package wanderer;

/**
 * Created by Söp on 2016.12.07. Clever interface
 */
interface GameMeetingPoint {
    Area gameArea = Creator.gameArea;
    Board board = Creator.drawPad ;
    GameLogic controller = Creator.controller;
//    Hero hero = Creator.hero;
}
