package actions;

import java.util.ArrayList;
import core.Combatant;
import core.Player;
import items.Item;
public class UseItem implements Action {
	private Item item;
	private Player user;   // only Players have items
	private Combatant target;
	private ArrayList<Combatant> enemies;
	
	public UseItem(Player user, Item item, Combatant target, ArrayList<Combatant> enemies) {
		this.user = user;
		this.item = item;
		this.target = target;
		this.enemies = enemies;
	}
	
	public boolean isValid(Combatant user) {
		return item != null && this.user.getItems().contains(item);
	}
	
	public void execute() {
		item.use(user, target, enemies);
		System.out.println(user.getName() + " used " + item.getType() + "!");
	}
	
	// actual counting of number of items used would be in battle engine 


}
