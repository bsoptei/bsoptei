package Workshop05;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Created by Söp on 2016.11.16..
 */
public class Model implements Comparator<Object> {
    private String name;

    public String getSize() {
        return size;
    }

    private String size;
    private int thirdParameter;

    public Model(String name, String size, int thirdParameter) {
        this.name = name;
        this.size = size;
        this.thirdParameter = thirdParameter;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator<Object> reversed() {
        return null;
    }

    @Override
    public Comparator<Object> thenComparing(Comparator<? super Object> other) {
        return null;
    }

    @Override
    public <U> Comparator<Object> thenComparing(Function<? super Object, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Object> thenComparing(Function<? super Object, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Object> thenComparingInt(ToIntFunction<? super Object> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Object> thenComparingLong(ToLongFunction<? super Object> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Object> thenComparingDouble(ToDoubleFunction<? super Object> keyExtractor) {
        return null;
    }

    public String toString() {
        return String.format("%s - %s diagonal (%d)\n", name, size, thirdParameter);
    }

}
