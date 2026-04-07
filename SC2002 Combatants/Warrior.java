public class Warrior extends Player {
    private static final String NAME = "Warrior";
    private static final int BASE_HEALTH_POINTS = 260;
    private static final int BASE_ATK = 40;
    private static final int BASE_DEF = 20;
    private static final int BASE_SPD = 30;
    private static final int DEFAULT_MOVES_AVAILABLE = 1;
    private static final int DEFAULT_SKILL_COOLDOWN = 0;
    private static final int MAX_HEALTH_POINTS = 260;

    Warrior(){
        super(NAME, BASE_HEALTH_POINTS, BASE_ATK, BASE_DEF, BASE_SPD, DEFAULT_MOVES_AVAILABLE, MAX_HEALTH_POINTS, DEFAULT_SKILL_COOLDOWN);
    }

}