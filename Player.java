public class Player extends Space {
    private int score;
    private int moves;
    private int hunger;
    public Player(String s) {
        super(s);
        score = 0;
        moves = 0;
        hunger = 200;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score)  {
        this.score += score;
    }

    public void move() {
        moves++;
    }

    public int getMoves() {
        return moves;
    }

    public int getHunger() {
        return hunger;
    }

    public void getHungry(int amt) {
        hunger -= amt;
    }
}
