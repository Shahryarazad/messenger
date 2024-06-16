package server;

import org.example.messenger.Client;

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
                        user.messages = new MessagesQueue(username);
                        Server.status.put(user,"offline");
                        Server.users.add(user);
                        System.out.println("[SERVER] user added");
                        break;
                    case "delete":
                        Server.status.remove(user,"offline");
                        Server.users.remove(user);
                        System.out.println("[SERVER] user deleted");
                        break;
                    case "login":
                        Server.status.put(user,"online");
                        System.out.println("[SERVER] logged in");
                        break;
                    case "logout":
                        Server.status.put(user,"offline");
                        System.out.println("[SERVER] logged out");
                        break;
                    case "to_":
                        String rec = in.readLine();
                        for (int i = 0; i < Server.users.size(); i++) {
                            if(Server.users.get(i).getUsername().equals(rec))
                                Server.users.get(i).messages.addMessage(in.readLine()+in.readLine()+in.readLine()+in.readLine());
                        }
                        break;
                    case "print":
                        String user = in.readLine();
                        for (int i = 0; i < Server.users.size(); i++) {
                            if(Server.users.get(i).getUsername().equals(user)) {
                                String s = "";
                                while (!Server.users.get(i).messages.isEmpty()) {
//                                    System.out.println(Server.users.get(i).messages.getMessage());
                                    s += String.valueOf(Server.users.get(i).messages.getMessage());
                                }
                                out.println(s);
                            }
                        }
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
