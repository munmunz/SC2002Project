package actions;

import core.Combatant;

public abstract class Action {
    private String name;
    protected Combatant user;

    public abstract String execute();
    public abstract Action copy();

    protected Action(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setUser(Combatant user){
        this.user = user;
    }

    public Combatant getUser(){
        return this.user;
    }
}
