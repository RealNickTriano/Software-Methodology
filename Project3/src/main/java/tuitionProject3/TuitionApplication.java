package tuitionProject3;

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
public class TuitionApplication extends Application {

    /**
     * start method to start the application
     * @param stage top level JavaFX container
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TuitionApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Tuition Manager");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method for application calls launch
     * @param args no arguments are input
     */
    public static void main(String[] args) {
        launch();
    }
}