package items;

import core.Player;
public abstract class Item {
    private final String type;
    protected boolean used;

    public Item(String type) {
        this.type = type;
        this.used = false;
    }

    public String getType() {
        return type;
    }

    public boolean isUsed(){
        return used;
    }

    public abstract void use(Player player);
}
