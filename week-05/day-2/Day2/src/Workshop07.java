/**
 * Created by Söp on 2016.11.15..
 */
public class Workshop07 {
    public static void main(String[] args) {
        Stack stackOne = new Stack();

        System.out.println(stackOne.size());

        stackOne.push(new Block(1,2,3));
        System.out.println(stackOne.size());

        System.out.println(stackOne.pop());
        System.out.println(stackOne.size());



    }
}
