import java.util.Arrays;

public class Workshop08{
    public static void main(String[] args) {
        // Task 1: Create (dynamically) a two dimensional array with the following matrix. Use a loop!
        // 1 0 0 0
        // 0 1 0 0
        // 0 0 1 0
        // 0 0 0 1
        createArray(4, 4);
    }
    static void createArray(int rows, int columns) {
        int[][] myTwoDimensionalArray = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            myTwoDimensionalArray[i][i] = 1;
        }
        System.out.println(Arrays.deepToString(myTwoDimensionalArray));
    }
}