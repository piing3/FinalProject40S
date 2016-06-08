/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiplayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import utillity.DataPacket;

/**
 *
 * @author Vince
 */
public class ClientHandler {
    /*
     * This class is responsible of handeling client requests
     */

    public static final int PORT_SIZE = 2; 
    public static Socket[] sockets = new Socket[PORT_SIZE];
    public static ObjectOutputStream[] outs = new ObjectOutputStream[PORT_SIZE];
    public static ObjectInputStream[] ins = new ObjectInputStream[PORT_SIZE];
//    private String[] names = new String[PORT_SIZE];
    Client client = null;

    ClientHandler() {
        for (int i = 0; i < PORT_SIZE; i++) {
            sockets[i] = null;
            outs[i] = null;
            ins[i] = null;
//            names[i] = null;
            
            client = new Client(i);
            client.start();
        }
    }
    
    public void addSocket(Socket socket, String name){
        for (int i = 0; i < PORT_SIZE; i++) {
            if (sockets[i] == null) {
                try {
                    sockets[i] = socket;
                    outs[i] = new ObjectOutputStream(socket.getOutputStream());
                    ins[i] = new ObjectInputStream(socket.getInputStream());
                    //names[i] = name;
                    if (i == 0)  client.sendData(new DataPacket<>(new Action("turn")));
                    return;
                } catch (IOException ex) {
                    System.out.println("Error adding new socket");
                    return;
                }
            }
        }
        System.out.println("port full");
    }
}
