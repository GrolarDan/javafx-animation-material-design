package dmk.jfxamd.home.screen;

import dmk.jfxamd.utilities.transition.FadeTransitionBuilder;
import dmk.jfxamd.utilities.transition.TransitionPlayer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class HomeScreenController implements Initializable {

  @FXML
  private AnchorPane pane2;

  @FXML
  private AnchorPane pane3;

  @FXML
  private AnchorPane pane4;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    var transitionPlayer = new TransitionPlayer();

    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(1).withToValue(0).withDuration(Duration.seconds(3)).withNode(pane4));
    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(1).withToValue(0).withDuration(Duration.seconds(3)).withNode(pane3));
    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(1).withToValue(0).withDuration(Duration.seconds(3)).withNode(pane2));
    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(0).withToValue(1).withDuration(Duration.seconds(3)).withNode(pane2));
    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(0).withToValue(1).withDuration(Duration.seconds(3)).withNode(pane3));
    transitionPlayer.add(FadeTransitionBuilder.builder().withFromValue(0).withToValue(1).withDuration(Duration.seconds(3)).withNode(pane4));

    transitionPlayer.playInfinite();
  }
}
