import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Söp on 2016.12.06..
 */
public class MumblingTest {
    @Test
    public void accumTestEmpty() throws Exception {
        assertEquals("", Accumul.accum(""));
    }
    @Test
    public void accumTestA() throws Exception {
        assertEquals("A", Accumul.accum("a"));
    }
    @Test
    public void accumTestAa() throws Exception {
        assertEquals("A-Aa", Accumul.accum("aa"));
    }

    @Test
    public void accumTestFaraDT() throws Exception {
        assertEquals("F-Aa-Rrr-Aaaa-Ddddd-Tttttt", Accumul.accum("FaraDT"));
    }

    @Test
    public void accumTestabcd() throws Exception {
        assertEquals("A-Bb-Ccc-Dddd", Accumul.accum("abcd"));
    }

    @Test
    public void accumTestRqaEzty() throws Exception {
        assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", Accumul.accum("RqaEzty"));
    }

    @Test
    public void accumTestcwAt() throws Exception {
        assertEquals("C-Ww-Aaa-Tttt", Accumul.accum("cwAt"));
    }

    @Test
    public void accumTest3Hyphen() throws Exception {
        assertEquals("--------", Accumul.accum("---"));
    }


}