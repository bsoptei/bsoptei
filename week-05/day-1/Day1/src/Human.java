/**
 * Created by Söp on 2016.11.13..
 */
public class Human {
    boolean hungry;
    int coins;
    int age;
    String name;

    public Human() {
        this.hungry = true;
        this.coins = 100;
        this.age = 18;
        this.name = "";
    }

    public void eat() {
        if (this.hungry) {
            if (coins > 1) {
                hungry = false;
                this.coins--;
                System.out.printf("Now %s is fed.\n", name);
            } else {
                System.out.printf("Sorry man, %s is broke.\n", name);
            }

        } else {
            System.out.printf("%s is not hungry. %s should not eat.\n", name, name);
        }

    }

    public void liveABit() {
        this.hungry = true;
        System.out.printf("%s is living a bit. Living made %s hungry.\n", name, name);
    }


    public static void main(String[] args) {

        Human johnDoe = new Human();
        johnDoe.name = "John Doe";
        do {
            johnDoe.eat();
            johnDoe.liveABit();
            System.out.printf("%s has %d coins left.\n", johnDoe.name, johnDoe.coins);
        } while (johnDoe.coins > 1);
        johnDoe.eat();
    }

}
