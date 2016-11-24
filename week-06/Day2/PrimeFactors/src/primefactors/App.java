package primefactors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class App {

    public static void main(String[] args) {
        ArrayList<String> results = new ArrayList<>();
        long startM, endM, differenceM, startN, endN, differenceN;
        PrimeFactors pf = new PrimeFactors();
        List<Integer> currentResult;
        StringBuilder resultFormatter = new StringBuilder();
        Random x = new Random();
        ArrayList<Integer> testNumbers = new ArrayList<>();

        for (Integer i = 1; i <= 1000; i++) {
            testNumbers.add(x.nextInt(Integer.MAX_VALUE - 1) + 1);
        }

        Collections.sort(testNumbers);
        results.add("number, runtime (milliseconds), runtime (nanoseconds), prime factors");

        for (Integer number : testNumbers) {
            resultFormatter.delete(0, resultFormatter.length());
            startM = System.currentTimeMillis();
            startN = System.nanoTime();
            currentResult = pf.generate(number);
            endN = System.nanoTime();
            endM = System.currentTimeMillis();
            differenceN = endN - startN;
            differenceM = endM - startM;
            System.out.printf("Finished test for %d in %d milliseconds (%d nanoseconds).\n",
                    number, differenceM, differenceN);

            resultFormatter.append(currentResult.toString());
            for (int index = 0; index < resultFormatter.length() - 1; index++) {
                if (resultFormatter.charAt(index) == ',') {
                    resultFormatter.replace(index, index + 1, ";");
                }
            }
            System.out.println(resultFormatter);
            results.add(number.toString() + "," + Long.toString(differenceM) + "," +
                    Long.toString(differenceN) + "," + resultFormatter);
        }

        System.out.println("Testing finished, saving results...");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/primefactors/results.csv"));
            for (String line : results) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
