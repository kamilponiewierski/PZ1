package calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Nested;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    Calculator calculator;

    @BeforeEach
    void setUp()
    {
        calculator = new MyCalculator();
    }

    @AfterEach
    void tearDown()
    {
        // System.out.println("yay!");
    }

    @Nested
    @DisplayName("addition")
    @Tag("add")
    class Addition
    {
        @Test
        @DisplayName("works for positive numbers")
        void add()
        {
            assertEquals(10, calculator.add(2, 8));
        }

        @Test
        @DisplayName("works for negative numbers")
        void addNegativeNumbers()
        {
            assertEquals(-42, calculator.add(-40, -2));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10, 21, 42})
    @DisplayName("subtracting number from itself results in 0")
    void subtract(int number)
    {
        assertEquals(0, calculator.subtract(number, number));
    }


    @ParameterizedTest
    @MethodSource("dataSetForDivide")
    void divide(int[] dataSet)
    {
        try
        {
            assertEquals(dataSet[2], calculator.divide(dataSet[0], dataSet[1]));
        } catch (ZeroDivisionException e)
        {
            fail();
        }
    }

    public static int[][] dataSetForDivide()
    {
        return new int[][]{
                {100, 10, 10},
                {6, 3, 2},
                {1000, 100, 10},
                {42, 6, 7},
        };
    }

    @RepeatedTest(10)
    void multiply()
    {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    @DisplayName("\uD83E\uDD14")
    void divideByZeroThrowsZeroDivisionException()
    {
        assertThrowsExactly(ZeroDivisionException.class, () -> calculator.divide(10, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @EnabledForJreRange(min = JRE.JAVA_13)
    @Tag("add")
    void lambdaAdditionTest(int number)
    {
        var collection = new ArrayList<Integer>();
        collection.add(number);
        int result = collection.stream().map(x -> x + x).findFirst().get();
        assertEquals(result, calculator.add(number, number));
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void linuxAdditionTest()
    {
        assertEquals(42, calculator.add(40, 2));
    }
}