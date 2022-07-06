package dmk.jfxamd.home.screen;

import dmk.jfxamd.utilities.transition.FadeTransitionBuilder;
import dmk.jfxamd.utilities.transition.TransitionBuilder;
import dmk.jfxamd.utilities.transition.TransitionPlayer;
import dmk.jfxamd.utilities.transition.TranslateTransitionBuilder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class HomeScreenController implements Initializable {

  private static final double DRAWER_OPACITY_MAX = 0.22;
  private static final double DRAWER_OPACITY_MIN = 0;
  private static final double DRAWER_BY_X_POSITIVE = 600;
  private static final double DRAWER_BY_X_NEGATIVE = -DRAWER_BY_X_POSITIVE;
  private static final Duration DRAWER_DURATION = Duration.seconds(0.5);

  @FXML
  private AnchorPane pane2;

  @FXML
  private AnchorPane pane3;

  @FXML
  private AnchorPane pane4;

  @FXML
  private AnchorPane drawerPane;

  @FXML
  private AnchorPane opacityPane;

  @FXML
  private FontIcon drawerIcon;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    initDrawer();
    animate();
  }

  private void initDrawer() {
    var translateOut = TranslateTransitionBuilder.builder().withByX(DRAWER_BY_X_NEGATIVE).withDuration(DRAWER_DURATION).withNode(drawerPane)
        .withOnFinishedHandler(actionEvent -> drawerPane.setVisible(false)).build();
    var translateIn = TranslateTransitionBuilder.builder().withByX(DRAWER_BY_X_POSITIVE).withDuration(DRAWER_DURATION).withNode(drawerPane).build();
    var fadeOut = FadeTransitionBuilder.builder().withFromValue(DRAWER_OPACITY_MAX).withToValue(DRAWER_OPACITY_MIN).withDuration(DRAWER_DURATION).withNode(opacityPane)
        .withOnFinishedHandler(actionEvent -> opacityPane.setVisible(false)).build();
    var fadeIn = FadeTransitionBuilder.builder().withFromValue(DRAWER_OPACITY_MIN).withToValue(DRAWER_OPACITY_MAX).withDuration(DRAWER_DURATION).withNode(opacityPane).build();

    drawerIcon.setOnMouseClicked(mouseEvent -> {
        opacityPane.setVisible(true);
        drawerPane.setVisible(true);
        fadeIn.play();
        translateIn.play();
    });

    opacityPane.setOnMouseClicked(mouseEvent -> {
      fadeOut.play();
      translateOut.play();
    });

    opacityPane.setVisible(false);
    opacityPane.setOpacity(DRAWER_OPACITY_MIN);
    drawerPane.setVisible(false);
    drawerPane.setTranslateX(DRAWER_BY_X_NEGATIVE);
  }

  private void animate() {
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
