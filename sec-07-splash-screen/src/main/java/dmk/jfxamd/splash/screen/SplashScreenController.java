package dmk.jfxamd.splash.screen;

import io.github.palexdev.materialfx.controls.MFXProgressSpinner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
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
  private MFXProgressSpinner spinner;

  @FXML
  private Label titleLabel;

  @FXML
  private Label waitLabel;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    logoLabel.setTranslateY(700);
    titleLabel.setTranslateY(700);
    helloLabel.setTranslateY(700);
    spinner.setTranslateY(700);
    waitLabel.setTranslateY(700);

    var logoTransition = translateTransition(logoLabel, 1.0, 0, -700);
    var titleTransition = translateTransition(titleLabel, 1.0, 0, -700);
    var helloTransition = translateTransition(helloLabel, 1.0, 0, -700);
    var spinnerTransition = translateTransition(spinner, 1.0, 0, -700);
    var waitTransition = translateTransition(waitLabel, 1.0, 0, -700);

    logoTransition.setOnFinished(actionEvent -> titleTransition.play());
    titleTransition.setOnFinished(actionEvent -> helloTransition.play());
    helloTransition.setOnFinished(actionEvent -> spinnerTransition.play());
    spinnerTransition.setOnFinished(actionEvent -> waitTransition.play());

    logoTransition.play();
  }

  // TODO: Move to utils
  private TranslateTransition translateTransition(Node node, Double duration, double byX, double byY) {
    TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);

    translateTransition.setByX(byX);
    translateTransition.setByY(byY);
//    translateTransition.play();

    return translateTransition;
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
