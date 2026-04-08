package characters;

import core.Enemy;
public class Wolf extends Enemy {
    private static final String NAME = "Wolf";
    private static final int BASE_HEALTH_POINTS = 40;
    private static final int BASE_ATK = 45;
    private static final int BASE_DEF = 5;
    private static final int BASE_SPD = 35;
    private static final int DEFAULT_MOVES_AVAILABLE = 1;
    private static final int MAX_HEALTH_POINTS = 40;
    public Wolf(){
        super(NAME, BASE_HEALTH_POINTS, BASE_ATK, BASE_DEF, BASE_SPD, DEFAULT_MOVES_AVAILABLE,MAX_HEALTH_POINTS);
    }
}
