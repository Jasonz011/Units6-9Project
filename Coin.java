public class Coin extends Space {
    private int coinValue;

    public Coin(String s, int v) {
        super(s);
        coinValue = v;
    }

    public int getCoinValue() {
        return coinValue;
    }

    @Override
    public void printAction() {
        System.out.println("You picked a coin valued at " + coinValue);
    }
}
