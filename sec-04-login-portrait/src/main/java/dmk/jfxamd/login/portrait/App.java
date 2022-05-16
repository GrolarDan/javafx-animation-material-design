package dmk.jfxamd.login.portrait;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        initMainWindow();
    }

    private void initMainWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("portrait.fxml"));
            AnchorPane pane = fxmlLoader.load();

            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(App.class.getResource("portrait.css").toExternalForm());
            stage.setTitle("Login with portrait");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch();
    }

}
