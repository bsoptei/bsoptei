package com.greenfox.lesson.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Söp on 2016.11.21. Workshop01
 */
public class AppleTest {

    private Apple myApple;

    @Before
    public void AppleTestSetup() {
        myApple = new Apple();
    }

    @Test
    public void getName() throws Exception {
        assertEquals("applë", myApple.getName());
    }

}