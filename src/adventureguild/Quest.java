package adventurerguild;

import java.util.List;
/**
 * Represents a quest with monsters and difficulty.
 * @author Totu-vostro-5640
 */
public class Quest {
    private String name;
    private int difficulty;
    private List<Monster> monsters;
    private boolean completed;

    /**
     * Constructs a Quest.
     *
     * @param name
     * @param difficulty
     * @param monsters
     */
    public Quest(String name, int difficulty, List<Monster> monsters) {
        this.name = name;
        this.difficulty = difficulty;
        this.monsters = monsters;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    /**
     * Attempt the quest with an adventurer.
     *
     * @param adventurer
     */
    public void attempt(Adventurer adventurer) {
        for (Monster monster : monsters) {
            while (!monster.isDead() && !adventurer.isDead()) {
                for (Weapon weapon : adventurer.getWeapons()) {
                    if (weapon.isUsable()) {
                        System.out.println(adventurer.getName() + " uses " + weapon.getName() + " on " + monster.getName());
                        weapon.useWeapon(monster);
                    }
                }

                if (!monster.isDead()) {
                    adventurer.takeDamage(monster.getAttackPower());
                    System.out.println(monster.getName() + " attacks back. " + adventurer.getName() + " HP: " + adventurer.getHealth());
                }
            }

            if (monster.isDead()) {
                adventurer.gainExperience(10);
                System.out.println(monster.getName() + " is defeated! XP gained.");
            }

            if (adventurer.isDead()) {
                completed = false;
                return;
            }
        }

        adventurer.restoreHealth();
        completed = true;
    }
}