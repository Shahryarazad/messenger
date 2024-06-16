package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {

    public static ArrayList<User> users = new ArrayList<>();

    static protected ArrayList<Thread> clients = new ArrayList<>();
    static HashMap<User,String> status= new HashMap<User,String>();
    public static void addAll(){
        users.add(new User("1","13840421","u1"));
        users.add(new User("2","13840422","u2"));
        users.add(new User("3","13840423","u3"));
    }
    public static void main(String[] args) {
        addAll();
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                Socket client = serverSocket.accept();
                Thread clientThread = new Thread(new ClientHandler(client));
                clientThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
