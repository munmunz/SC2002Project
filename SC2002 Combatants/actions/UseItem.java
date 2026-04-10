package actions;

import core.Combatant;
import core.Player;
import items.Item;
public class UseItem extends Action {
	private Item item;

	private static final String NAME = "Use Item";
	public UseItem() {
		super(NAME);
	}
	
	public boolean isValid(Combatant user) {
		return user instanceof Player
			&& item != null
			&& ((Player) user).getItems().contains(item)
			&& !item.isUsed();
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
