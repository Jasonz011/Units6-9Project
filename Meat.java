public class Meat extends Space {
    private int hungerValue;
    public Meat(String s, int hungerValue) {
        super(s);
        this.hungerValue = hungerValue;
    }

    public int getHungerValue() {
        return hungerValue;
    }

    @Override
    public void printAction() {
        super.printAction();
        System.out.println("You picked up a piece of meat and ate it, now you are less hungry");
    }
}
