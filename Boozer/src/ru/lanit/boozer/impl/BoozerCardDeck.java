package ru.lanit.boozer.impl;

import ru.lanit.boozer.api.Card;
import ru.lanit.boozer.api.CardDeck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BoozerCardDeck implements CardDeck {

    

    private ArrayList<Card> cards = new ArrayList<>();

    public BoozerCardDeck(){
        new BoozerCardDeck(36);
    }

    public BoozerCardDeck(int a){
        if (a==36){
                cards.add(new PlayCard(6,"6 Черви"));
                cards.add(new PlayCard(6,"6 Крести"));
                cards.add(new PlayCard(6,"6 Пики"));
                cards.add(new PlayCard(6,"6 Буби"));
                cards.add(new PlayCard(7,"7 Черви"));
                cards.add(new PlayCard(7,"7 Крести"));
                cards.add(new PlayCard(7,"7 Пики"));
                cards.add(new PlayCard(7,"7 Буби"));
                cards.add(new PlayCard(8,"8 Черви"));
                cards.add(new PlayCard(8,"8 Кретси"));
                cards.add(new PlayCard(8,"8 Пики"));
                cards.add(new PlayCard(8,"8 Буби"));
                cards.add(new PlayCard(9,"9 Черви"));
                cards.add(new PlayCard(9,"9 Крести"));
                cards.add(new PlayCard(9,"9 Пики"));
                cards.add(new PlayCard(9,"9 Буби"));
                cards.add(new PlayCard(10,"10 Черви"));
                cards.add(new PlayCard(10,"10 Крести"));
                cards.add(new PlayCard(10,"10 Пики"));
                cards.add(new PlayCard(10,"10 Буби"));
                cards.add(new PlayCard(11,"Валет Черви"));
                cards.add(new PlayCard(11,"Валет Крести"));
                cards.add(new PlayCard(11,"Валет Пики"));
                cards.add(new PlayCard(11,"Валет Буби"));
                cards.add(new PlayCard(12,"Дама Черви"));
                cards.add(new PlayCard(12,"Дама Крести"));
                cards.add(new PlayCard(12,"Дама Пики"));
                cards.add(new PlayCard(12,"Дама Буби"));
                cards.add(new PlayCard(13,"Король Черви"));
                cards.add(new PlayCard(13,"Король Крести"));
                cards.add(new PlayCard(13,"Король Пики"));
                cards.add(new PlayCard(13,"Король Буби"));
                cards.add(new PlayCard(14,"Туз Черви"));
                cards.add(new PlayCard(14,"Туз Крести"));
                cards.add(new PlayCard(14,"Туз Пики"));
                cards.add(new PlayCard(14,"Туз Буби"));
        }
    }

    @Override
    public void setCards(List<Card> cards){
        this.cards.addAll(cards);
    }
    @Override
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public void removeCard (Card card){
        for(Card cardFromDeck : cards){
            if (cardFromDeck.equals(card)){
                cards.remove(card);
                System.out.println("Карта " + ((PlayCard)card).getName() + " удалена из колоды.");
            }
            else System.out.println("Такой карты в колоде нет.");
        }
    }

    @Override
    public LinkedList<Card> shuffleDeck(ArrayList<Card> cards){//отталкивайся отсюда
        LinkedList<Card> shuffeledDeck = new LinkedList<>();
        while(!cards.isEmpty()){
            Random random = new Random();
            int i = random.nextInt(cards.size());
            shuffeledDeck.add(cards.get(i));
            cards.remove(i);
        }
        return shuffeledDeck;
    }
}