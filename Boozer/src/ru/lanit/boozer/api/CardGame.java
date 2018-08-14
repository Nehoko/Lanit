package ru.lanit.boozer.api;

import ru.lanit.boozer.impl.Player;

import java.util.ArrayList;

public interface CardGame {

     ArrayList<Player> getPlayers();

     void setPlayers(ArrayList<Player> players);

     CardDeck getCardDeck();

     void setCardDeck(CardDeck cardDeck);

     void setPlayer(Player player);

     Player getPlayer();

     void play();
}
