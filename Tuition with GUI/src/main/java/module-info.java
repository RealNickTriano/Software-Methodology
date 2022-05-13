module com.example.project3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens tuitionProject3 to javafx.fxml;
    exports tuitionProject3;
}