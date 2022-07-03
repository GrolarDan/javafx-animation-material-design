package dmk.jfxamd.login.slided;

import dmk.jfxamd.utilities.transition.FadeTransitionBuilder;
import dmk.jfxamd.utilities.transition.TransitionBuilder;
import dmk.jfxamd.utilities.transition.TransitionPlayer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class SlidedController implements Initializable {

  @FXML
  private Pane slide2;

  @FXML
  private Pane slide3;

  @FXML
  private Pane slide4;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    var transitionPlayer = new TransitionPlayer();

    transitionPlayer.add(createFadeOutBuilder(slide4));
    transitionPlayer.add(createFadeOutBuilder(slide3));
    transitionPlayer.add(createFadeOutBuilder(slide2));
    transitionPlayer.add(createFadeInBuilder(slide2));
    transitionPlayer.add(createFadeInBuilder(slide3));
    transitionPlayer.add(createFadeInBuilder(slide4));

    transitionPlayer.playInfinite();
  }

  private TransitionBuilder<?> createFadeInBuilder(Node node) {
    return createFadeTransitionBuilder(0, 1, node);
  }

  private TransitionBuilder<?> createFadeOutBuilder(Node node) {
    return createFadeTransitionBuilder(1, 0, node);
  }

  private TransitionBuilder<?> createFadeTransitionBuilder(double fromValue, double toValue, Node node) {
    return FadeTransitionBuilder.builder()
        .withFromValue(fromValue)
        .withToValue(toValue)
        .withDuration(Duration.millis(3000))
        .withNode(node);
  }

}
