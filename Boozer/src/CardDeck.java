import java.util.ArrayList;
import java.util.List;

public interface CardDeck {
    void addCard(Card card);
    void removeCard(Card card);
    void shuffleDeck();
    ArrayList<Card> getCards();
    void setCards(List<Card> cards);
}