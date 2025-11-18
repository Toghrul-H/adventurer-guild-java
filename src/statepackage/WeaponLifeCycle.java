package statepackage;

public class WeaponLifeCycle {
    
    enum State {
        NEW,
        USED,
        DAMAGED,
        BROKEN
    }
    
    private State currentState;
    private String name;
    private int power;
    private int maxDurability;
    private int durability;
    private boolean firstUse;

    public WeaponLifeCycle(String name, int power, int durability) {
        this.name = name;
        this.power = power;
        this.maxDurability = durability;
        this.durability = durability;
        this.currentState = State.NEW;
        this.firstUse = true;
    }

    public void use() {
        if (currentState == State.BROKEN) {
            System.out.println("Weapon is broken and cannot be used.");
            return;
        }

        if (firstUse && currentState == State.NEW) {
            System.out.println("First use bonus: Full power +10%!");
            firstUse = false;
            currentState = State.USED;
        } else {
            System.out.println("Weapon used with standard power.");
        }

        durability--;
        updateState();
    }

    private void updateState() {
        if (durability <= 0) {
            currentState = State.BROKEN;
            durability = 0;
            System.out.println("Weapon is now broken.");
        } else if (durability < maxDurability / 2) {
            currentState = State.DAMAGED;
            System.out.println("Weapon is damaged. Power reduced to 75%.");
        } else if (!firstUse) {
            currentState = State.USED;
        }
    }

    public void startQuestWithRepair(int availableXP) {
        if (currentState == State.BROKEN) {
            int repairCost = power * 2;
            if (availableXP >= repairCost) {
                durability = maxDurability;
                firstUse = true;
                currentState = State.NEW;
                System.out.println("Weapon successfully repaired to new state.");
            } else {
                System.out.println("Not enough XP to repair the weapon.");
            }
        } else {
            System.out.println("Weapon does not need repair.");
        }
    }

    public void displayStatus() {
        System.out.println("Weapon: " + name);
        System.out.println("Current State: " + currentState);
        System.out.println("Durability: " + durability + "/" + maxDurability);
    }
}