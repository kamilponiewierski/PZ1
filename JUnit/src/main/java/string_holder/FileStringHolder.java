package string_holder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStringHolder extends MyStringHolder
{
    private BufferedReader reader;

    String readLine() throws IOException
    {
        String file = "src/main/java/string_holder/in.txt";
        reader = new BufferedReader(new FileReader(file));

        return reader.readLine();
    }

    void closeFile() throws IOException
    {
        reader.close();
    }
}
