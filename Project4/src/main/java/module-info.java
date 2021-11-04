module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens Project4 to javafx.fxml;
    exports Project4;
}