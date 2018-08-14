public class PlayCard extends Card{
    private int value;
    private String name;
    private String suit;

    public PlayCard(int value, String name){
        setValue(value);
        setName(name);
    }

    public PlayCard(String name){
        setName(name);
        String[] strings = name.split("\\s");
        setSuit(strings[1]);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
