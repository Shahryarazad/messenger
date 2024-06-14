package org.example.messenger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class signupController {

    @FXML
    private TextField name;

    @FXML
    private TextField password;



    @FXML
    private TextField username;

    @FXML
    void onButtonClick(ActionEvent event) {
        Client.socketOut.println("sign up");
        Client.socketOut.println(username.getText());
        Client.socketOut.println(name.getText());
        Client.socketOut.println(password.getText());
        try {
            changePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void changePage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-page.fxml")));
        Scene scene = new Scene(root);
        Client.mainStage.setScene(scene);
        Client.mainStage.setWidth(461);
        Client.mainStage.setHeight(480);
        Client.mainStage.show();
    }

}
