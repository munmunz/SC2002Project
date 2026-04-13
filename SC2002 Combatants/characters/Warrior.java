package characters;

import actions.ShieldBash;
import core.Player;
public class Warrior extends Player {
    private static final String NAME = "Warrior";
    private static final int BASE_HEALTH_POINTS = 260;
    private static final int BASE_ATK = 40;
    private static final int BASE_DEF = 20;
    private static final int BASE_SPD = 30;
    private static final int DEFAULT_SKILL_COOLDOWN = 0;
    private static final int MAX_HEALTH_POINTS = 260;
    public Warrior(){
        super(NAME, BASE_HEALTH_POINTS, BASE_ATK, BASE_DEF, BASE_SPD, MAX_HEALTH_POINTS, DEFAULT_SKILL_COOLDOWN);
        this.actions.add(new ShieldBash());
    }

}
