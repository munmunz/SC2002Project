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

            if (checkWinLose()){
                return; // End of round
            }
        }

        GameUI.displayRoundInfo(roundNumber);
    }

    public boolean checkWinLose() {
        if (BattleField.getPlayer().getHealthPoints() == 0){
            GameUI.gameOverLose();
            System.exit(0);
            return true;
        }
        else if (BattleField.getAliveEnemies().isEmpty()){
            int nextWaveIndex = this.currentWaveIndex + 1;
            ArrayList<Enemy> nextWave = DifficultyLevel.getWave(this.difficulty, nextWaveIndex);

            if (nextWave.isEmpty()) {
                GameUI.gameOverWin();
                System.exit(0);
                return true;
            } else {
                GameUI.displayRoundInfo(roundNumber);
                this.currentWaveIndex = nextWaveIndex;
                BattleField.setEnemies(nextWave);
                GameUI.nextWave(currentWaveIndex + 1);
                return true;
            }            
        }
        else return false; // Player alive and enemy alive, game continues
    }
}
