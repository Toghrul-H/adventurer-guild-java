package adventurerguild;
/**
 * Bow class extend of Weapon
 * @author Totu-vostro-5640
 */
public class Bow extends Weapon {
    /**
     * Creates a bow with the given stats by calling the base weapon constructor.
     * @param name
     * @param powerBoost
     * @param durability 
     */
    public Bow(String name, int powerBoost, int durability) {
        super(name, powerBoost, durability);
    }

    /**
     * Calculates damage after reducing monster armor and adjusts durability based on armor.
     * @param monster 
     */
    @Override
    public void useWeapon(Monster monster) {
        if (!isUsable()) return;

        int armorBypass = (int)(monster.getArmor() * 0.3); 
        int effectiveArmor = monster.getArmor() - armorBypass;
        int damage = Math.max(0, getPowerBoost() - effectiveArmor);

        monster.receiveDamage(damage);

        int durabilityLoss = (int)(monster.getArmor() * 0.1);
        if (durabilityLoss < 1) durabilityLoss = 1; 
        reduceDurability(durabilityLoss);

    }
}

