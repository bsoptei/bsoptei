public class Workshop19{
    public static void main(String... args){
        String name = "World";
        StringBuilder builder = new StringBuilder("Heljo");
        // Please change "Heljo" to "Hello" and add name ("World") to the end of the string builder
        builder.replace(builder.indexOf("j"), builder.indexOf("j") + 1, "l");
        builder.append(" " + name);
        System.out.println(builder);
    }
}
