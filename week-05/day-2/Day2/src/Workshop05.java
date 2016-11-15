/**
 * Created by Söp on 2016.11.15..
 */
public class Workshop05 {
    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle();
        System.out.println(myRectangle.toString());

        Block myBlock1 = new Block();
        System.out.println("Volume of myBlock1: " + myBlock1.getVolume() + " units!");
        System.out.println("Surface of myBlock1: " + myBlock1.getSurface() + " units!");
        System.out.println("But if you want to get the 2D surface area: " + myBlock1.getArea());
        System.out.println(myBlock1.toString());


        Block myBlock2 = new Block(4,2,3);
        System.out.println("Volume of myBlock2: " + myBlock2.getVolume() + " units!");
        System.out.println("Surface of myBlock2: " + myBlock2.getSurface() + " units!");
        System.out.println("But if you want to get the 2D surface area: " + myBlock2.getArea());
        System.out.println(myBlock2.toString());
    }
}
