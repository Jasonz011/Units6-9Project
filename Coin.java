public class Coin extends Space {
    private int coinValue;
    public Coin(String s, int v) {
        super(s);
        coinValue = v;
    }

    public int getCoinValue() {
        return coinValue;
    }
}
