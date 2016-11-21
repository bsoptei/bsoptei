package com.greenfox.lesson.junit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Söp on 2016.11.21. Workshop02
 */
public class SumTest {
    private Sum mySum;
    private ArrayList<Integer> myList;

    @Before
    public void SumTestSetup() {
        mySum = new Sum();
        myList = new ArrayList<>();
    }

    @Test
    public void sumTestWithEmptyList() throws Exception {
        assertEquals(myList.size(), mySum.sum(myList));
    }

    @Test
    public void sumTestWithSingleElementList() throws Exception {
        Random r = new Random();
        myList.add(r.nextInt(100000000));
        int ref = myList.get(0);
        assertEquals(ref, mySum.sum(myList));
    }

    @Test
    public void sumTestWithMultipleElementList() throws Exception {
        Random r = new Random();
        Random r2 = new Random();
        int sum = 0;
        int ref = 0;
        for (int i = 0; i < r.nextInt(100); i++) {
            ref = r2.nextInt(1000000);
            myList.add(ref);
            sum += ref;
        }
        assertEquals(sum, mySum.sum(myList));
    }

    @Test (expected = NullPointerException.class)
    public void sumTestWithNull() throws Exception {
        myList = null;
        assertEquals(myList, mySum.sum(myList));
    }

}