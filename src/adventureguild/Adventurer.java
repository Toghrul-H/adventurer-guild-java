package adventurerguild;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents an adventurer with base power, health, and equipped weapons.
 * @author Totu-vostro-5640
 */
public class Adventurer {
    private String name;
    private int health;
    private int basePower;
    private int experience;
    private int rank;
    private List<Weapon> weapons;

    /**
     * Constructs an Adventurer.
     *
     * @param name
     * @param health
     * @param basePower
     */
    public Adventurer(String name, int health, int basePower) {
        this.name = name;
        this.health = health;
        this.basePower = basePower;
        this.experience = 0;
        this.rank = 1;
        this.weapons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    /**
     * Equips a weapon.
     *
     * @param weapon
     */
    public void equipWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    /**
     * Calculates total attack power.
     *
     * @return total power
     */
    public int getTotalPower() {
        double power = basePower * (1 + 0.1 * rank);

        for (Weapon weapon : weapons) {
            if (weapon.isUsable()) {
                power += weapon.getPowerBoost();
            }
        }

        return (int) power;
    }

    /**
     * Reduces health from damage.
     *
     * @param damage
     */
    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public boolean isDead() {
        if (health == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void restoreHealth() {
        health = 100;
    }

    public void gainExperience(int xp) {
        experience += xp;

        if (experience >= rank * 10) {
            rank++;
            basePower = (int)(basePower * 1.2);
            experience = 0;
        }
    }
}