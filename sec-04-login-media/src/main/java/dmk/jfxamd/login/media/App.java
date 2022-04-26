package dmk.jfxamd.login.media;

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
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        
        initMainWindow();
    }

    private void initMainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("main.fxml"));
            AnchorPane pane = loader.load();
            
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(App.class.getResource("media.css").toExternalForm());
            stage.setTitle("Signin with media");
            stage.setScene(scene);
            System.out.println("Set scene");
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        launch();
    }

}