package com.greenfox.lesson.junit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by Söp on 2016.11.21. Workshop03
 */
public class FibonacciTest {
    private Fibonacci myFib;
    private int[] fibSeq = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,
            377, 610, 987, 1597, 2584, 4181, 6765, 10946,
            17711, 28657, 46368, 75025, 121393, 196418, 317811};

    @Before
    public void FibonacciTestSetup() {
        myFib = new Fibonacci();
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Test (expected = Exception.class)
    public void fibTestNegative() throws Exception {
        Random r = new Random();
        myFib.fib(- r.nextInt(1000));
    }

    @Test (expected = Exception.class)
    public void fibTestZero() throws Exception {
        myFib.fib(0);
    }

    @Test
    public void fibTestPositiveGreaterThanThree() throws Exception {
        Random r = new Random();
        int randomInt = r.nextInt(24) + 3;
        assertEquals(fibSeq[randomInt], myFib.fib(randomInt));
    }

    @Test
    public void fibTestPositiveLessThanThree() throws Exception {
        Random r = new Random();
        assertEquals(1, myFib.fib(r.nextInt(2) + 1));
    }
}