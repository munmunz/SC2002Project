public class Wizard extends Player {
    private static final String NAME = "Wizard";
    private static final int BASE_HEALTH_POINTS = 200;
    private static final int BASE_ATK = 50;
    private static final int BASE_DEF = 10;
    private static final int BASE_SPD = 20;
    private static final int DEFAULT_MOVES_AVAILABLE = 1;
    private static final int DEFAULT_SKILL_COOLDOWN = 0;
    private static final int MAX_HEALTH_POINTS = 200;

    Wizard(){
        super(NAME, BASE_HEALTH_POINTS, BASE_ATK, BASE_DEF, BASE_SPD, DEFAULT_MOVES_AVAILABLE, MAX_HEALTH_POINTS, DEFAULT_SKILL_COOLDOWN);
    }

}
