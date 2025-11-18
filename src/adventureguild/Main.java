package adventurerguild;
/**
 * Main class to start and run the guild simulation.
 * @author Totu-vostro-5640
 */
public class Main {
    public static void main(String[] args) {
        Adventureguild guild = new Adventureguild();

        guild.readFromFile("adventurers.txt", "quests.txt", "monsters.txt");

        System.out.println("Starting the quest simulation...\n");

        guild.assignQuests();

        System.out.println("\nQuest simulation completed!");
    }
}