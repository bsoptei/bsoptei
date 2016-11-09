import java.util.*;

public class Workshop13{
    public static void main(String... args){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("first", "second", "third", "fourth", "fifth"));
        // Print all elements of the list using a for loop and an Iterator
        System.out.println("This time I'm using a for loop.");
        for (String element: list) {
            System.out.println(element);
        }
        System.out.println("This time I'm using an iterator and a while loop.");
        Iterator itr = list.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.println(element + " ");
        }
        System.out.println("This time I'm using an iterator and a for loop.");
        for (Iterator<String> numbersIter = list.iterator(); numbersIter.hasNext();){
            System.out.println(numbersIter.next());
        }
    }
}
