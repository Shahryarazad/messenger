package org.example.messenger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class choosePageController {

    @FXML
    private Button deleteButton;

    @FXML
    private Button loginButton;

    @FXML
    void onDeleteClick(ActionEvent event) {
        Client.socketOut.println("delete");
    }

    @FXML
    void onLoginClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-page2.fxml")));
        Scene scene = new Scene(root);
        Client.mainStage.setScene(scene);
        Client.mainStage.setWidth(461);
        Client.mainStage.setHeight(480);
        Client.mainStage.show();
    }

}
