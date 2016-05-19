package finalproject;


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
        window = new Window();
        game = new Game();
        menu = new Menu();
        window.setContentPane(menu);
        startGame();

    }

    private static void startGame() { 
        
        Deck player = new Deck();
        player.saveDeck();
        player.readDeck("C:\\Users\\d.holmberg\\Desktop\\GitHub\\FinalProject40S\\GameSaves\\test.txt");
        
        Deck enemy = new Deck();
        enemy.setDefault2();
        
        BattleManager battleManager = new BattleManager(player, enemy);
        
        finalproject.FinalProject.window.setVisible(true); 
    }

}
