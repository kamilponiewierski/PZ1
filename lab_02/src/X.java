public class X
{
    protected int xMask = 0x00ff;
    protected int fullMask;

    X()
    {
        fullMask = xMask;
    }

    public int mask(int orig)
    {
        return (orig & fullMask);
    }
}
