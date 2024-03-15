public class Player extends Space {
    private int score;
    private int moves;
    public Player(String s) {
        super(s);
        score = 0;
        moves = 0;
    }

    public int getScore() {
        return score;
    }

    public void addCoins(int coins)  {
        score += coins;
    }

    public void move() {
        moves++;
    }

    public int getMoves() {
        return moves;
    }
}
