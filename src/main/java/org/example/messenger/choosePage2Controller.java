package org.example.messenger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class choosePage2Controller {

    @FXML
    private Button getMessage;

    @FXML
    private Button logout;

    @FXML
    private Button sendMessage;

    @FXML
    void onGetClick(ActionEvent event) {

    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-page.fxml")));
        Scene scene = new Scene(root);
        Client.mainStage.setScene(scene);
        Client.mainStage.setWidth(461);
        Client.mainStage.setHeight(480);
        Client.mainStage.show();
    }

    @FXML
    void onSendClick(ActionEvent event) {

    }

}

