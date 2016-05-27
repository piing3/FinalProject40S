package finalproject;


import java.io.File;
import utillity.Settings;
import visuals.Menu;
import visuals.Game;
import visuals.Window;
/**
 * Project:
 * Author: Davin
 * Date: 15-Mar-2016
 * Teacher: Mr. Wachs 
 */
public class FinalProject {
    public static Window window;
    public static Game game;
    public static Menu menu;
    public final static String settings = "C:\\Users\\d.holmberg\\Desktop\\GitHub\\FinalProject40S\\gamefiles\\settings.txt";
    public static BattleManager battleManager;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Thread visuals = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                window = new Window();
//                game = new Game();
//                window.setContentPane(game);
//            }
//        });
//        
//        visuals.run();
        Settings.readSettings(settings);
        window = new Window();
        game = new Game();
        menu = new Menu();
        window.setContentPane(menu);
        startGame();

    }

    private static void startGame() { 
        
        Deck player = new Deck();
        Deck.saveDeck(player);
        player = Deck.readDeck(Settings.saves);
        
        battleManager = new BattleManager(player);
        battleManager.drawCard();
        battleManager.drawCard();
        battleManager.drawCard();
        
        BattleField bf = new BattleField();
        
        finalproject.FinalProject.window.setVisible(true); 
    }

}
