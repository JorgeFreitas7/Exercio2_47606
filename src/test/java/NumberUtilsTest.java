
import org.example.NumberUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberUtilsTest {

    private final int number;
    private final int divisor;
    private final boolean expectedIsPrime;
    private final boolean expectedIsEven;
    private final boolean expectedIsMultiple;

    public NumberUtilsTest(int number, int divisor, boolean expectedIsPrime, boolean expectedIsEven, boolean expectedIsMultiple) {
        this.number = number;
        this.divisor = divisor;
        this.expectedIsPrime = expectedIsPrime;
        this.expectedIsEven = expectedIsEven;
        this.expectedIsMultiple = expectedIsMultiple;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 3, 0, true, false, false },
                { 23, 0, true, false, false },
                { 311, 0, true, false, false },
                { 487, 0, true, false, false },
                { 653, 0, true, false, false },
                { 947, 0, true, false, false },
                { 1, 0, false, false, false }, // não é primo

                { 32, 0, false, true, false },
                { 64, 0, false, true, false },
                { 2, 0, true, true, false },
                { 20, 0, false, true, false },
                { 30, 0, false, true, false },
                { 26, 0, false, true, false },
                { 1, 0, false, false, false }, // não é par

                { 23, 23, true, false, true },
                { 46, 23, false, true, true },
                { 115, 23, false, false, true },
                { 184, 23, false, true, true },
                { 207, 23, false, false, true },
                { 230, 23, false, true, true },


                { -23, 23, false, false, true },
                { -24, 2, false, true, true }
        });
    }


    @Test
    public void testIsPrime() {
        if (divisor == 0) { // Divisor zero significa que estamos testando apenas o número como primo
            assertEquals(expectedIsPrime, NumberUtils.isPrime(number));
        }
    }


    @Test
    public void testIsEven() {
        if (divisor == 0) { // Divisor zero significa que estamos testando apenas o número como par
            assertEquals(expectedIsEven, NumberUtils.isEven(number));
        }
    }


    @Test
    public void testIsMultiple() {
        if (divisor != 0) {
            assertEquals(expectedIsMultiple, NumberUtils.isMultiple(number, divisor));
        }
    }
}
