package dmk.jfxamd.splash.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

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
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("splashscreen.fxml"));
            AnchorPane pane = fxmlLoader.load();
            SplashScreenController splashScreenController = fxmlLoader.getController();
            splashScreenController.setCloseCallback(stage::close);

            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(App.class.getResource("splashscreen.css").toExternalForm());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("SEC 07-01 : Splash - Screen");
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
