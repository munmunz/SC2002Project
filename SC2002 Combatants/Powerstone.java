public class ShieldBash implements Action {
    private Combatant user;
    private Combatant target;

    public ShieldBash(Combatant user, Combatant target) {
        this.user = user;
        this.target = target;
    }

    public boolean isValid(Combatant user) {
        if (!(user instanceof Player)) {
            return false;
        }

        Player player = (Player) user;

        if (player.getSkillCooldown() > 0) {
            System.out.println("ShieldBash is on cooldown! (" + player.getSkillCooldown() + " turns remaining)");
            return false;
        }

        return target != null && target.getHealthPoints() > 0;
    }

    public void execute() {
        int damage = Math.max(0, user.getAttack() - target.getDefense());
        int newHp = Math.max(0, target.getHealthPoints() - damage);
        target.setHealthPoints(newHp);
        System.out.println(user.getName() + " uses Shield Bash on " + target.getName()
                + " for " + damage + " damage!");

        if (newHp > 0) {
            // Stun status will be applied once the concrete status class exists.
        }

        ((Player) user).setSkillCooldown(3);
    }
}

