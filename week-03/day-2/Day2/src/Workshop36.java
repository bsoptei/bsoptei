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
        char[][] myArray = new char[5][9];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (j % 2 == 0) {
                    myArray[i][j] = '#';
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(myArray[i][j]);

            }
            System.out.print("\n");
        }

    }
}