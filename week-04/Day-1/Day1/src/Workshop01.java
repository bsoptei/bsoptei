import java.util.*;

public class Workshop01{
    public static void main(String... args){
        ArrayList<Object> arrayList = new ArrayList<Object>();
        // Add multiple elements to the list and print the number of the elements
        arrayList.add(false);
        arrayList.add(3.99945);
        arrayList.add("stuff");
        arrayList.add(-288);


        System.out.printf("The ArrayList has %d elements.", arrayList.size());
    }
}