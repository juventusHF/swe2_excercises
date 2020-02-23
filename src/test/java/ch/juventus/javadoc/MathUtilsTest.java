package ch.juventus.javadoc;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {

    private final MathUtils mathUtils = new MathUtils();

    @Test
    public void fivePlusFiveShouldEqualsTen() {
        List<Double> numbers = new ArrayList<>();
        numbers.add(5d);
        numbers.add(5d);
        assertEquals(10d, mathUtils.addition(numbers), "Calculation result wrong");
    }

    @Test
    public void testAdditionWithThreeEntryList() {
        List<Double> numbers = new ArrayList<>();
        numbers.add(5d);
        numbers.add(6.5d);
        numbers.add(9.5d);
        assertEquals(21d, mathUtils.addition(numbers), "Calculation result wrong");
    }

    @Test
    public void testAdditionWithSingleEntryList() {
        List<Double> numbers = new ArrayList<>();
        numbers.add(5d);
        assertEquals(5d, mathUtils.addition(numbers), "Calculation result wrong");
    }

    @Test
    public void testAdditionWithZeroEntryList() {
        List<Double> numbers = new ArrayList<>();
        assertEquals(0d, mathUtils.addition(numbers), "Calculation result wrong");
    }

    @Test
    public void additionWithNullParameterShouldThrowNullPointer() {
        assertThrows(NullPointerException.class, () -> mathUtils.addition(null), "Did not throw exception");
    }

    @Test
    public void tenMinusTwoShouldEqualsEight() {
        assertEquals(8d, mathUtils.subtraction(10d, 2d), "Calculation result wrong");
    }

    @Test
    public void zeroMinusFiveShouldEqualMinusFive() {
        assertEquals(-5d, mathUtils.subtraction(0d, 5d), "Calculation result wrong");
    }

    @Test
    public void minusTenMinusFiveShouldEqualMinusFifteen() {
        assertEquals(-15d, mathUtils.subtraction(-10d, 5d), "Calculation result wrong");
    }

    @Test
    public void minusTenMinusMinusFiveShouldEqualMinusFive() {
        assertEquals(-5d, mathUtils.subtraction(-10d, -5d), "Calculation result wrong");
    }

}
