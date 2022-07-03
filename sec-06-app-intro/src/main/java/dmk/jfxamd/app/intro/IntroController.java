package dmk.jfxamd.app.intro;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class IntroController implements Initializable {

  @FXML
  private Label pageLabel;

  @FXML
  private AnchorPane slide1;

  @FXML
  private AnchorPane slide2;

  @FXML
  private AnchorPane slide3;

  private int currentPage;
  private final int totalPages = 3;

  private final List<AnchorPane> pages = new ArrayList<>();

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    pages.add(slide1);
    pages.add(slide2);
    pages.add(slide3);

    currentPage = 1;

    translateAnimation(0.5, slide2, 600);
    translateAnimation(0.5, slide3, 600);
  }

  @FXML
  void nextClick(ActionEvent event) {
    next();
  }

  @FXML
  void previousClick(ActionEvent event) {
    previous();
  }

  @FXML
  void nextSwipe(SwipeEvent event) {
    System.out.println("SwipeEvent: " + event.getEventType());
    next();
  }

  @FXML
  void previousSwipe(SwipeEvent event) {
    System.out.println("SwipeEvent: " + event.getEventType());
    previous();
  }

  private void next() {
    if (currentPage < totalPages) {
      currentPage++;
      translateAnimation(0.5, pages.get(currentPage - 1), -600);
      setPageLabel();
    }
  }

  private void previous() {
    if (currentPage > 1) {
      translateAnimation(0.5, pages.get(currentPage - 1), 600);
      currentPage--;
      setPageLabel();
    }
  }

  private void translateAnimation(double duration, Node node, double byX) {
    TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
    translateTransition.setByX(byX);
    translateTransition.play();
  }

  private void setPageLabel() {
    pageLabel.setText(String.format("%d/%d", currentPage, totalPages));
  }
}
