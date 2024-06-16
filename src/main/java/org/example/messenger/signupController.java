package org.example.messenger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import server.User;

import java.io.IOException;
import java.util.Objects;

public class signupController {

    public AnchorPane anchor;
    @FXML
    private TextField name;

    @FXML
    private TextField password;



    @FXML
    private TextField username;

    @FXML
    public void onButtonClick(ActionEvent event) {
        Client.socketOut.println("sign up");
        Client.socketOut.println(username.getText());
        Client.socketOut.println(name.getText());
        Client.socketOut.println(password.getText());
        try {
            changePage(username.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void changePage(String username) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-page.fxml")));
        Scene scene = new Scene(root);
        Client.mainStage.setUserData(username);
        Client.mainStage.setScene(scene);
        Client.mainStage.show();
    }

}
