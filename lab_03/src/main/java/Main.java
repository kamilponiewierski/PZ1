import pl.edu.agh.kis.CryptUtil;

public class Main
{

    public static void main(String[] args)
    {
        var deck = new Deck();
        deck.shuffle();

        Player[] players = {new Player("Agracz"), new Player("Begracz"), new Player("Cegracz"), new Player("Degracz")};
        for (int i = 0; i < 4; i++)
        {
            for (var player :
                    players)
            {
                player.addCard(deck.getTopCard());
            }
        }

        for (var player :
                players)
        {
            System.out.println(player.name);
            player.printCards();
            System.out.println();
        }

        System.out.println(CryptUtil.generateSHA512("42"));
    }


}
