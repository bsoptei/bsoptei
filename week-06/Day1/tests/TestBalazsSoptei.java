import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestBalazsSoptei {
    private WordToolbox w;

    @Before
    public void setUp() throws Exception {
        w = new WordToolbox("");
    }

    @Test
    public void waitingItOut() throws Exception {
        w.WaitingItOut();
    }

    @Test
    public void countAllLettersTestLowerCase() throws Exception {
        HashMap<Character, Integer> testHM = w.countAllLetters("cool");
        int testInt = testHM.get('o');
        assertEquals(2, testInt);
    }

    @Test
    public void countAllLettersTestUpperCase() throws Exception {
        HashMap<Character, Integer> testHM = w.countAllLetters("COOL");
        int testInt = testHM.get('o');
        assertEquals(2, testInt);
    }

    @Test
    public void countAllLettersTestMixedCase() throws Exception {
        HashMap<Character, Integer> testHM = w.countAllLetters("CoOL");
        int testInt = testHM.get('o');
        assertEquals(2, testInt);
    }

    @Test
    public void countHowManyTestY() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals(2, w.countHowMany('T'));
    }

    @Test
    public void countHowManyTestIgnoreCase() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals(2, w.countHowMany('t'));
    }

    @Test
    public void countHowManyTestN() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals(0, w.countHowMany('x'));
    }

    @Test
    public void countHowManyTestWhiteSpace() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals(1, w.countHowMany(' '));
    }

    @Test
    public void countHowManyTestY2() throws Exception {
        w.setS("Me Tarzan, You Jane");
        assertEquals(1, w.countHowMany('y'));
    }

    @Test
    public void countHowManyTestY3() throws Exception {
        w.setS("Me Tarzan, You Jane");
        assertEquals(1, w.countHowMany('m'));
    }


    @Test
    public void countHowManyTestN2() throws Exception {
        w.setS("Me Tarzan, You Jane");
        assertEquals(0, w.countHowMany('x'));
    }

    @Test
    public void countHowManyTestWhiteSpace2() throws Exception {
        w.setS("Me Tarzan, You Jane");
        assertEquals(3, w.countHowMany(' '));
    }

    @Test
    public void setSTest() throws Exception {
        w.setS("Tarzan's toenails");
    }

    @Test
    public void getSTest() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals("Tarzan's toenails", w.getS());
    }

    @Test
    public void isAnAnagramCaseOne() throws Exception {
        w.setS("aloft");
        assertTrue(w.isAnAnagram("float"));
    }

    @Test
    public void isAnAnagramCaseTwo() throws Exception {
        w.setS("aloft");
        assertFalse(w.isAnAnagram("foetal"));
    }

    @Test
    public void isAnAnagramCaseThree() throws Exception {
        w.setS("latest");
        assertFalse(w.isAnAnagram("foetal"));
    }

    @Test
    public void isAnAnagramCaseFour() throws Exception {
        w.setS("aloFt");
        assertTrue(w.isAnAnagram("flOat"));
    }

    @Test
    public void isAnAnagramUpperVsLower() throws Exception {
        w.setS("ALOFT");
        assertTrue(w.isAnAnagram("float"));
    }

    @Test
    public void isAnAnagramUpperVsLowerF() throws Exception {
        w.setS("ALOFT");
        assertFalse(w.isAnAnagram("Teilchenbeschleuniger"));
    }

    @Test
    public void isAnAnagramLowerVsUpper() throws Exception {
        w.setS("float");
        assertFalse(w.isAnAnagram("TEILCHENBESCHLEUNIGER"));
    }

    @Test
    public void isAnAnagramUpperVsUpper() throws Exception {
        w.setS("FLOAT");
        assertFalse(w.isAnAnagram("TEILCHENBESCHLEUNIGER"));
    }

    @Test
    public void isAnAnagramLeadingWhiteSpaces() throws Exception {
        w.setS("float");
        assertTrue(w.isAnAnagram("  float   "));
    }

    @Test
    public void isAnAnagramEmpty() throws Exception {
        w.setS("");
        assertTrue(w.isAnAnagram(" "));
    }
}