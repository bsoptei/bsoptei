import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Söp on 2016.11.21. Testing Competition
 */
public class TestBalazsSoptei {
    private WordToolbox w;

    @Before
    public void setUp() throws Exception {
        w = new WordToolbox(" ");
    }

    @Test
    public void waitingItOut() throws Exception {
        w.WaitingItOut();
    }

    @Test
    public void helper() throws Exception {
        w.helper();
        int testInt = w.getCountOfChars().get(' ');
        assertEquals(1, testInt);
    }

    @Test
    public void helperTwo() throws Exception {
        w.setS("FloaT");
        w.helper();
        int testInt = w.getCountOfChars().get('t');
        assertEquals(1, testInt);
    }

    @Test
    public void countHowManyTestY() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals(2, w.countHowMany('T'));
    }

    @Test
    public void countHowManyTestN() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals(0, w.countHowMany('x'));
    }

    @Test
    public void countHowManyTestEmpty() throws Exception {
        w.setS("Tarzan's toenails");
        assertEquals(1, w.countHowMany(' '));
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
        assertEquals(true, w.isAnAnagram("float"));
    }

    @Test
    public void isAnAnagramCaseTwo() throws Exception {
        w.setS("aloft");
        assertEquals(false, w.isAnAnagram("foetal"));
    }

    @Test
    public void isAnAnagramCaseThree() throws Exception {
        w.setS("latest");
        assertEquals(false, w.isAnAnagram("foetal"));
    }

    @Test
    public void isAnAnagramCaseFour() throws Exception {
        w.setS("aloFt");
        assertEquals(true, w.isAnAnagram("flOat"));
    }

}