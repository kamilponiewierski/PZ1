public class Y extends X
{
    protected int yMask = 0xff00;

    Y()
    {
        fullMask = fullMask |= yMask;
        yMask = mask(xMask);

    }


    public int mask(int orig)
    {
        return (orig & fullMask);
    }
}
