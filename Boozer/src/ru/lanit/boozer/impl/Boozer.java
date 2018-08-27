package ru.lanit.boozer.impl;

import ru.lanit.boozer.api.Card;
import ru.lanit.boozer.api.CardDeck;
import ru.lanit.boozer.api.CardGame;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Boozer implements CardGame {
    private CardDeck cardDeck;
    private LinkedList<Card> cards;
    private ArrayList<Player> players = new ArrayList<>();

    public Boozer(Player player1, Player player2, Player player3, Player player4) {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    private void createCardDeck() {
        cardDeck = new BoozerCardDeck(36);
        cards = cardDeck.shuffleDeck(cardDeck.getCards());
    }

    private void handOutCards() {
        int j = 0;
        while (!cards.isEmpty()) {
            players.get(j).addCard(cards.getFirst());
            cards.removeFirst();
            j++;
            if (j == players.size()) j = 0;
        }
    }

    private void grabTable(HashSet<Card> table, HashMap<Player, Integer> round, boolean matched, int min) {
        for (Map.Entry<Player, Integer> entry : round.entrySet()) {
            if (entry.getValue() == min && !matched) {
                entry.getKey().addTable(table);
                table.clear();
                System.out.println("Игрок " + entry.getKey().getName() + " забирает стол.");
            }
        }
    }

    private void startTheGame() {
        //Скидывание карт на стол
        HashSet<Card> table = new HashSet<>();
        HashMap<Player, Integer> round = new HashMap<>();
        boolean notBroken = true;

        while (notBroken) {

            int min = MAX_VALUE;
            boolean matched = false;
            for (Player player : players) {
                if (player.getHand() >= 36) {//Условие прерывания
                    notBroken = false;
                    System.out.println("Игрок " + player.getName() + " проиграл!");
                    break;
                }
                PlayCard card = (PlayCard) player.dropCard();
                if (card == null) {
                    System.out.println("Игрок " + player.getName() + " вышел из игры победителем!");
                } else {
                    System.out.println("Игрок " + player.getName() + ": " + card.getName());
                    int number = card.getValue();
                    round.put(player, number);
                    table.add(card);
                    if (number == min) {
                        matched = true;
                    } else if (number < min) {
                        min = number;
                        matched = false;
                    }
                }
            }
            //Кто скинул наименьшую карту, тот забирает стол
            grabTable(table, round, matched, min);
        }
    }

    @Override
    public void play() {
        //Создание колоды карт
        createCardDeck();

        //Раздача карт на руки
        handOutCards();

        //Начало игры
        startTheGame();

    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public CardDeck getCardDeck() {
        return cardDeck;
    }

    @Override
    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    @Override
    public void setPlayer(Player player) {
        throw new UnsupportedOperationException("This method can't be used in this class.");
    }

    @Override
    public Player getPlayer() {
        throw new UnsupportedOperationException("This method can't be used in this class.");
    }
}