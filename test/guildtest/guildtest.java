package guildtest;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import adventurerguild.*;

public class guildtest {

    private Adventurer adventurer;
    private Weapon sword, bow, staff;
    private Monster monster1, monster2;
    private Quest quest;
    private Adventureguild guild;

    @Before
    public void setUp() {
        adventurer = new Adventurer("TestHero", 100, 20);
        sword = new Sword("TestSword", 10, 2);
        bow = new Bow("TestBow", 15, 3);
        staff = new Staff("TestStaff", 12, 5);

        adventurer.equipWeapon(sword);
        adventurer.equipWeapon(bow);
        adventurer.equipWeapon(staff);

        monster1 = new Monster("Goblin", 30, 5, 10);
        monster2 = new Monster("Ogre", 50, 10, 20);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(monster1);
        monsters.add(monster2);

        quest = new Quest("TestQuest", 50, monsters);
        guild = new Adventureguild();
    }

    @Test
    public void testUseSwordReducesDurability() {
        int initialDurability = sword.getDurability();
        sword.useWeapon(monster1);
        assertTrue(sword.getDurability() <= initialDurability);
    }


    @Test
    public void testUseStaffMayWeakenMonster() {
        int originalAttack = monster2.getAttackPower();
        staff.useWeapon(monster2);
        assertTrue(monster2.getAttackPower() <= originalAttack);
    }

    @Test
    public void testWeaponIsUsable() {
        while (sword.getDurability() > 0) {
            sword.useWeapon(monster1);
        }
        assertFalse(sword.isUsable());
        assertEquals(0, sword.getDurability());
    }


    @Test
    public void testMonsterReceivesDamage() {
        monster1.receiveDamage(20);
        int expected = 30 - Math.max(0, 20 - monster1.getArmor()); 
        assertEquals(expected, monster1.getHealth());
}


    @Test
    public void testMonsterDies() {
        int damage = monster1.getHealth() + monster1.getArmor(); 
        monster1.receiveDamage(damage);
        assertTrue(monster1.isDead());
    }


    @Test
    public void testAdventurerTotalPower() {
        int expectedPower = (int)(20 * 1.1);
        if (sword.isUsable()) expectedPower += sword.getPowerBoost();
        if (bow.isUsable()) expectedPower += bow.getPowerBoost();
        if (staff.isUsable()) expectedPower += staff.getPowerBoost();
        assertEquals(expectedPower, adventurer.getTotalPower());
    }

    @Test
    public void testAdventurerTakesDamage() {
        adventurer.takeDamage(30);
        assertEquals(70, adventurer.getHealth());
    }

    @Test
    public void testAdventurerDies() {
        adventurer.takeDamage(100);
        assertTrue(adventurer.isDead());
    }

    @Test
    public void testAdventurerRestoreHealth() {
        adventurer.takeDamage(50);
        adventurer.restoreHealth();
        assertEquals(100, adventurer.getHealth());
    }

    @Test
    public void testQuestCompletionSuccess() {
        Adventurer strongAdventurer = new Adventurer("StrongHero", 500, 100);
        strongAdventurer.equipWeapon(new Sword("MegaSword", 50, 5));
        quest.attempt(strongAdventurer);
        assertTrue(quest.isCompleted());
    }

    @Test
    public void testQuestCompletionFailure() {
        Adventurer weakAdventurer = new Adventurer("Weakling", 10, 5);
        weakAdventurer.equipWeapon(new Bow("FlimsyBow", 2, 1));
        quest.attempt(weakAdventurer);
        assertFalse(quest.isCompleted());
    }

    @Test
    public void testGuildAddAdventurer() {
        guild.addAdventurer(adventurer);
        assertEquals(1, guild.getAdventurers().size());
    }

    @Test
    public void testGuildAddQuest() {
        guild.addQuest(quest);
        assertEquals(1, guild.getQuests().size());
    }
}
