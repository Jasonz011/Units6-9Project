import java.util.Locale;

public class MazeGame {
    private Space[][] maze;
    public MazeGame() {
        maze = new Space[10][10];
    }

    public void start() {

    }

    public void play() {
        int row = 7;
        int col = 0;
        boolean game = true;
        while (game) {
            printMaze();
            System.out.print("Enter W A S D: ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("w")) {
                if (row > 0) {
                    maze[row][col] = new Space(" ");
                    row--;
                    p1.move();
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("a")) {
                if (col > 0) {
                    maze[row][col] = new Space(" ");
                    col--;
                    p1.move();
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("s")) {
                if (row < 7) {
                    maze[row][col] = new Space(" ");
                    row++;
                    p1.move();
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("d")) {
                if (col < 7) {
                    maze[row][col] = new Space(" ");
                    col++;
                    p1.move();
                } else {
                    System.out.println("Will go out of bound");
                }
            } else {
                System.out.println("INVALID DIRECTION");
            }
            if (maze[row][col] instanceof Coin)  {
                p1.addCoins(((Coin) maze[row][col]).getCoinValue());
                System.out.println("You picked a treasure valued at " + ((Coin) maze[row][col]).getCoinValue());
            } else if (maze[row][col] instanceof Goal) {
                game = false;
            }
            maze[row][col] = p1;
        }
        printMaze();
        System.out.println("You win!");
        System.out.println("Number of moves: " + p1.getMoves());
        System.out.println("Treasure points earned: " + p1.getScore());

    }
}
