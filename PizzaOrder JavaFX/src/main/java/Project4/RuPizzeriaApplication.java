package Project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Application class for the GUI. Creates fxml, scene, sets title and stage.
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class RuPizzeriaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RuPizzeriaApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("RU Pizza");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Main method for application calls launch
     *
     * @param args no arguments are input
     */
    public static void main(String[] args) {
        launch();
    }
}