package adventurerguild;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages the guild of adventurers and quest assignments.
 */
public class Adventureguild {

    private List<Adventurer> adventurers;
    private List<Quest> quests;

    /**
     * Constructs an Adventureguild object with empty lists.
     */
    public Adventureguild() {
        adventurers = new ArrayList<>();
        quests = new ArrayList<>();
    }

    /**
     * Adds an adventurer to the guild.
     * @param adventurer 
     */
    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    /**
     * Returns the list of adventurers.
     * @return 
     */
    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    /**
     * Adds a quest to the guild's quest list.
     * @param quest 
     */
    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    /**
     * Returns the list of quests.
     * @return 
     */
    public List<Quest> getQuests() {
        return quests;
    }

    /**
     * Reads adventurer data from file and creates adventurer objects.
     * @param fileName 
     */
    private void readAdventurers(String fileName) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNext()) {
                String name = scanner.next();
                int health = scanner.nextInt();
                int basePower = scanner.nextInt();
                adventurers.add(new Adventurer(name, health, basePower));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading adventurers file: " + e.getMessage());
        }
    }

    /**
     * Reads quest data and creates quest and monster objects.
     * @param questsFile 
     * @param monstersFile 
     */
    private void readQuests(String questsFile, String monstersFile) {
        try (Scanner questScanner = new Scanner(new BufferedReader(new FileReader(questsFile)))) {
            while (questScanner.hasNext()) {
                String questName = questScanner.next();
                int difficulty = questScanner.nextInt();
                List<Monster> monsters = new ArrayList<>();
                String monsterNames = questScanner.next();
                String[] monsterArray = monsterNames.split("-");

                for (String monsterName : monsterArray) {
                    monsters.add(new Monster(monsterName, 100, 50, 0));
                }

                quests.add(new Quest(questName, difficulty, monsters));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading quests file: " + e.getMessage());
        }
    }

    /**
     * Loads data from files into the guild.
     * @param adventurersFile 
     * @param questsFile 
     * @param monstersFile 
     */
    public void readFromFile(String adventurersFile, String questsFile, String monstersFile) {
        readAdventurers(adventurersFile);
        readQuests(questsFile, monstersFile);
    }

    /**
     * Assigns each adventurer to a quest in sequence and attempts it.
     */
    public void assignQuests() {
        for (int i = 0; i < Math.min(adventurers.size(), quests.size()); i++) {
            Adventurer adventurer = adventurers.get(i);
            Quest quest = quests.get(i);
            System.out.println(adventurer.getName() + " starts quest: " + quest.getName());
            quest.attempt(adventurer);
        }
    }
}
