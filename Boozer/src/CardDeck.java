import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface CardDeck {
    void addCard(Card card);
    void removeCard(Card card);
    LinkedList<Card> shuffleDeck(ArrayList<Card> cards);
    ArrayList<Card> getCards();
    void setCards(List<Card> cards);
}