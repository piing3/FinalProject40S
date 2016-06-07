package Multiplayer;

import static Multiplayer.ClientHandler.ins;
import static Multiplayer.ClientHandler.outs;
import static Multiplayer.ClientHandler.sockets;
import java.io.ObjectOutputStream;
import com.sun.xml.internal.ws.wsdl.writer.document.Message;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utillity.DataPacket;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class Client extends Thread{
    
    int i;

    public Client(int port) {
        i = port;
    }
    
    @Override
    public void run() {
        while (true) {
            if (sockets[i] == null) continue;
            if (ins[i] == null) continue;
            try {
                DataPacket<Action> inMessage = (DataPacket<Action>)ins[i].readObject();
                //**********************

//                if (inMessage.getData().equals("Exit")) {
//                    sockets[i] = null;
//                    ins[i] = null;
//                    outs[i] = null;
//                    System.out.println("Socket #"+i+", "+/*names[i]+*/", disconected");
//                    continue;
//                }
                
                Action input = (Action) inMessage.getData();
                if (input.text != null) {
                    //string inputs
                }
                else{   
                    DataPacket<Action> outMessage = new DataPacket<>(/*names[i]+": "+*/input);
                    sendData(outMessage);
                }

            }catch(java.net.SocketException e){
                sockets[i] = null;
                outs[i] = null;
                ins[i] = null;
                System.out.println("Socket #"+i+", "+/*names[i]+*/", disconected");
                sendData(new DataPacket<>("menu"));
                wipeSockets();
    
            }  catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("IO Exception");
            }
//            catch (Exception ex) {
//                System.out.println("Error: " + ex);
//                continue;
//            }            
        }
    }
    
    public <T> void  sendData(T data){
        for (ObjectOutputStream out : outs) {
            if (out != null && out != outs[i]) {
                try {
                    out.writeObject(data);
                    out.flush();
                    
                } catch (IOException ex) {
                    System.out.println("IO Exception");
                }
            }
        }
    }

    private void wipeSockets() {
        for (int j = 0; j < sockets.length; j++) {
            sockets[i] = null;
            outs[i] = null;
            ins[i] = null;
        }
        System.out.println("Sockets wiped");
    }
}
