/**
 * Created by Söp on 2016.11.15..
 */
public class Workshop11 {

    public static void main(String[] args) {
        Cylinder defaultCylinder = new Cylinder();
        System.out.println(defaultCylinder.getArea());
        System.out.println(defaultCylinder.getSurface());
        System.out.println(defaultCylinder.getVolume());

        Cylinder beerMug = new Cylinder(3, 20);
        System.out.println(beerMug.getArea());
        System.out.println(beerMug.getSurface());
        System.out.println(beerMug.getVolume());
    }


}
