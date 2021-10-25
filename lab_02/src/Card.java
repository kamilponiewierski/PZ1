import java.util.Objects;

public class Card implements Comparable
{
    private final Suit _suit;

    private final Rank _rank;

    Card(Suit suit, Rank rank)
    {
        _suit = suit;
        _rank = rank;
    }

    public Rank get_rank()
    {
        return _rank;
    }

    public Suit get_suit()
    {
        return _suit;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return _suit == card._suit && _rank == card._rank;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(_suit, _rank);
    }

    @Override
    public int compareTo(Object o)
    {
        if (this == o)
            return 1;
        if (o == null || getClass() != o.getClass())
            return 0;

        var card = (Card) o;
        if (this._suit == card._suit)
        {
            return card._rank.compareTo(this._rank);
        } else
        {
            return this._suit.compareTo(card._suit);
        }
    }
}

enum Suit
{
    hearts, spades, diamonds, clubs
}

enum Rank
{
    two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace,
}