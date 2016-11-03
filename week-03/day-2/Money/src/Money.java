import java.util.Scanner;

public class Money {
    static Scanner inputNumber = new Scanner(System.in);
    public static void main(String[] args) {
        double[] arguments = new double[4];
        String[] argName = {"sum", "interest rate (%)", "tax (%)", "desired value"};
        for (int i = 0; i < 4; i++) {
            System.out.printf("Enter %s: ", argName[i]);

            arguments[i] = inputNumber.nextDouble();
        }
        System.out.printf("You can reach the desired value in %d years.", calculateYears(arguments[0],arguments[1]/100,arguments[2]/100,arguments[3]));
    }
    public static int calculateYears(double principal, double interest,  double tax, double desired) {
        int year = 0;
        while (principal < desired) {
            principal = principal * (1 + interest * (1 - tax));
            year++;
        }
        return year;
    }
}
//        System.out.println(calculateYears(1000,0.05,0.18,1100));
//        System.out.println(calculateYears(1000,0.01625,0.18,1200));
//        System.out.println(calculateYears(1000,0.05,0.18,1000));