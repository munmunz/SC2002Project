public class UseItem implements Action {
	private Item item;
	private Player user;   // only Players have items
	
	public UseItem(Player user, Item item) {
		this.user = user;
		this.item = item;
	}
	
	public boolean isValid(Combatant user) {
		// item must exist and the player must own it
		return item != null && this.user.getItems().contains(item);
	}
	
	public void execute() {
		item.use();
		user.getItems().remove(item);
		System.out.println(user.getName() + " used " + item.getType() + "!");
	}
	

	
	
}