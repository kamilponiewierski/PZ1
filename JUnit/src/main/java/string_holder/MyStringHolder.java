package string_holder;

import java.util.ArrayList;
import java.util.List;

public class MyStringHolder implements StringHolder
{
    final List<String> storage = new ArrayList<>();


    @Override
    public void holdString(String s)
    {
        storage.add(s);
    }

    @Override
    public String[] showStrings()
    {
        return storage.toArray(new String[0]);
    }

    @Override
    public void deleteStrings()
    {
        storage.clear();
    }
}
