package actions;

import java.util.ArrayList;
import core.Combatant;
import core.Player;
import items.Item;
public class UseItem extends Action implements Targetable{
	private Item item;
	private Combatant target;
	private ArrayList<Combatant> enemies;

	private static final String NAME = "Arcane Blast (Special)";
	public UseItem() {
		super(NAME);
		this.target = null;
	}
	
	public UseItem(Player user, Item item, Combatant target, ArrayList<Combatant> enemies) {
		this.item = item;
		this.target = target;
		this.enemies = enemies;
	}
	
	public boolean isValid(Combatant user) {
		return item != null && ((Player) this.user).getItems().contains(item);
	}
	
	public void execute() {
		item.use((Player) user, target, enemies);


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

	public void setTarget(Combatant target){
        this.target = target;
    }
}
