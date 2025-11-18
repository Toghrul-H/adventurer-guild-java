package adventurerguild;

import java.util.Random;
/**
 * Staff class extend of Weapon
 * @author Totu-vostro-5640
 */
public class Staff extends Weapon {
    /**
     * Creates a staff with the given stats by calling the base weapon constructor.
     * @param name
     * @param powerBoost
     * @param durability 
     */
    public Staff(String name, int powerBoost, int durability) {
        super(name, powerBoost, durability);
    }

    /**
     * Has a chance to halve the monster’s attack power and deals damage, reducing durability slightly.
     * @param monster 
     */
    @Override
    public void useWeapon(Monster monster) {
        Random rand = new Random();
        boolean halveStrength = rand.nextInt(100) < 25;
        if (halveStrength) {
            monster.setAttackPower(monster.getAttackPower() / 2);
        }
        monster.receiveDamage(getPowerBoost());
        int durabilityLoss = (int)(getPowerBoost() * 0.1);
        reduceDurability(durabilityLoss);
    }
}
