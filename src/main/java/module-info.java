module org.example.messenger {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.messenger to javafx.fxml;
    exports org.example.messenger;
}