public class Main
{

    public static void main(String[] args)
    {
        var y = new Y();


        var d1 = new Dog("rex", "Ruff!");
        var d2 = new Dog("scruffy", "Wurf!");

        for (var dog :
                new Dog[]{d1, d2})
        {
            System.out.println(dog.name + " says " + dog.says);
        }

        var d3 = d1;
        var d4 = new Dog("rex", "Ruff!");

        Dog[] allDogs = {d1, d2, d3, d4};
        int allDogsLen = allDogs.length;
        for (int i = 0; i < allDogsLen; i++)
        {
            for (int j = i; j < allDogsLen; j++)
            {
                System.out.println("d" + (i + 1) + " and d" + (j + 1) + " are " + (allDogs[i] == allDogs[j] ? "" : "not ") + "equal using ==");
                System.out.println("d" + (i + 1) + " and d" + (j + 1) + " are " + (allDogs[i].equals(allDogs[j]) ? "" : "not ") + "equal using eq");

            }
        }

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

    }


}
