public class Wall extends Space {
    public Wall(String s) {
        super(s);
    }

    @Override
    public void printAction() {
        System.out.println("Oops! Can't go that way because there's a wall");
    }
}
