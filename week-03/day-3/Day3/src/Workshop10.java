public class Workshop10{
    public static void main(String[] args) {
        // Task 1: Create an array (jagged) which can contain the different shades of specified colors
        // in colors[0] store the shades of green: "lime", "forest green", "olive", "pale green", "spring green"
        // in colors[1] store the shades of red: "orange red", "red", "tomato"
        // in colors[2] store the shades of pink: "orchid", "violet", "pink", "hot pink"
        String green = "lime,forest green,olive,pale green,spring green";
        String red = "orange red,red,tomato";
        String pink = "orchid,violet,pink,hot pink";
        String[][] colors = new String[3][];
        colors[0] = green.split(",");
        colors[1] = red.split(",");
        colors[2] = pink.split(",");

        // Task 2: Print the values of the array to the console
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                System.out.println(colors[i][j]);
            }

        }
    }
}
