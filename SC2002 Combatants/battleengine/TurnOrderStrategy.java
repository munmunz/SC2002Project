package battleengine;
import java.util.Comparator;
import java.util.ArrayList;

import core.Combatant;

public class TurnOrderStrategy {

    public static ArrayList<Combatant> roundOrder(ArrayList<Combatant> combatants) {
        combatants.sort(Comparator.comparingInt(Combatant::getSpeed).reversed());
        return combatants;
    }
}
