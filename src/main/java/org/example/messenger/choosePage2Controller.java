package org.example.messenger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class choosePage2Controller {

    public TextField message;
    public TextField receiver;
    @FXML
    private Button getMessage;

    @FXML
    private Button logout;

    @FXML
    private Button sendMessage;

    @FXML
    private TextArea ta;

    @FXML
    void onGetClick(ActionEvent event) {
        Client.socketOut.println("print");
        Client.socketOut.println(Client.mainStage.getUserData());
        String s = "\n";
        try {
            s += Client.socketIn.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ta.appendText(s);

    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        Client.socketOut.println("logout");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-page.fxml")));
        Scene scene = new Scene(root);
        Client.mainStage.setScene(scene);
        Client.mainStage.show();
    }

    @FXML
    void onSendClick(ActionEvent event) {
        Client.socketOut.println("to_");
        Client.socketOut.println(receiver.getText());
        Client.socketOut.println("_from_");
        Client.socketOut.println(Client.mainStage.getUserData());
        Client.socketOut.println(": ");
        Client.socketOut.println(message.getText());
    }

}

