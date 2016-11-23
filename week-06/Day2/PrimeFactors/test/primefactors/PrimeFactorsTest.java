package primefactors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class PrimeFactorsTest {

    private List<Integer> list(Integer... s) {
        return new ArrayList<Integer>(Arrays.asList(s));
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(list(), PrimeFactors.generate(1));
    }

    @Test
    public void testTwo() throws Exception {
        assertEquals(list(2), PrimeFactors.generate(2));
    }

    @Test
    public void testThree() throws Exception {
        assertEquals(list(3), PrimeFactors.generate(3));
    }

    @Test
    public void testFour() throws Exception {
        assertEquals(list(2, 2), PrimeFactors.generate(4));
    }

    @Test
    public void testFive() throws Exception {
        assertEquals(list(5), PrimeFactors.generate(5));
    }

    @Test
    public void testSix() throws Exception {
        assertEquals(list(2, 3), PrimeFactors.generate(6));
    }

    @Test
    public void testEight() throws Exception {
        assertEquals(list(2, 2, 2), PrimeFactors.generate(8));
    }

    @Test
    public void testNine() throws Exception {
        assertEquals(list(3, 3), PrimeFactors.generate(9));
    }

    @Test
    public void testTwelve() throws Exception {
        assertEquals(list(2, 2, 3), PrimeFactors.generate(12));
    }

}
