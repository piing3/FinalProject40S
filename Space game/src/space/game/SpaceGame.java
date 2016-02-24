package space.game;

import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author Davin
 */
public class SpaceGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        load();
        displayMainMenu();
        Globals.window.setVisible(true);
    }
    /**
     * Runs all systems needed for the game to start
     */
    private static void load() {
        Globals.window = new Window();
    }
    /**
     * displays the main menu screen
     */
    private static void displayMainMenu() {
        Globals.mainMenu = new MainMenu();
    }
    
    
    
}
