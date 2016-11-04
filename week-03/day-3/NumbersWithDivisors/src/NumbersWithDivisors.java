public class NumbersWithDivisors {

    public static void main(String[] args) {
        System.out.println(countNumbersWithDivisors(1, 50));
        System.out.println(countNumbersWithDivisors(3, 100));
    }

    static int countNumbersWithDivisors(int diff, int max) {
        int[] numberOfDivisors = new int[max];
        for (int n = 1; n <= max; n++) {
            numberOfDivisors[n - 1] = getNumberOfDivisors(n);
        }
        int counter = 0;
        for (int i = 1; i + diff < max; i++) {
            if (numberOfDivisors[i] == numberOfDivisors[i + diff]) {
                counter++;
            }
        }
        return counter;
    }

    static int getNumberOfDivisors(int n) {
        if (n == 1) {
            return 1;
        } else {
            int p = 1;
            int numberOfDivisors = 0;
            while (p <= n) {
                if (n % p == 0) {
                    numberOfDivisors++;
                }
                p++;
            }
            return numberOfDivisors;
        }
    }
}

//        Cheat sheet array
//        Source: http://oeis.org/search?q=number+of+divisors&sort=&language=&go=Search
//        int[] numberOfDivisors = {1, 2, 2, 3, 2, 4, 2, 4, 3, 4, 2, 6, 2, 4, 4, 5, 2, 6, 2, 6, 4, 4, 2, 8, 3, 4, 4, 6, 2, 8, 2, 6, 4, 4, 4, 9, 2, 4, 4, 8, 2, 8, 2, 6, 6, 4, 2, 10, 3, 6, 4, 6, 2, 8, 4, 8, 4, 4, 2, 12, 2, 4, 6, 7, 4, 8, 2, 6, 4, 8, 2, 12, 2, 4, 6, 6, 4, 8, 2, 10, 5, 4, 2, 12, 4, 4, 4, 8, 2, 12, 4, 6, 4, 4, 4, 12, 2, 6, 6, 9, 2, 8, 2, 8};