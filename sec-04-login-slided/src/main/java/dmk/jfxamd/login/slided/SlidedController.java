package dmk.jfxamd.login.slided;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class SlidedController implements Initializable {

  @FXML
  private Pane slide1;

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
    var slide1fadeOut = createFadeOut(slide1);
    var slide2fadeOut = createFadeOut(slide2);
    var slide3fadeOut = createFadeOut(slide3);
    var slide4fadeOut = createFadeOut(slide4);
    var slide1fadeIn = createFadeIn(slide1);
    var slide2fadeIn = createFadeIn(slide2);
    var slide3fadeIn = createFadeIn(slide3);
    var slide4fadeIn = createFadeIn(slide4);

    slide4fadeOut.setOnFinished(actionEvent -> slide3fadeOut.play());
    slide3fadeOut.setOnFinished(actionEvent -> slide2fadeOut.play());
    slide2fadeOut.setOnFinished(actionEvent -> slide1fadeOut.play());
    slide1fadeOut.setOnFinished(actionEvent -> slide1fadeIn.play());
    slide1fadeIn.setOnFinished(actionEvent -> slide2fadeIn.play());
    slide2fadeIn.setOnFinished(actionEvent -> slide3fadeIn.play());
    slide3fadeIn.setOnFinished(actionEvent -> slide4fadeIn.play());
    slide4fadeIn.setOnFinished(actionEvent -> slide4fadeOut.play());

    slide4fadeOut.play();
  }

  private FadeTransition createFadeIn(Node node) {
    return createFadeTransition(0.0, 1.0, node);
  }
  private FadeTransition createFadeOut(Node node) {
    return createFadeTransition(1.0, 0.0, node);
  }
  private FadeTransition createFadeTransition(double from, double to, Node node) {
    FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000.0));
    fadeTransition.setFromValue(from);
    fadeTransition.setToValue(to);
    fadeTransition.setNode(node);

    return fadeTransition;
  }
}
