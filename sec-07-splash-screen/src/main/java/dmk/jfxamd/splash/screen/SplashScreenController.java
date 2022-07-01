package dmk.jfxamd.splash.screen;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class SplashScreenController implements Initializable {
  @FXML
  private Label helloLabel;

  @FXML
  private Label logoLabel;

  @FXML
  private Label titleLabel;

  @FXML
  private Pane spinnerPane;

  @FXML
  private AnchorPane rootPane;

  private CloseCallback closeCallback;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    spinnerPane.setOpacity(0.0);

    logoLabel.setTranslateY(700);
    titleLabel.setTranslateY(700);
    helloLabel.setTranslateY(700);

    var logoTransition = translateTransition(logoLabel, 1, 0, -700);
    var titleTransition = translateTransition(titleLabel, 1, 0, -700);
    var helloTransition = translateTransition(helloLabel, 1, 0, -700);
    var spinnerTransition = fadeTransition(spinnerPane, 1, 0, 1);
    var rootPaneTransition = fadeTransition(rootPane, 5, 1, 0.1);

    logoTransition.setOnFinished(actionEvent -> titleTransition.play());
    titleTransition.setOnFinished(actionEvent -> helloTransition.play());
    helloTransition.setOnFinished(actionEvent -> spinnerTransition.play());
    spinnerTransition.setOnFinished(actionEvent -> rootPaneTransition.play());
    rootPaneTransition.setOnFinished(this::close);

    logoTransition.play();
  }

  public void setCloseCallback(CloseCallback closeCallback) {
    this.closeCallback = closeCallback;
  }

  private void close(ActionEvent actionEvent) {
    if (closeCallback != null) {
      closeCallback.run();
      System.out.println("------ splash screen closed ------");
    }
  }

  // TODO: Move to utils
  private TranslateTransition translateTransition(Node node, double duration, double byX, double byY) {
    TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);

    translateTransition.setByX(byX);
    translateTransition.setByY(byY);
//    translateTransition.play();

    return translateTransition;
  }

  private FadeTransition fadeTransition(Node node, double duration, double from, double to) {
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(duration), node);

    fadeTransition.setFromValue(from);
    fadeTransition.setToValue(to);
//    fadeTransition.play();

    return fadeTransition;
  }

  // TODO: Move to utils
  public static void delay(long millis, Runnable continuation) {
    Task<Void> sleeper = new SleepTask(millis);
    sleeper.setOnSucceeded(event -> continuation.run());
    new Thread(sleeper).start();
  }

  private static final class SleepTask extends Task<Void> {
    private final long millis;

    private SleepTask(long millis) {
      this.millis = millis;
    }

    @Override
    protected Void call() throws Exception {
      try {
        Thread.sleep(millis);
        System.out.println("Ended sleep");
      } catch (InterruptedException e) {
      }
      return null;
    }
  }
}
