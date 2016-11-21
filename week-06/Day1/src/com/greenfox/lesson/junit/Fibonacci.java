package com.greenfox.lesson.junit;

/**
 * Created by Söp on 2016.11.21. Workshop03
 */
class Fibonacci {

    int fib(int x) throws Exception {
        if (x <= 0) {
            throw new Exception();
        } else if (x < 3) {
            return 1;
        }
        return fib(x - 1) + fib(x - 2);
    }
}
