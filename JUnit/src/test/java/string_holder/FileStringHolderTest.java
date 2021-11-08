package string_holder;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileStringHolderTest
{
    FileStringHolder holder;
    List<String> fileContent = new ArrayList<>();

    @BeforeAll
    void setUpAll() throws IOException
    {
        holder = new FileStringHolder();
        fileContent.add(holder.readLine());
    }

    @BeforeEach
    void setUp()
    {
        for (String s :
                fileContent)
        {
            holder.holdString(s);
        }
    }

    @AfterEach
    void tearDown()
    {
        holder.deleteStrings();
    }

    @AfterAll()
    void tearDownAll() throws IOException
    {
        holder.closeFile();
    }


    @Test
    void showStrings()
    {
        assertEquals(1, holder.showStrings().length);
    }

    @Test
    void holdString()
    {
        holder.holdString("123");
        assertEquals(2, holder.showStrings().length);
    }

    @Test
    void holdMultipleStrings()
    {
        int repeats = 10;
        for (int i = 0; i < repeats; i++)
        {
            holder.holdString(Integer.toString(i));
        }

        assertEquals(1 + repeats, holder.showStrings().length);


    }
}