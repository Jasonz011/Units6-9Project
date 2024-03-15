public class Goal extends Space {
    private boolean goalReached;
    public Goal(String s) {
        super(s);
        goalReached = false;
    }

    public boolean reached() {
        return goalReached;
    }

    public void setGoalReached(boolean reached) {
        goalReached = reached;
    }
}
