import java.util.Scanner;

public class MazeGame {
    private Space[][] maze;
    private Scanner scan;
    private Player p1;

    public MazeGame() {
        maze = new Space[15][15];
    }

    public void start() {
        makePlayer();
        fillMaze();
        play();
    }

    public void makePlayer() {
        scan = new Scanner(System.in);
        System.out.println("Welcome to the maze game!\nEnter your name: ");
        p1 = new Player(scan.next());
        System.out.println("Welcome, " + p1.getSymbol() + "!");
    }

    public void fillMaze () {
        maze[14][0] = p1;
        for (int r = 14; r>13; r++) {
            for (int c = 1; c<maze[0].length; c++) {

            }
        }
        Goal goal = new Goal("#");
    }

    public void printMaze () {
        for (Space[] spaces : maze) {
            for (int c = 0; c < maze[0].length; c++) {
                System.out.print(spaces[c].getSymbol());
            }
            System.out.println();
        }
    }

    public void play() {
        int row = 14;
        int col = 0;
        boolean game = true;
        while (game && p1.getHunger() > 0) {
            printMaze();
            System.out.println("You have " + p1.getHunger() + " hunger left(don't let this reach 0!)");
            System.out.print("Enter W A S D: ");
            String choice = scan.nextLine();
            if (choice.equals("W")) {
                if (row > 0) {
                    if (maze[row-1][col] instanceof Wall) {
                        System.out.println("I can't go there because there is a wall");
                    } else {
                        maze[row][col] = new Space(" ");
                        row--;
                        p1.move();
                        p1.getHungry(1);
                    }
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("A")) {
                if (col > 0) {
                    if (maze[row][col-1] instanceof Wall) {
                        System.out.println("I can't go there because there is a wall");
                    } else {
                        maze[row][col] = new Space(" ");
                        col--;
                        p1.move();
                        p1.getHungry(1);
                    }
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("S")) {
                if (row < 7) {
                    if (maze[row+1][col] instanceof Wall) {
                        System.out.println("I can't go there because there is a wall");
                    } else {
                        maze[row][col] = new Space(" ");
                        row++;
                        p1.move();
                        p1.getHungry(1);
                    }
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("D")) {
                if (col < 7) {
                    if (maze[row][col+1] instanceof Wall) {
                        System.out.println("I can't go there because there is a wall");
                    } else {
                        maze[row][col] = new Space(" ");
                        col++;
                        p1.move();
                        p1.getHungry(1);
                    }
                } else {
                    System.out.println("Will go out of bound");
                }
            } else {
                System.out.println("INVALID DIRECTION");
            }
            if (maze[row][col] instanceof Coin) {
                p1.addScore(((Coin) maze[row][col]).getCoinValue());
                System.out.println("You picked a coin valued at " + ((Coin) maze[row][col]).getCoinValue());
            } else if (maze[row][col] instanceof Goal) {
                game = false;
            }
            maze[row][col] = p1;
        }
        printMaze();
        if (p1.getHunger() > 0) {
            System.out.println("You win!");
            System.out.println("Number of moves: " + p1.getMoves());
            System.out.println("Points earned: " + p1.getScore());
        } else {
            System.out.println("You lose! You spent too much time in the maze and starved");
            System.out.println("Better luck next time!");
            System.out.println("Number of moves: " + p1.getMoves());
            System.out.println("Points earned: " + p1.getScore());
        }

    }
}
