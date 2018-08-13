import java.util.HashSet;
import java.util.LinkedList;

public class Player {
    private String name;

    public String getName() {
        return this.name;
    }

    public Integer getHand(){
        return hand.size();
    }

    public Player(String name) {
        this.name = name;
    }

    private LinkedList<Card> hand = new LinkedList<>();

    public void addCard(Card card) {
        hand.add(card);
    }
    public Card dropCard(){
        try{
            Card card = hand.getFirst();
            hand.removeFirst();
            return card;
        }catch (Exception e){
            return null;
        }
    }
    public void addTable(HashSet<Card> table){
        hand.addAll(table);
    }
}