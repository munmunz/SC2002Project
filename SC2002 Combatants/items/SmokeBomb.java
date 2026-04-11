package items;

import core.BattleField;
import core.Enemy;
import core.Player;
import statuses.SmokeBombedStatus;
public class SmokeBomb extends Item {
    public SmokeBomb() {
        super("Smoke Bomb");
    }

    @Override
    public void use(Player player) {
        for (Enemy enemy : BattleField.getAliveEnemies()) {
            enemy.applyStatus(new SmokeBombedStatus(enemy));
        }
    }
}
