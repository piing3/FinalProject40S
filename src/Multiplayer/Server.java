
package Multiplayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Janith (http://cyberasylum.wordpress.com/)
 */
public class Server{

    private static final int DEFAULT_PORT = 5000;

    private int port;
    private ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
        System.out.println("Server started");
    }

    public Server() {
        this(DEFAULT_PORT);
    }


    public void start(){
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Error creating server socket");
            return;
        }
        
        /*
         * Create a new instance of a Client Handler to handle
         * the new connection
         */
        ClientHandler clientHandler = new ClientHandler();
        
        while(true){
            Socket socket;
            try {
                socket = serverSocket.accept();
            } catch (IOException ex) {
                System.out.println("Error accepting socket");
                continue;
            }
            System.out.println("Server Socket accepted");
//            String name = null;
//            while (name == null) {
//                try {
//                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//                    out.writeObject(new Message<String> ("Please enter a name."));
//                    out.flush();
//                    
//                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
//                    Message inMessage = (Message)in.readObject();
//                    name = (String)inMessage.getMessage();
//                } catch (Exception ex) {
//                    System.out.println("Error: " + ex);
//                    continue;
//                }
//                
//            }
            clientHandler.addSocket(socket,"poop");

        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
        server.start();
    }
}
