/**
 * Created by Söp on 2016.11.15..
 */
public class Square extends Rectangle {
    private float sideLength = 1;

    public Square() {
        super(1,1);
    }

    public Square(float sideLength) {
        super(sideLength, sideLength);
        this.sideLength = sideLength;
    }

    public float getArea() {
        return sideLength * sideLength;
    }

    public String toString() {
        return String.format("Square[{%f}]", sideLength);
    }
}
