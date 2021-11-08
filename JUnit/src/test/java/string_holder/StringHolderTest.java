package string_holder;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringHolderTest
{
    StringHolder holder;

    @Nested
    class When_new
    {

        @BeforeEach
        void set_up()
        {
            holder = new MyStringHolder();
        }

        @Test
        void starts_empty()
        {
            assertEquals(0, holder.showStrings().length);
        }

        @Nested
        class after_holding_String
        {
            @BeforeEach
            void hold_string()
            {
                holder.holdString("42");
            }

            @Test
            void is_no_longer_empty()
            {
                assertEquals(1, holder.showStrings().length);
                assertEquals("42", holder.showStrings()[0]);
            }

            @Test
            void is_empty_after_clearing()
            {
                assertNotEquals(0, holder.showStrings().length);
                holder.deleteStrings();
                assertEquals(0, holder.showStrings().length);
            }
        }
    }
}