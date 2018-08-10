import java.util.HashSet;
import java.util.LinkedList;

class Player {
    private String name;

    String getName() {
        return this.name;
    }

    Integer getHand(){
        return hand.size();
    }

    Player(String name) {
        this.name = name;
    }

    private LinkedList<Card> hand = new LinkedList<>();

    void addCard(Card card) {
        hand.add(card);
    }
    Card dropCard(){
        try{
            Card card = hand.getFirst();
            hand.removeFirst();
            return card;
        }catch (Exception e){
            return null;
        }
    }
    void addTable(HashSet<Card> table){
        hand.addAll(table);
    }
}