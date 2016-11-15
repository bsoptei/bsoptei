/**
 * Created by Söp on 2016.11.15..
 */
public class Rectangle {
    private float width;
    private float height;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getArea() {
        return width * height;
    }

    public String toString() {
        return String.format("Rectangle[{%f}, {%f}]", width, height);
    }
}
