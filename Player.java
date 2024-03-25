public class Player extends Space {
    private int score;
    private int moves;
    private int hunger;
    private String name;
    public Player(String s, String name) {
        super(s);
        score = 0;
        moves = 0;
        hunger = 100;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score)  {
        this.score += score;
    }

    public void move() {
        System.out.println("Moving...");
        try {
            // fix wait
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        moves++;
    }

    public int getMoves() {
        return moves;
    }

    public int getHunger() {
        return hunger;
    }
    public void addHunger(int amt) {
        hunger += amt;
    }
    public String getName() {
        return name;
    }

    public void getHungry(int amt) {
        hunger -= amt;
    }
}
