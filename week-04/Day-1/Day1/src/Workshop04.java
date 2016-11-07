import java.util.*;

public class Workshop04{
    public static void main(String... args){
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("first");
        arrayList.add(2);
        arrayList.add("third");
        arrayList.add(false);
        // Accidentally we added "2" and "false" to the list. Your task is to change from "2" to "second" and change from "false" to "fourth"
        arrayList.remove(1);
        arrayList.add(1, "second");
        arrayList.remove(arrayList.size() - 1);
        arrayList.add(arrayList.size(), "fourth");
        System.out.println(arrayList);
    }
}