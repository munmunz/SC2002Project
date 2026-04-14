package items;

import core.BattleField;
import core.Enemy;
import core.Player;
import java.util.ArrayList;
import statuses.SmokeBombedStatus;
import statuses.SmokeBombInvulnerability;
public class SmokeBomb extends Item {
    public SmokeBomb() {
        super("Smoke Bomb");
    }

    @Override
    public void use(Player player) {
        ArrayList<Enemy> enemies = BattleField.getAliveEnemies();
        for (Enemy enemy : enemies) {
            enemy.applyStatus(new SmokeBombedStatus(enemy));
        }
        player.applyStatus(new SmokeBombInvulnerability(player));
        used = true;
    }

    public Item copy(){
        return new SmokeBomb();
    }
}
