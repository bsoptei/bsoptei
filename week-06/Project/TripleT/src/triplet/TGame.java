package triplet;

/**
 * Created by Söp on 2016.11.24. Diz iz da game
 */
class TGame {
    private int scoreX;
    private int scoreO;
    private int round;


    TGame() {
        this.round = 0;
        this.scoreX = 0;
        this.scoreO = 0;
    }


    private void setRound(int n) {
        this.round = n;
    }

    int getRound() {
        return round;
    }

    void incrementRound() {
        this.round++;
    }

    void reset() {
        this.setRound(0);
    }


}
