public class Goblin extends Enemy {
    private static final String NAME = "Goblin";
    private static final int BASE_HEALTH_POINTS = 55;
    private static final int BASE_ATK = 35;
    private static final int BASE_DEF = 15;
    private static final int BASE_SPD = 25;
    private static final int DEFAULT_MOVES_AVAILABLE = 1;
    private static final int MAX_HEALTH_POINTS = 55;

    Goblin(){
        super(NAME, BASE_HEALTH_POINTS, BASE_ATK, BASE_DEF, BASE_SPD, DEFAULT_MOVES_AVAILABLE, MAX_HEALTH_POINTS);
    }
}