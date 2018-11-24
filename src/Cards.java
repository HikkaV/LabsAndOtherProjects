import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Cards {

    static LinkedList<String> CARDS;
    public static SUIT SUITS[] = SUIT.values();
    public static RANK RANKS[] = RANK.values();

    static {
        CARDS = new LinkedList();


    }
    public void MakeDeck(){  for (int j = 0; j < 4; j++) {
        for (int i = 0; i < 9; i++){

            Cards.CARDS.add(Cards.RANKS[i] + "-" + Cards.SUITS[j]);}

    }
        Collections.shuffle(Cards.CARDS);
    }
}
