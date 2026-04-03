import java.util.ArrayList;

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
		// item must exist and the player must own it
		return item != null && this.user.getItems().contains(item);
	}
	
	public void execute() {
		item.use(user, target, enemies);
		user.getItems().remove(item);
		System.out.println(user.getName() + " used " + item.getType() + "!");
	}
	

	
	
}