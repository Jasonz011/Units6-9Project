public class Player extends Space {
    private int score;
    public Player(String s) {
        super(s);
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        score = newScore;
    }
}
