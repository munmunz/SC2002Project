package items;

import actions.Action;
import actions.SpecialAction;
import battleengine.PlayerControl;
import core.Player;
import java.util.Iterator;

public class Powerstone extends Item {
    public Powerstone() {
        super("Power Stone");
    }

    public void use(Player player) {
        SpecialAction action = null;

        Iterator<Action> iterator = player.getActions().iterator(); // Search for special skill
        while (iterator.hasNext()) {
            Action currentAction = iterator.next();
            
            if (currentAction instanceof SpecialAction){
                action = (SpecialAction) (currentAction.copy());
                break;
            }
        }

        action.setUser(player);

        int originalCooldown = action.getCooldown();
        action.setCooldown(0); // Set Cooldown to 0
        PlayerControl.doAction(action);
        action.setCooldown(originalCooldown); // Restore cooldown to original value

        used = true;
    }

    public Item copy(){
        return new Powerstone();
    }
}
