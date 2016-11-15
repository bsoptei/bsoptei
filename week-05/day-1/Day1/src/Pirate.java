
import java.util.ArrayList;
import java.util.Random;

/***
 Workshop03
 ***/

public class Pirate {
    int numberOfRums;
    int status;
    // 0: dead; 1: living and awake;2: passed out
    String name;
    ArrayList<Object> inventory = new ArrayList<>();

    public Pirate(String name) {
        this.name = name;
        this.numberOfRums = 0;
        this.status = 1;
    }


    public void drinkSomeRum() {
        if (status == 1) {
            this.numberOfRums++;
            System.out.println("Wubba-lubba-dub-dub!");
        } else if (status == 2) {
            System.out.printf("%s is passed out yo!\n", name);
        } else {
            System.out.printf("%s is bloody dead!\n", name);
        }
    }

    public String howsItGoingMate() {
        if (status == 1) {
            if (numberOfRums < 5) {
                return "Pour me anudder!";
            } else {
                this.passOut();
                return "Arghh, I'ma Pirate. How d'ya d'ink its goin?";
            }
        } else if (status == 0) {
            return "Dead.";
        } else {
            return "...";
        }
    }

    public void wakeUp() {
        if (status == 2) {
            this.status = 1;
            System.out.println("Aight! Gimme morrre rrrrrrrrrummmmah!");
        } else if (status == 1) {
            System.out.println("Arradyawaaaayk!");
        } else {
            System.out.printf("%s is dead!\n", name);
        }
    }

    public void die() {
        if (status != 0) {
            this.status = 0;
            System.out.printf("Pirate %s is now dead...\n", name);
        } else {
            System.out.printf("%s is already dead!", name);
        }

    }

    public int getStatus() {
        return status;
    }

    public void passOut() {
        if (status != 2) {
            this.status = 2;
            System.out.printf("Pirate %s is now passed out...\n", name);
        } else {
            System.out.println("Nah!");
        }
    }

    public void brawl(Pirate opponent) {
        if (status > 0 && opponent.status > 0) {
            Random r = new Random();
            if (r.nextInt(3) == 0) {
               die();
            } else if (r.nextInt(3) == 1) {
                opponent.die();
            } else {
                passOut();
                opponent.passOut();
            }
        } else {
            System.out.println("Can't do.");
        }
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("%s, (%d)", name, status);
    }
}