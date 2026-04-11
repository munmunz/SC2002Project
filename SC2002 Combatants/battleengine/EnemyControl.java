package battleengine;

import java.util.ArrayList;

import actions.Action;
import actions.BasicAttack;
import actions.Targetable;
import core.BattleField;
import core.Combatant;
import core.Enemy;

public class EnemyControl {

    public void getEnemyMove(ArrayList<Action> actions) {
        Enemy enemy = null;
        for (Enemy aliveEnemy : BattleField.getAliveEnemies()) {
            if (aliveEnemy.getActions() == actions) {
                enemy = aliveEnemy;
                break;
            }
        }

        if (enemy == null) {
            return;
        }

        Combatant player = null;
        for (Combatant combatant : BattleField.getAliveCombatants()) {
            if (!(combatant instanceof Enemy)) {
                player = combatant;
                break;
            }
        }

        if (player == null) {
            return;
        }

        Action enemyAction = new BasicAttack();
        enemyAction.setUser(enemy);
        ((Targetable) enemyAction).setTarget(player);
        enemyAction.execute();
    }
}
