class Primes {
    public static void main(String[] args) {
        for (int n = 2; n <= 100; n++) {
            boolean nIsPrime = true;
            int m = 2;
            while ((m < Math.sqrt(n)) && nIsPrime) {
                if (n % m == 0) {
                    nIsPrime = false;
                }
                m++;
            }
            if (nIsPrime) {
                System.out.println(n);
            }
        }
    }
}