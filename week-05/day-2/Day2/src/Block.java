import static java.lang.Float.NaN;

/**
 * Created by Söp on 2016.11.15..
 */
public class Block extends Rectangle {
    private float length;

    public Block() {
        super();
        this.length = 1;
    }

    public Block(float width, float height, float length) {
        super(width, height);
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public float getVolume() {
        return getWidth() * getHeight() * getLength();
    }

    public float getSurface() {
        return 2 * (getWidth() * getHeight() + getHeight() * getLength() + getLength() * getWidth());
    }

    public float getArea() {
        return NaN;
    }

    public String toString() {
        return String.format("Block[{%f}, {%f}, {%f}]", getWidth(), getHeight(), getLength());
    }

}
