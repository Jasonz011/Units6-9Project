public class Player extends Space {
    private int score;
    private int move;
    public Player(String s) {
        super(s);
        score = 0;
        move = 0;
    }

    public int getScore() {
        return score;
    }

    public void addCoins(int coins)  {
        score += coins;
    }

    public void move() {
        move++;
    }
}
