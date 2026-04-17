package actions;

import core.Player;
import items.Item;
import actions.exceptions.MissingItemException;

public class UseItem extends Action{
	private Item item;
	// private Combatant target; // Not needed
	// private ArrayList<Combatant> enemies;

	private static final String NAME = "Use Item";
	public UseItem() {
		super(NAME);
	}
	
	public String execute()  throws MissingItemException{
		if (item == null){
			throw new MissingItemException();
		}

		item.use((Player) user);

		return user.getName() + " used Item (" + item.getType() + ")";
	}
	
	// actual counting of number of items used would be in battle engine 

	public Action copy(){
        Action copy = new UseItem();
        return copy;
    }

	public Item getItem(){
		return this.item;
	}

	public void setItem(Item itemChoice){
		this.item = itemChoice;
	}
}
