package utillity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project:
 * Author: Davin
 * Date: 25-May-2016
 * Teacher: Mr. Wachs 
 */
public abstract class Settings { 
    
    public static int hight = 1080;
    public static int width = 720;
    public static boolean fullscreen = false;
    public static String saves = "C:\\Users\\d.holmberg\\Desktop\\GitHub\\FinalProject40S\\gamefiles\\test.txt" ;  
    
    
    public static void readSettings(String path) {
        File file = new File(path);
        BufferedReader br;
        
        try {
            br = new BufferedReader(new FileReader(new File(path)));//new new new
            String line;
            for (int i = 0; i < 6; i++) {
                line = br.readLine();
                if(line.startsWith("Hight")){//This can't be the best way to do this.
                    line = line.substring(line.indexOf(58)+1);
                    line = line.trim();
                    hight = Integer.parseInt(line);
                }
                if(line.startsWith("Width")){
                    line = line.substring(line.indexOf(58)+1);
                    line = line.trim();
                    width = Integer.parseInt(line);
                }
                if(line.startsWith("Fullscreen")){
                    line = line.substring(line.indexOf(58)+1);
                    line = line.trim();
                    fullscreen = Boolean.parseBoolean(line);
                }
                if(line.startsWith("Saves")){
                    line = line.substring(line.indexOf(58)+1);
                    line = line.trim();
                    saves = line;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Settings not found. Using defaults");
            return;
        } catch (IOException ex) {
            System.out.println("Settings not found. Using defaults");
            return;
        }catch (NullPointerException ex) {
            System.out.println("Settings not found. Using defaults");
            return;
        }
        
        
    }
}
