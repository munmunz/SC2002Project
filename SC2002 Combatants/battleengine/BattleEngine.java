package battleengine;

import core.BattleField;
import core.Combatant;
import core.Enemy;
import core.Player;
import java.util.ArrayList;
import ui.GameUI;

public class BattleEngine {
    private int roundNumber;
    private int difficulty;
    private int currentWaveIndex;

    public BattleEngine(int difficulty) {
        this.roundNumber = 1;
        currentWaveIndex = 0;
        this.difficulty = difficulty;
    }

    public void StartGame(Player player){
        BattleField.setPlayer(player);
        BattleField.setEnemies(DifficultyLevel.getWave(this.difficulty, 0));

        while (true) {
            runRound();
            GameUI.displayRoundInfo(roundNumber);

            for (Combatant combatant : BattleField.getAliveCombatants()){
            combatant.decrement(); // Decrement cooldown and status
            }

            roundNumber +=1;
        }
    }

    public void runRound() {
        ArrayList<Combatant> turnOrder = TurnOrderStrategy.roundOrder(BattleField.getAliveCombatants());

        for (Combatant combatant : turnOrder){ // Give everyone 1 move
            combatant.setMovesAvailable(combatant.getMovesAvailable() + 1);
        }

        for (Combatant combatant : turnOrder){
            while (combatant.getHealthPoints() > 0 && combatant.getMovesAvailable() > 0){
                if (combatant instanceof Player){
                    PlayerControl.getPlayerMove((Player) combatant);
                }
                else if (combatant instanceof Enemy){
                    EnemyControl.getEnemyMove((Enemy) combatant);
                }

                combatant.setMovesAvailable(combatant.getMovesAvailable() - 1);
            }

            checkWinLose();
        }
    }

    public void checkWinLose() {
        if (BattleField.getPlayer().getHealthPoints() == 0){
            System.out.println("Player died. Game over.");
            System.exit(0);
        }
        else if (BattleField.getAliveEnemies().isEmpty()){
            int nextWaveIndex = this.currentWaveIndex + 1;
            ArrayList<Enemy> nextWave = DifficultyLevel.getWave(this.difficulty, nextWaveIndex);

            if (nextWave.isEmpty()) {
                System.out.println("All waves defeated. Player wins!");
                System.exit(0);
            } else {
                this.currentWaveIndex = nextWaveIndex;
                BattleField.setEnemies(nextWave);
                System.out.println("Wave " + (this.currentWaveIndex + 1) + " begins!");
            }            
        }
        else return; // Player alive and enemy alive, game continues
    }
}
