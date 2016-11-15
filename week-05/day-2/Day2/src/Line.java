/**
 * Created by Söp on 2016.11.15..
 */
public class Line {
    private Point start = new Point(0,0);
    private Point end = new Point(0,0);

    public Line() {
    }

    public Line(Point startPoint, Point endPoint) {
        this.start = startPoint;
        this.end = endPoint;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start.setXY(x1, y1);
        this.end.setXY(x2, y2);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setStart(int x, int y) {
        this.start.setXY(x, y);
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setEnd(int x, int y) {
        this.end.setXY(x, y);
    }

    public double getLength() {
        return start.distance(end);
    }
}
