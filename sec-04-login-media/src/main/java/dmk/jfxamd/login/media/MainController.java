package dmk.jfxamd.login.media;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainController {

    @FXML
    private MediaView mediaView;
    
    public void initialize() {
        System.out.println("Init controller");
        try {
            URL resource = MainController.class.getResource("2017_04_30_One_day.mp4");
            System.out.println(resource);
            Media media = new Media(resource.toString());
            MediaPlayer player = new MediaPlayer(media);
            player.setVolume(0);
            player.setAutoPlay(true);
            mediaView.setMediaPlayer(player);
            player.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
