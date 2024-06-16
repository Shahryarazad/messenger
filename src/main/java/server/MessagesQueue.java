package server;

import java.util.LinkedList;
import java.util.Objects;

public class MessagesQueue {
    private LinkedList<String> queue=  new LinkedList<>();
    private LinkedList<Integer> queue1=  new LinkedList<>();
    String username;
    public MessagesQueue(String username){
        this.username = username;
    }
    public void addMessage(String message){
        if(username.equals("Bob"))
            queue1.add(Integer.valueOf(message));
        else
            queue.add(message);
    }
    public Object getMessage(){
        if(username.equals("Bob"))
            return queue1.poll();
        else
            return queue.poll();
    }
    public boolean isEmpty(){
        if(username.equals("Bob")) {
            return queue1.isEmpty();
        }
    else
            return queue.isEmpty();


    }
    public void clear(){
        if(username.equals("Bob")) {
            queue1.clear();
        }
        else
            queue.clear();
    }
}
