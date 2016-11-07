import java.util.*;

public class Workshop14{
    public static void main(String... args){
        ArrayList<String> al = new ArrayList<String>(Arrays.asList("kuty", "macsk", "kacs", "rók"));
        // Add "a" to every string in al. Use an iterator!
//        for (int i = 0; i < al.size(); i++) {
//            al.set(i, al.get(i).concat("a"));
//        }
        ListIterator litr = al.listIterator();
        while(litr.hasNext()) {
            Object element = litr.next();
            litr.set(element + "a");
        }
        System.out.println(al);
    }
}