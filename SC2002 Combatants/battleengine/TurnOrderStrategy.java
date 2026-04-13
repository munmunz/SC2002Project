package battleengine;
// test
import java.util.ArrayList;

import core.Combatant;

public class TurnOrderStrategy {

    public ArrayList<Combatant> roundOrder(ArrayList<Combatant> combatants) {
        combatants.sort(Comparators.comparing(combatants -> combatants.getSpeed()))
        return combatants;

    }
}
