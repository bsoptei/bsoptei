/**
 * Created by Söp on 2016.12.06..
 */
public class Accumul {

    public static void main(String[] args) {
    }

    public static String accum(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            builder.append(string.substring(i, i + 1).toUpperCase());
            for (int j = 1; j <= i; j++) {
                builder.append(string.substring(i, i + 1).toLowerCase());
            }
            if (i < string.length() - 1) {
                builder.append("-");
            }
        }
        return builder.toString();
    }
}
