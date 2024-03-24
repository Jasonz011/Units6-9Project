public class Player extends Space {
    private int score;
    private int moves;
    private int hunger;
    private String name;
    public Player(String s, String name) {
        super(s);
        score = 0;
        moves = 0;
        hunger = 150;
        this.name = name;
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
    public String getName() {
        return name;
    }

    public void getHungry(int amt) {
        hunger -= amt;
    }
}
