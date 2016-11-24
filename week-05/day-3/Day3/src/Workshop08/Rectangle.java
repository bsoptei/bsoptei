package Workshop08;

/**
 * Created by Söp on 2016.11.15..
 */
public class Rectangle implements Drawable {
    private float width;
    private float height;
    private Point start;

    public Rectangle(Point start, float width, float height) {
        this.start = start;
        this.width = width;
        this.height = height;
    }


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

    @Override
    public void draw() {
        System.out.printf("DRAW a rectangle at %.2f, %.2f with %.2f width and %.2f height\n",
                start.getX(), start.getY(), width, height);
    }
}
