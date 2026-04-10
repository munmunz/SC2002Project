package actions;

import java.util.ArrayList;
import core.Combatant;
import core.Player;
import items.Item;
public class UseItem extends Action{
	private Item item;
	// private Combatant target; // Not needed
	// private ArrayList<Combatant> enemies;

	private static final String NAME = "Use Item";
	public UseItem() {
		super(NAME);
	}
	
	public UseItem(Player user, Item item, Combatant target, ArrayList<Combatant> enemies) {
		this.item = item;
		this.target = target;
		this.enemies = enemies;
	}
	
	public void execute() {
		item.use((Player) user);


		System.out.println(user.getName() + " used " + item.getType() + "!");
	}
	
	// actual counting of number of items used would be in battle engine 

	public Action copy(){
        Action copy = new UseItem();
        return copy;
    }

	public void setItem(Item itemChoice){
		this.item = itemChoice;
	}

}
