package Multiplayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import utillity.DataPacket;
import visuals.Menu;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class Game {
    
    private static ObjectInputStream in = null;
    private static ObjectOutputStream out = null;
    private static Socket socket = null;
    
    public static Action sending;
    public static Action receiving;
        
    public Game() {

        try {
            socket = new Socket("127.0.0.1", 5000);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return;
        }
        
        Thread send = new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                    try {
                        if (out == null) {
                            out = new ObjectOutputStream(socket.getOutputStream());
                        }
                        if (sending != null) {
                            DataPacket<Action> outMessage = new DataPacket<>(sending);
                            sending = null;
                            out.writeObject(outMessage);
                            out.flush();
                        }
                    }catch (Exception e) {
                        System.out.println("Error: "+e.getLocalizedMessage());
                    }
                }
            }
        });
        send.start();
        
        Thread receive = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        if (in == null) {
                            in = new ObjectInputStream(socket.getInputStream());
                        }
                        DataPacket<Object> inMessage = (DataPacket<Object>) in.readObject();
                        if (inMessage.getData() instanceof String) {
                            String s = (String)inMessage.getData();
                            if (s.equalsIgnoreCase("exit")) System.exit(0);
                            if (s.equalsIgnoreCase("menu")){
                                finalproject.FinalProject.window.setContentPane(new Menu());
                                finalproject.FinalProject.startGame();
                            }
                        }
                        if (inMessage.getData() instanceof Action) {
                            receiving = (Action)inMessage.getData();
                            finalproject.FinalProject.battleManager.IO(receiving);
                        }
                        
                    } catch (java.net.SocketException ex) {
                        System.out.println("Connection lost");
                        System.exit(0);
                    } catch (IOException | ClassNotFoundException ex) {
                        System.out.println("Error: " + ex);
                        continue;
                    }
                }
            }
        });
        receive.start();
        
        

    }
}
