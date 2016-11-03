public class Workshop16{
    public static void main(String[] args) {
        String ae = "Misi";
        // create a function that greets ae
        ae = greeter(ae);
        System.out.println(ae);
    }
    public static String greeter(String name) {
        return "Hello " + name;
    }
}