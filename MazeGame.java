import java.util.Scanner;
import java.util.ArrayList;

public class MazeGame {
    private Space[][] maze;
    private Scanner scan;
    private Player p1;
    private Goal goal;
    private int[][] temp;
    private ArrayList<Coin> coins;

    public MazeGame() {

        maze = new Space[21][21];
        coins = new ArrayList<>();

        temp = new int[][]{
                //0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // 0
                {1, 0, 0, 0, 0, 0, 1, 3, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1}, // 1
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, // 2
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 3, 1, 2, 1}, // 3
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, // 4
                {1, 3, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1}, // 5
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1}, // 6
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1}, // 7
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1}, // 8
                {1, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1}, // 9
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1}, // 10
                {1, 0, 0, 0, 0, 0, 1, 3, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1}, // 11
                {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}, // 12
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1}, // 13
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, // 14
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, // 15
                {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1}, // 16
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1}, // 17
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, // 18
                {1, 3, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 3, 1}, // 19
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // 20
        };

    }

    public void start() {
        makePlayer();
        fillMaze();
        play();
    }

    public void makePlayer() {
        scan = new Scanner(System.in);
        System.out.print("Welcome to the maze game!\nEnter your name: ");
        String name = scan.nextLine();
        p1 = new Player("😊", name);
        System.out.println("Welcome, " + p1.getName() + "!");
    }

    public void fillMaze() {

        for (int r = 0; r < 21; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                if (temp[r][c] == 1) {
                    maze[r][c] = new Wall("\uD83D\uDD33");
                } else if (temp[r][c] == 2) {
                    maze[r][c] = new Coin("🎁", 5);
                } else if (temp[r][c] == 3) {
                    maze[r][c] = new Meat("\uD83E\uDD69", 20);
                } else {
                    maze[r][c] = new Space("⬛");
                }
            }
        }
        goal = new Goal("👑");
        maze[0][9] = goal;
        maze[20][11] = p1;
    }

    public void printMaze() {
        for (Space[] spaces : maze) {
            for (int c = 0; c < maze[0].length; c++) {
                System.out.print(spaces[c].getSymbol());
            }
            System.out.println();
        }
    }

    public void play() {
        rules();
        int row = 20;
        int col = 11;
        while (!goal.reached() && p1.getHunger() > 0) {
            printMaze();
            System.out.println("You have " + p1.getHunger() + " hunger left(don't let this reach 0!)");
            System.out.print("Enter W A S D: ");
            String choice = scan.nextLine().toUpperCase();
            if (choice.equals("W")) {
                if (maze[row - 1][col] instanceof Wall) {
                    maze[row - 1][col].printAction();
                } else {
                    maze[row][col] = new Space("⬛");
                    maze[row][col].printAction();
                    row--;
                    p1.move();
                    p1.getHungry(1);
                }
            } else if (choice.equals("A")) {
                if (maze[row][col - 1] instanceof Wall) {
                    maze[row][col - 1].printAction();
                } else {
                    maze[row][col] = new Space("⬛");
                    maze[row][col].printAction();
                    col--;
                    p1.move();
                    p1.getHungry(1);
                }
            } else if (choice.equals("S")) {
                if (row == 20) {
                    System.out.println("You'll go out of bounds");
                } else {
                    if (maze[row + 1][col] instanceof Wall) {
                        maze[row + 1][col].printAction();
                    } else {
                        maze[row][col] = new Space("⬛");
                        maze[row][col].printAction();
                        row++;
                        p1.move();
                        p1.getHungry(1);
                    }
                }
            } else if (choice.equals("D")) {
                if (maze[row][col + 1] instanceof Wall) {
                    maze[row][col + 1].printAction();
                } else {
                    maze[row][col] = new Space("⬛");
                    maze[row][col].printAction();
                    col++;
                    p1.move();
                    p1.getHungry(1);
                }
            } else {
                System.out.println("INVALID DIRECTION");
            }
            if (maze[row][col] instanceof Coin) {
                coins.add((Coin) maze[row][col]);
                maze[row][col].printAction();
            } else if(maze[row][col] instanceof Meat) {
                maze[row][col].printAction();
                p1.getHungry(-((Meat) maze[row][col]).getHungerValue());
                System.out.println("Your current hunger is " + p1.getHunger());
            } else if (maze[row][col] instanceof Goal) {
                goal.setGoalReached(true);
            }
            maze[row][col] = p1;
        }
        printMaze();
        if (p1.getHunger() > 0) {
            System.out.println("You win!");
            System.out.println("Number of moves: " + p1.getMoves());
            int sum = 0;
            for (Coin coin: coins) {
                sum += coin.getCoinValue();
            }
            System.out.println("Score: " + sum);
        } else {
            System.out.println("You lose! You spent too much time in the maze and starved");
            System.out.println("Better luck next time!");
            System.out.println("Number of moves: " + p1.getMoves());
            System.out.println("Score: 0(you didn't finish the maze)");
        }
    }

    public void rules() {
        System.out.println("You are going to be represented by the 😊 emoji");
        System.out.println("There will be coins scattered across the maze, represented by 🎁. Collect them to get points!");
        System.out.println("You will start with 100 hunger, and each valid move will cost you one.");
        System.out.println("There will be pieces of meat you can pick up and eat which will replenish 20 hunger");
        System.out.println("The game ends when you reach the goal, represented by 👑 or when you run out of hunger");
        System.out.println("The game will start in 10 seconds, good luck!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
