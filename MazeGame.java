import java.util.Scanner;

public class MazeGame {
    private Space[][] maze;
    private Scanner scan;
    private Player p1;
    private int[][] temp;

    public MazeGame() {
        maze = new Space[21][21];
        int[][] temp1 = {
                // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // 0
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1}, // 1
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, // 2
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 2, 1}, // 3
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, // 4
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1}, // 5
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1}, // 6
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1}, // 7
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1}, // 8
                {1, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1}, // 9
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1}, // 10
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1}, // 11
                {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}, // 12
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1}, // 13
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, // 14
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, // 15
                {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1}, // 16
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1}, // 17
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, // 18
                {1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1}, // 19
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // 20
        };

        temp = temp1;

    }

    public void start() {
        makePlayer();
        fillMaze();
        play();
    }

    public void makePlayer() {
        scan = new Scanner(System.in);
        System.out.println("Welcome to the maze game!\nEnter your name: ");
        p1 = new Player("😊");
        System.out.println("Welcome, " + p1.getSymbol() + "!");
    }

    public void fillMaze () {

        for (int r = 0; r<21; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                if (temp[r][c] == 1) {
                    maze[r][c] = new Wall("\uD83D\uDD33");
                } else if (temp[r][c] == 2){
                    maze[r][c] = new Coin("🪙", 5);
                } else {
                    maze[r][c] = new Space("⬛");
                }
            }
        }
        Goal goal = new Goal("👑");
        maze[0][9] = goal;
        maze[20][11] = p1;
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
        int row = 20;
        int col = 11;
        boolean game = true;
        while (game && p1.getHunger() > 0) {
            printMaze();
            System.out.println("You have " + p1.getHunger() + " hunger left(don't let this reach 0!)");
            System.out.print("Enter W A S D: ");
            String choice = scan.nextLine().toUpperCase();
            if (choice.equals("W")) {
                if (row > 0) {
                    if (maze[row-1][col] instanceof Wall) {
                        System.out.println("I can't go there because there is a wall");
                    } else {
                        maze[row][col] = new Space("⬛");
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
                        maze[row][col] = new Space("⬛");
                        col--;
                        p1.move();
                        p1.getHungry(1);
                    }
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("S")) {
                if (row < 20) {
                    if (maze[row+1][col] instanceof Wall) {
                        System.out.println("I can't go there because there is a wall");
                    } else {
                        maze[row][col] = new Space("⬛");
                        row++;
                        p1.move();
                        p1.getHungry(1);
                    }
                } else {
                    System.out.println("Will go out of bound");
                }
            } else if (choice.equals("D")) {
                if (col < 20) {
                    if (maze[row][col+1] instanceof Wall) {
                        System.out.println("I can't go there because there is a wall");
                    } else {
                        maze[row][col] = new Space("⬛");
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
