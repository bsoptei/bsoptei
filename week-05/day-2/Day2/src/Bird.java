/**
 * Created by Söp on 2016.11.15..
 */
public class Bird extends Animal {

    public Bird() {
        super("bird");
    }

    public void fly() {
        System.out.println("The bird can fly");
    }

    public void sleep(boolean callSuper) {
        if (callSuper) {
            super.sleep();
        } else {
            System.out.println("Bird is sleeping");
        }
    }

    public void nightyNight() {
        super.eat();
        sleep(false);
    }

    public void speak() {
        System.out.println("chirps");
    }
}
