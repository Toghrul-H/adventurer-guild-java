package adventurerguild;

import java.util.Random;
/**
 * Sword weapon extend of weapon
 * @author Totu-vostro-5640
 */
public class Sword extends Weapon {
    /**
     * Creates a sword with the given stats by calling the base weapon constructor.
     * @param name
     * @param powerBoost
     * @param durability 
     */
    public Sword(String name, int powerBoost, int durability) {
        super(name, powerBoost, durability);
    }

    /**
     * Attacks a monster, with a chance to deal double damage and higher durability loss.
     * @param monster 
     */
    @Override
    public void useWeapon(Monster monster) {
        Random rand = new Random();
        boolean isCritical = rand.nextInt(100) < 20;
        if (isCritical) {
            monster.receiveDamage(getPowerBoost() * 2);
            reduceDurability(2);
        } else {
            monster.receiveDamage(getPowerBoost());
            reduceDurability(1);
        }
    }
}
