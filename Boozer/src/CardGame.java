import java.util.ArrayList;

public interface CardGame {

     ArrayList<Player> getPlayers();

     void setPlayers(ArrayList<Player> players);

     CardDeck getCardDeck();

     void setCardDeck(CardDeck cardDeck);

     void play();
}
