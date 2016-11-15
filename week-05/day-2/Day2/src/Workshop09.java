/**
 * Created by Söp on 2016.11.15..
 */
public class Workshop09 {
    public static void main(String[] args) {
        Point p = new Point(10, 15);
        Point q = new Point(12, 18);
        Line n = new Line(p, q);
        System.out.println(n.getLength());
        Line m = new Line(10, 15, 12, 18);
        System.out.println(m.getLength());

        Point v = new Point();
        Line a = new Line(v, p);
        System.out.println(v.distance(p));
        System.out.println(a.getLength());
    }
}
