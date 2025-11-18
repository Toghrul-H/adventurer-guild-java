package adventurerguild;

/**
 * Represents a monster with name, health, and attack power.
 * @author Totu-vostro-5640
 */
public class Monster {
    private String name;
    private int health;
    private int attackPower;
    private int armor;

    /**
     * Constructs a Monster
     * @param name
     * @param health
     * @param attackPower
     * @param armor
     */
    public Monster(String name, int health, int attackPower, int armor) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    public int getArmor() {
        return armor;
    }

    /**
     * Applies damage to the monster, reduced by armor.
     *
     * @param damage
     */
    public void receiveDamage(int damage) {
        int netDamage = damage - armor;

        if (netDamage < 0) {
            netDamage = 0;
        }

        health -= netDamage;

        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Checks if the monster is dead.
     *
     * @return true if health is 0
     */
    public boolean isDead() {
        if (health == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}