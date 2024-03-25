public class Meat extends Space {
    private int hungerValue;
    public Meat(String s, int hungerValue) {
        super(s);
        this.hungerValue = hungerValue;
    }

    public int getHungerValue() {
        return hungerValue;
    }
}
