public class Workshop37 {
    public static void main(String[] args) {
        // Write a program which has this output
        // # # # # # # #
        //  # # # # # # #
        // # # # # # # #
        //  # # # # # # #
        // # # # # # # #
        //  # # # # # # #
        // # # # # # # #
        // The # character should be replaceable, hence store it in a variable
        char c = '#';
        char[][] myArray = new char[7][14];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0) ) {
                    myArray[i][j] = '#';
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                System.out.print(myArray[i][j]);

            }
            System.out.print("\n");
        }
    }
}