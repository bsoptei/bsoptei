public class Workshop36 {
    public static void main(String[] args) {
        // Write a program which has this output
        // # # # # #
        // # # # # #
        // # # # # #
        // # # # # #
        // # # # # #
        // The # character should be replacable, hence store it in a variable
        char c = '#';

        for (int i = 1; i <=5; i++) {
            String output = "";
            for (int j = 1; j <=9; j++) {
                if (j % 2 == 1) {
                    output = output.concat(Character.toString(c));
                }
                else {
                    output = output.concat(" ");
                }

            }
            System.out.println(output);
        }
    }
}