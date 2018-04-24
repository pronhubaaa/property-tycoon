import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class CardStack extends ArrayDeque<Card> {

    private CardType cardType;

    public CardStack(CardType cardType) {
        super();
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public void shuffle() {
        ArrayList<Card> deck = new ArrayList<>();
        this.iterator().forEachRemaining(deck::add);
        Collections.shuffle(deck);
        this.clear();
        this.addAll(deck);
    }
}
