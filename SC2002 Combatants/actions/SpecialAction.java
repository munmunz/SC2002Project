package actions;

public abstract class SpecialAction extends Action{
    protected int cooldown;

    protected SpecialAction(String name){
        super(name);
    }

	public int getCooldown(){
		return this.cooldown;
	}

	public void setCooldown(int cooldown){
		this.cooldown = cooldown;
	}
}
