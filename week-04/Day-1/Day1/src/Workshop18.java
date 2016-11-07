public class Workshop18{
    public static void main(String... args){
        StringBuilder example = new StringBuilder("A long example string");
        example.replace(example.indexOf("long"), example.indexOf("long") + "long".length(), "short");
        // I would like to replace "long" with "short" in this example, but it has a problem. Please fix it! Don't forget that String is immutable
        // Expected output: A short example string
        System.out.println(example);
    }
}
