public class Wall extends Space {
    public Wall(String s) {
        super(s);
    }

    public void ranInWall() {
        System.out.println("Oops! Can't go that way because there's a wall");
    }
}
