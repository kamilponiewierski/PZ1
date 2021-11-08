package calculator;

public class SmartCalculator extends MyCalculator
{
    @Override
    public int divide(int a, int b) throws ZeroDivisionException
    {
        if (b == 0)
        {
            throw new ZeroDivisionException();
        }

        return a / b;
    }
}
