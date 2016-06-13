package finalproject;


import cards.BananaSpell;
import cards.BushMinion;
import cards.DarkBananaMinion;
import cards.DrawSpell;
import cards.LongBoyMinion;
import cards.SanicMinion;
import cards.TrogdorMinion;
import java.io.File;
import utillity.Settings;
import visuals.GUI;
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
    public static GUI gui;
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
//        Settings.readSettings(settings);
        
        window = new Window();
        window.setContentPane(new Menu());
        startGame();
        

    }

    public static void startGame() { 
        
        Deck player = Deck.readDeck("C:\\Users\\Davin\\Desktop\\FinalProject40S\\gamefiles\\default.txt");
        
        battleManager = new BattleManager(player);
//        battleManager.drawCard();
//        battleManager.drawCard();
//        battleManager.playCard(battleManager.playerHand.CARDS.getData(0));
        
        window.setVisible(true); 
    }

    private static void test(Deck player) {
        player.addCard(new BananaSpell());
        player.addCard(new BananaSpell());
        player.addCard(new BananaSpell());
        player.addCard(new BananaSpell());
        player.addCard(new BushMinion());
        player.addCard(new BushMinion());
        player.addCard(new BushMinion());
        player.addCard(new BushMinion());
        player.addCard(new SanicMinion());
        player.addCard(new SanicMinion());
        player.addCard(new SanicMinion());
        player.addCard(new SanicMinion());
        player.addCard(new SanicMinion());
        player.addCard(new SanicMinion());
        player.addCard(new TrogdorMinion());
        player.addCard(new TrogdorMinion());
        player.addCard(new TrogdorMinion());
        player.addCard(new TrogdorMinion());
        player.addCard(new TrogdorMinion());
        player.addCard(new DarkBananaMinion());
        player.addCard(new DarkBananaMinion());
        player.addCard(new DarkBananaMinion());
        player.addCard(new DarkBananaMinion());
        player.addCard(new LongBoyMinion());
        player.addCard(new LongBoyMinion());
        player.addCard(new LongBoyMinion());
        player.addCard(new LongBoyMinion());
        player.addCard(new DrawSpell());
        player.addCard(new DrawSpell());
        player.addCard(new DrawSpell());
    }

}
