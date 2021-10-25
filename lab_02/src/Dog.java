import java.util.Objects;

public class Dog
{
    String name;
    String says;

    Dog(String name, String says)
    {
        this.name = name;
        this.says = says;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) && Objects.equals(says, dog.says);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, says);
    }
}
