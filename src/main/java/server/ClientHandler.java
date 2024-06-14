package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    User user;


    public ClientHandler(Socket clientSocket) throws IOException {
        client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }


    @Override
    public void run() {
        String text;
        try {
            while (true) {
                text = in.readLine();
                switch (text) {
                    case "sign up":
                        String username = in.readLine();
                        String name = in.readLine();
                        String password = in.readLine();
                        user = new User(name, password, username);
                        Server.users.add(user);
                        System.out.println("[SERVER] user added");
                        break;
                    case "delete":
                        Server.users.remove(user);
                        System.out.println("[SERVER] user deleted");
                        break;

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
