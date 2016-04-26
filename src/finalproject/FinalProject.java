package finalproject;


import Visuals.Menu;
import Visuals.Game;
import Visuals.Window;
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
        Hand hand = new Hand();
        Visuals.Hand handVisual = new Visuals.Hand(hand);
        handVisual.setLocation(0, game.getHeight()-handVisual.getHeight());
        game.add(handVisual,0);
        
        finalproject.FinalProject.window.setVisible(true); 
    }

}
