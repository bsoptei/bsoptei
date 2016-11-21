package com.greenfox.lesson.junit;

import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.21. Workshop02
 */
class Sum {
    int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int x: list) {
            sum+= x;
        }
        return sum;
    }
}
