package server;

import client.ClientHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa el servidor de chat.
 * Gestiona las conexiones de los clientes y mantiene una lista de controladores de clientes.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private static Server server;

    private List<ClientHandler> clients = new ArrayList<>();

    private Server() throws IOException {
        serverSocket = new ServerSocket(3001);
    }

    public static Server getInstance() throws IOException {
        return server!=null? server:(server=new Server());
    }
    /**
     * Método que acepta conexiones de clientes y crea un controlador de cliente para cada conexión.
     */
    public void makeSocket(){
        while (!serverSocket.isClosed()){
            try{
                socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket,clients);
                clients.add(clientHandler);
                System.out.println("client socket accepted "+socket.toString());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
