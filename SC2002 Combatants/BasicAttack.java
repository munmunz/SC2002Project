public class BasicAttack implements Action {
    private Combatant user;
    private Combatant target;

    public BasicAttack(Combatant user, Combatant target) {
        this.user = user;
        this.target = target;
    }

    public boolean isValid(Combatant user) {
        return target != null && target.getHealthPoints() > 0;
    }

    public void execute() {
        int damage = Math.max(0, user.getAttack() - target.getDefense());
        
        // Check if target is protected by SmokeBomb (takes 0 damage)
        if (target.hasStatus("SmokeBombInvulnerability")) {
            damage = 0;
        }
        
        int newHp = Math.max(0, target.getHealthPoints() - damage);
        target.setHealthPoints(newHp);
        System.out.println(user.getName() + " attacks " + target.getName() + " for " + damage + " damage!");
        System.out.println(target.getName() + " HP: " + newHp);
    }
}
