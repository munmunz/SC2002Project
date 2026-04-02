public abstract class Item {
    private final String type;

    Item(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void use(Player player, Combatant target);
}
