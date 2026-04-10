package actions;

import core.Combatant;

public abstract class Action {
    private String name;
    protected Combatant user;

    public abstract void execute();
    public abstract Action copy();

    protected Action(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setUser(Combatant user){
        this.user = user;
    }
}
