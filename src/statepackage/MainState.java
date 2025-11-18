package statepackage;

public class MainState {

    public static void main(String[] args) {
        WeaponLifeCycle weapon = new WeaponLifeCycle("Dragon Slayer", 30, 3);

        System.out.println("Initial Status:");
        weapon.displayStatus();

        System.out.println("\nUsing the weapon (first use)...");
        weapon.use();
        weapon.displayStatus();

        System.out.println("\nUsing the weapon again...");
        weapon.use();
        weapon.displayStatus();

        System.out.println("\nUsing the weapon again (likely to break)...");
        weapon.use();
        weapon.displayStatus();

        System.out.println("\nAttempting to repair the weapon with 100 XP...");
        weapon.startQuestWithRepair(100);
        weapon.displayStatus();
    }
}
