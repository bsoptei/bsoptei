package Workshop08;

/**
 * Created by Söp on 2016.11.16..
 */
public class Point implements Drawable {
    private float x;
    private float y;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    @Override
    public void draw() {
        System.out.printf("DRAW a point at %.2f, %.2f\n", x, y);
    }
}
