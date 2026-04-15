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
	
	public void execute()  throws MissingItemException{
		if (item == null){
			throw new MissingItemException();
		}

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
