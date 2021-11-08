package calculator;

import java.util.concurrent.TimeUnit;

public class SlowCalculator extends SmartCalculator
{

    public int slowMultiply(int a, int b) throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(60);
        return super.multiply(a, b);
    }
}
