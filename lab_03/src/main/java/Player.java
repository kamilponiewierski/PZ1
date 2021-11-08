import java.util.LinkedList;
import java.util.List;

public class Player
{
    final private List<Card> _cards;
    final String name;

    Player(String name)
    {
        this.name = name;
        _cards = new LinkedList<Card>();
    }

    void addCard(Card card)
    {
        _cards.add(card);
    }

    void printCards()
    {
        for (var card :
                _cards)
        {
            System.out.print(card.get_rank() + " " + card.get_suit() + "\n");
        }
    }
}
