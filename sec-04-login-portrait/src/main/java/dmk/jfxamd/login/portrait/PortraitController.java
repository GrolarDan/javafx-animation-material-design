/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dmk.jfxamd.login.portrait;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.effects.ripple.MFXCircleRippleGenerator;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class PortraitController implements Initializable {

    @FXML
    private ImageView image;

    @FXML
    private MFXTextField username;

    @FXML
    private MFXPasswordField password;

    @FXML
    private MFXButton btnSignin;
//    private MFXCircleRippleGenerator rippleGenerator;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition rt = new RotateTransition(Duration.seconds(25), image);
        rt.setByAngle(9 * 360);
        rt.play();

        setImage("email_black.png", username::setLeadingIcon);
        setImage("Security-Password.png", password::setLeadingIcon);
        
//        rippleGenerator = btnSignin.getRippleGenerator();
//        btnSignin.addEventFilter(KeyEvent.KEY_PRESSED, (key) -> {
//            if (KeyCode.SPACE.equals(key) || KeyCode.ENTER.equals(key)) {
//                rippleGenerator.generateRipple(event);
//            }
//        });
    }

    @FXML
    void click(ActionEvent event) {
        System.out.println("Button clicked");
    }

    private void setImage(String imageFile, Consumer<ImageView> consumeIcon) {
        try {
            try ( InputStream inputStream = PortraitController.class.getResourceAsStream(imageFile)) {
                Image inputImage = new Image(inputStream);
                ImageView imageView = new ImageView(inputImage);
                imageView.setId("icon");
                consumeIcon.accept(imageView);
            }
        } catch (IOException ex) {
            System.out.format("Error closing icon %s stream: %s", imageFile, ex.getMessage());
        }
    }
}
