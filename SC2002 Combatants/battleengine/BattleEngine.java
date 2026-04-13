package battleengine;

import java.util.ArrayList;

import core.BattleField;
import core.Combatant;
import core.Enemy;
import core.Player;

public class BattleEngine {
    private int roundNumber;
    private int difficulty;
    private int currentWaveIndex;
    private final DifficultyLevel difficultyLevel;
    private boolean battleEnded;
    private boolean playerWon;

    public BattleEngine(int difficulty, Player player) {
        this.roundNumber = 1;
        this.difficulty = difficulty;
        this.currentWaveIndex = 0;
        this.difficultyLevel = new DifficultyLevel();
        this.battleEnded = false;
        this.playerWon = false;

        BattleField.setPlayer(player);

        ArrayList<Enemy> firstWave = this.difficultyLevel.getWave(this.difficulty, this.currentWaveIndex);
        BattleField.setEnemies(firstWave);

        if (firstWave.isEmpty()) {
            this.battleEnded = true;
            this.playerWon = true;
            System.out.println("No enemy waves configured. Player wins by default.");
        }
    }

    public void runRound() {
        if (this.battleEnded) {
            return;
        }

        checkWinLose();

        if (!this.battleEnded) {
            this.roundNumber++;
        }
    }

    public void checkWinLose() {
        Player player = null;
        for (Combatant combatant : BattleField.getAliveCombatants()) {
            if (combatant instanceof Player) {
                player = (Player) combatant;
                break;
            }
        }

        if (player == null || player.getHealthPoints() <= 0) {
            this.battleEnded = true;
            this.playerWon = false;
            System.out.println("Player was defeated.");
            return;
        }

        if (BattleField.getAliveEnemies().isEmpty()) {
            int nextWaveIndex = this.currentWaveIndex + 1;
            ArrayList<Enemy> nextWave = this.difficultyLevel.getWave(this.difficulty, nextWaveIndex);

            if (nextWave.isEmpty()) {
                this.battleEnded = true;
                this.playerWon = true;
                System.out.println("All waves defeated. Player wins!");
            } else {
                this.currentWaveIndex = nextWaveIndex;
                BattleField.setEnemies(nextWave);
                System.out.println("Wave " + (this.currentWaveIndex + 1) + " begins!");
            }
        }
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }

    public boolean isBattleEnded() {
        return this.battleEnded;
    }

    public boolean hasPlayerWon() {
        return this.playerWon;
    }
}
