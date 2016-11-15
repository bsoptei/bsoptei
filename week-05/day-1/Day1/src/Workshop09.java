/**
 * Created by Söp on 2016.11.14..
 * The Circle
 */
public class Workshop09 {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        System.out.printf("I got a new circle with radius %f units, its perimeter is %f units, and its area is %f square units.\n",
                myCircle.getRadius(), myCircle.getPerimeter(), myCircle.getArea());
        System.out.printf("Currently the number of circles is %d.\n", Circle.getNumberOfCircles());


        Circle myCircleTwo = new Circle(8.32421);
        System.out.printf("I got a new circle with radius %f units, its perimeter is %f units, and its area is %f square units.\n",
                myCircleTwo.getRadius(), myCircleTwo.getPerimeter(), myCircleTwo.getArea());
        System.out.printf("Currently the number of circles is %d.\n", Circle.getNumberOfCircles());
        System.out.println();
    }


}
