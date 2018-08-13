public class BoozerCard implements Card{
    private int value;
    private String name;

    public BoozerCard(int value, String name){
        setValue(value);
        setName(name);

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
