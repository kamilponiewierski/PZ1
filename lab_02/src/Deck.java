import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck
{
    Card[] _cards;

    Deck()
    {
        var builder = new LinkedList<Card>();
        for (var suit :
                Suit.values())
        {
            for (var rank :
                    Rank.values())
            {
                builder.add(new Card(suit, rank));
            }

        }
        Card[] arr = builder.toArray(new Card[0]);
        Arrays.sort(arr);
        _cards = arr;
    }

    void shuffle()
    {
        _cards = shuffle(_cards);
    }

    Card[] shuffle(Card[] cards)
    {
        var copy = new LinkedList<Card>(List.of(cards));
        Collections.shuffle(copy);
        var arr = new Card[copy.size()];
        for (int i = 0; i < copy.size(); i++)
        {
            arr[i] = copy.get(i);
        }
        return arr;
    }

    Card getTopCard()
    {
        var card = _cards[0];

        _cards = Arrays.copyOfRange(_cards, 1, _cards.length);

        return card;
    }
}
