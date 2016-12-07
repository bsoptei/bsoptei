import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Söp on 2016.12.06.. Roman number converter test
 */
public class NumberConverterTest {
    @Test
    public void convertTest1() throws Exception {
        assertEquals("I", NumberConverter.convert(1));
    }

    @Test
    public void convertTest2() throws Exception {
        assertEquals("II", NumberConverter.convert(2));
    }

    @Test
    public void convertTest3() throws Exception {
        assertEquals("III", NumberConverter.convert(3));
    }

    @Test
    public void convertTest4() throws Exception {
        assertEquals("IV", NumberConverter.convert(4));
    }

    @Test
    public void convertTest5() throws Exception {
        assertEquals("V", NumberConverter.convert(5));
    }

    @Test
    public void convertTest6() throws Exception {
        assertEquals("VI", NumberConverter.convert(6));
    }

    @Test
    public void convertTest7() throws Exception {
        assertEquals("VII", NumberConverter.convert(7));
    }

    @Test
    public void convertTest8() throws Exception {
        assertEquals("VIII", NumberConverter.convert(8));
    }

    @Test
    public void convertTest9() throws Exception {
        assertEquals("IX", NumberConverter.convert(9));
    }

    @Test
    public void convertTest10() throws Exception {
        assertEquals("X", NumberConverter.convert(10));
    }

    @Test
    public void convertTest38() throws Exception {
        assertEquals("XXXVIII", NumberConverter.convert(38));
    }

    @Test
    public void convertTest398() throws Exception {
        assertEquals("CCCXCVIII", NumberConverter.convert(398));
    }

    @Test
    public void convertTest896() throws Exception {
        assertEquals("DCCCXCVI", NumberConverter.convert(896));
    }
}