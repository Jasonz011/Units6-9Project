public class Player extends Space {
    private int moves;
    private int hunger;
    private String name;
    public Player(String s, String name) {
        super(s);
        moves = 0;
        hunger = 100;
        this.name = name;
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
