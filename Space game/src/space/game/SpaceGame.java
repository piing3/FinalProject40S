package space.game;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        //newGame();
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
        Globals.window.changeDisplay(Globals.mainMenu);
    }

    static void newGame() {
        Globals.game = new Game();
        JPanel jPanel = new JPanel();
        jPanel.setBounds(0, 0, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        Globals.window.remove(Globals.mainMenu);
        Globals.window.add(Globals.game);
        Globals.window.repaint();
        
//        String value = JOptionPane.showInputDialog("Enter a value");
//        JFileChooser fc = new JFileChooser();
//        int file = fc.showOpenDialog(Globals.window);
//        
//        if (file == JFileChooser.APPROVE_OPTION) {
//            File text = fc.getSelectedFile();
//            try {
//                FileWriter fw = new FileWriter(text);
//                fw.write(value);
//                fw.close();
//            } catch (IOException ex) {
//            }
//        }
//        displayMainMenu();
    }

    static void loadGame() {
        String value = "";
        JFileChooser fc = new JFileChooser();
        int file = fc.showOpenDialog(Globals.window);
        
        if (file == JFileChooser.APPROVE_OPTION) {
            File text = fc.getSelectedFile();
            try {
                Scanner s = new Scanner(text);
                while (s.hasNext()) {                    
                    value += s.next()+" ";
                }
            } catch (IOException ex) {
            }
            JOptionPane.showMessageDialog(Globals.window, value);
        }
        displayMainMenu();
    }

    static void options() {
        
    }

    static void exit() {
        System.exit(0);
    }
    
    
    
}
