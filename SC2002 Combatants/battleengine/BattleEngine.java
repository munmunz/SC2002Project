package battleengine;

public class BattleEngine {
    private int roundNumber;
    private int difficulty;
    private boolean sentBackup;

    public BattleEngine(int difficulty) {
        this.roundNumber = 1;
        this.difficulty = difficulty;
        this.sentBackup = false;
    }

    public void runRound() {
    }

    public void checkWinLose() {
    }
}
