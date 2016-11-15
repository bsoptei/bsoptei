import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Söp on 2016.11.15..
 */
public class Stack {
    private ArrayList<Object> elements = new ArrayList<Object>();

    public Stack() {
    }

    public void push(Object o) {
        this.elements.add(o);
    }

    public int size() {
        int size = 0;
        Iterator i = elements.iterator();
        while (i.hasNext()) {
            size++;
            Object element = i.next();
        }
        return size;
    }

    public Object pop() {
        Object popped = elements.get(size() - 1);
        elements.remove(elements.get(size() - 1));
        return popped;
    }

}
