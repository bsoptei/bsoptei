public class Workshop37 {
//    static char c = '#';

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
//    Outdated solution
//        for (int i = 1; i <=7; i++) {
//            String output = "";
//            if (i % 2 == 1) {
//                output = iteratorConcatenation(14, output);
//            }
//            else {
//                output = iteratorConcatenation(15, output);
//            }
//            System.out.println(output);
//        }
//    }
//    public static String iteratorConcatenation(int loopLength, String toConcatenate) {
//        for (int j = 1; j <= loopLength; j++) {
//            if ((loopLength == 15 && j % 2 == 1) || (loopLength == 14 && j % 2 == 0)) {
//                toConcatenate = toConcatenate.concat(Character.toString(c));
//            } else {
//                toConcatenate = toConcatenate.concat(" ");
//            }
//        }
//        return toConcatenate;
//    }
//
//