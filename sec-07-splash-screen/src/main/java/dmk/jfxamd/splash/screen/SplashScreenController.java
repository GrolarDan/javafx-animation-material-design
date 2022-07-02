package dmk.jfxamd.splash.screen;

import dmk.jfxamd.utilities.transition.FadeTransitionBuilder;
import dmk.jfxamd.utilities.transition.TransitionPlayer;
import dmk.jfxamd.utilities.transition.TranslateTransitionBuilder;
import java.net.URL;
import java.util.ResourceBundle;
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

    var transitionPlayer = new TransitionPlayer();
    transitionPlayer.add(TranslateTransitionBuilder.builder().withByY(-700).withNode(logoLabel).withDuration(Duration.seconds(1)));
    transitionPlayer.add(TranslateTransitionBuilder.builder().withByY(-700).withNode(titleLabel).withDuration(Duration.seconds(1)));
    transitionPlayer.add(TranslateTransitionBuilder.builder().withByY(-700).withNode(helloLabel).withDuration(Duration.seconds(1)));
    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(0).withToValue(1).withNode(spinnerPane).withDuration(Duration.seconds(1)));
    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(1).withToValue(0.1).withNode(rootPane).withDuration(Duration.seconds(3)).withOnFinishedHandler(this::close));

    transitionPlayer.play();
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
