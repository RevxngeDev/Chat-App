package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * Clase que gestiona la comunicación con un cliente conectado al servidor de chat.
 * Se encarga de recibir y enviar mensajes entre este cliente y los demás clientes conectados.
 */

public class ClientHandler {
    private Socket socket;
    private List<ClientHandler> clients;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String msg = "";

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        try {
            this.socket = socket;
            this.clients = clients;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (socket.isConnected()) {
                        msg = dataInputStream.readUTF();
                        for (ClientHandler clientHandler : clients) {
                            if (clientHandler.socket.getPort() != socket.getPort()) {
                                clientHandler.dataOutputStream.writeUTF(msg);
                                clientHandler.dataOutputStream.flush();
                            }
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

