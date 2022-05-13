module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.junit.jupiter.api;
    requires org.testng;


    opens Project4 to javafx.fxml;
    exports Project4;
}