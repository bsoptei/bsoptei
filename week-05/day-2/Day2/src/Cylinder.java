import static java.lang.Float.NaN;

/**
 * Created by Söp on 2016.11.15..
 */
public class Cylinder extends Circle {
    private double height = 1;

    public Cylinder() {
        super();
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSurface() {
        return super.getArea() * 2 + super.getCircumference() * height;
    }

    public double getArea() {
        return (double)(NaN);
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    public double getCircumference() {
        return (double)(NaN);
    }
}
