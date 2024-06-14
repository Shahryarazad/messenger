package server;

public class User {

    private String name;
    private String username;
    private String password;

    public User(String name, String password, String username) {
        setName(name);
        setPassword(password);
        setUsername(username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
