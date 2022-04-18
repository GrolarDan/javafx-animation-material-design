package dmk.jfxamd.login.simple;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String MAIN_WINDOW_FXML = "main.fxml";
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        mainWindow();
    }

    private void mainWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(MAIN_WINDOW_FXML));
            AnchorPane pane = fxmlLoader.load();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(App.class.getResource("style.css").toExternalForm());
            stage.setResizable(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("signin");
            stage.setScene(scene);
            stage.show();
            stage.addEventHandler(KeyEvent.KEY_RELEASED, key -> {
                if (KeyCode.ESCAPE == key.getCode()) {
                    stage.close();
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch();
    }

}
