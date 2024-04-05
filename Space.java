public class Space {
    private final String symbol;
    public Space(String s) {
        symbol = s;
    }

    public String getSymbol() {
        return symbol;
    }

    public void printAction() {
        System.out.println("Moving...");
    }
}
