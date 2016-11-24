package Workshop08;

/**
 * Created by Söp on 2016.11.16..
 */
public class App {

    public static void main(String... args) {
        Drawable[] drawables = new Drawable[]{
                new Point(12, 30),
                new Point(40, 10),
                new Rectangle(new Point(1, 1), 3, 8),
                new Point(1, 20),
                new Rectangle(new Point(23, 1), 6, 5)
        };
        for (Drawable el : drawables) {
            el.draw();
        }
    }
}
