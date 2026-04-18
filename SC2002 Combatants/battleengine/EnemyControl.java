package battleengine;

import actions.Action;
import actions.Targetable;
import core.BattleField;
import core.Enemy;
import ui.GameUI;

public class EnemyControl {

    public static void getEnemyMove(Enemy enemy) {
        Action move = (enemy.getActions()).get(0);
        move.setUser(enemy);

        if (move instanceof Targetable){
            ((Targetable)move).setTarget(BattleField.getPlayer());
        }

        GameUI.displayAction(move.execute());;
    }
}
