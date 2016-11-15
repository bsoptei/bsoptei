/**
 * Created by Söp on 2016.11.15..
 */
public class Dog extends Animal {
    private boolean hasTail;

    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    public boolean getHasTail() {
        return hasTail;
    }

    public Dog() {
        super("dog");
        this.lifeExpectancy = 15;
        this.isCarnivore = true;
        this.hasTail = true;
    }

    public void speak(){
        System.out.println("barks");
    }

    public void beg(){
        System.out.println("begs");
    }

}
