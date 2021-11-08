package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlowCalculatorTest
{
    SlowCalculator calculator;

    @BeforeEach
    void setUp()
    {
        calculator = new SlowCalculator();
    }

    @Test
    @Timeout(5)
    void slowMultiply() throws InterruptedException
    {
        assertEquals(4, calculator.slowMultiply(2, 2));
    }
}