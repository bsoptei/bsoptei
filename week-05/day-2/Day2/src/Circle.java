/**
 * Created by Söp on 2016.11.15..
 */
public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        new Circle(radius);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return String.format("Circle[radius=%s,color=%s]", radius, color);
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public double getCircumference() {
        return 2 * radius * Math.PI;
    }
}
