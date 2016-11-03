public class Workshop17{
    public static void main(String[] args) {
        String ag = "kuty";
        // write a function that gets a string as an input
        // and appends an 'a' character to its end
        ag = aAppender(ag);
        System.out.println(ag);
    }
    public static String aAppender(String stringToAppend) {
        return stringToAppend + "a";
    }
}