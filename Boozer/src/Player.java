import java.util.HashSet;
import java.util.LinkedList;

public class Player {
    private String name;
    private LinkedList<Card> hand = new LinkedList<>();

    public Player(String name) {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getHand(){
        return hand.size();
    }

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