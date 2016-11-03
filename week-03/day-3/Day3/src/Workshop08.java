public class Workshop08{
    public static void main(String[] args) {
        // Task 1: Create (dynamically) a two dimensional array with the following matrix. Use a loop!
        // 1 0 0 0
        // 0 1 0 0
        // 0 0 1 0
        // 0 0 0 1
        int[][] myTwoDimensionalArray = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    myTwoDimensionalArray[i][j] = 1;
                } else {
                    myTwoDimensionalArray[i][j] = 0;
                }
            }
        }
        // Task 2: Print this two dimensional array to the output
        for (int i = 0; i < 4; i++) {
            String printArray = "";
            for (int j = 0; j < 4; j++) {
                printArray = printArray.concat(Integer.toString(myTwoDimensionalArray[i][j]));
            }
            System.out.println(printArray);
        }
    }
}