package org.example.messenger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class choosePageController {

    public AnchorPane anchor;
    @FXML
    private Button deleteButton;

    @FXML
    private Button loginButton;

    @FXML
    void onDeleteClick(ActionEvent event) throws IOException {
        Client.socketOut.println("delete");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sign-up.fxml")));
        Scene scene = new Scene(root);
        Client.mainStage.setScene(scene);
        Client.mainStage.show();
    }

    @FXML
    void onLoginClick(ActionEvent event) throws IOException {
        Client.socketOut.println("login");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-page2.fxml")));
        Scene scene = new Scene(root);
        Client.mainStage.setScene(scene);
        Client.mainStage.show();
    }

}
