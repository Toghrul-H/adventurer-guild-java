package adventurerguild;

/**
 * Weapon class
 * @author Totu-vostro-5640
 */
public class Weapon {
    private String name;
    private int powerBoost;
    private int durability;
    private int maxDurability;
    
    /**
     * Initializes the weapon with a name, power boost value, and maximum durability.
     * @param name
     * @param powerBoost
     * @param durability 
     */
    public Weapon(String name, int powerBoost, int durability) {
        this.name = name;
        this.powerBoost = powerBoost;
        this.durability = durability;
        this.maxDurability = durability;
    }

    public int getPowerBoost() {
        return powerBoost;
    }
    public String getName(){
        return name;
    }

    public int getDurability() {
        return durability;
    }
    /**
     * Checks if the weapon still has durability and can be used.
     * @return 
     */
    public boolean isUsable() {
        return durability > 0;
    }
    /**
     * Decreases the weapon’s durability by a given amount, never below zero.
     * @param amount 
     */
    public void reduceDurability(int amount) {
        durability -= amount;
        if (durability < 0) {
            durability = 0;
        }
    }
    /**
     * Restores the weapon's durability to its maximum value.
     */
    public void repair() {
        durability = maxDurability;
    }
    /**
     * Attacks a monster using the weapon’s power boost and reduces durability.
     * @param monster 
     */
    public void useWeapon(Monster monster) {
        monster.receiveDamage(powerBoost);
        reduceDurability(1);
    }
}
