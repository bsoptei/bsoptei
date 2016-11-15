/***
 Workshop02
 ***/
public class Circle {
    private double radius;
    public static int numberOfCircles;

    double getRadius() {
        return radius;
    }

    public Circle() {
        this(1);
        setNumberOfCircles();
    }

    public Circle(double r) {
        this.radius = r;
        setNumberOfCircles();
    }

    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    private void setNumberOfCircles() {
        numberOfCircles++;
    }

    static int getNumberOfCircles() {
        return numberOfCircles;
    }

}