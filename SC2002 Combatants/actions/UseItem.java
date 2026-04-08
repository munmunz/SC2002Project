package actions;

import java.util.ArrayList;
import core.Combatant;
import core.Player;
import items.Item;
public class UseItem implements Action {
	private Item item;
	private Player user;   // only Players have items
	private Combatant target;
	
	public UseItem(Player user, Item item) { // change parameters
		this.user = user;
		this.item = item;

	}
	
	public boolean isValid(Combatant user) {  // return True?
		// item must exist and the player must own it
		// return item != null && this.user.getItems().contains(item);
		return true;
	}
	
	public void execute() {
		item.use();
		System.out.println(user.getName() + " used " + item.getType() + "!");
	}
	
	// actual counting of number of items used would be in battle engine 


}
