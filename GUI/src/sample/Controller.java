package sample;

import Helpers.FileChooserHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Controller {

    @FXML
    MediaView mediaView = new MediaView();
    MediaPlayer mp = null;
    FileChooserHelper fileChooserHelper = new FileChooserHelper("Select Video", "user.dir");

    /**
     * Событие для открытия видео
     * @param event
     */
    @FXML
    private void open(ActionEvent event) {

        try {
            File videoFile = fileChooserHelper.getFileChooser().showOpenDialog(new Stage());
            mp = new MediaPlayer(new Media(videoFile.toURI().toURL().toExternalForm()));
        } catch (MalformedURLException e) {
            /**
             * Реализовать
             */
            e.printStackTrace();
        }

        mediaView.setMediaPlayer(mp);
    }

    /**
     * Событие для запуска видео
     * @param event
     */
    @FXML
    private void start(ActionEvent event) {
        mp.play();
    }

    /**
     * Событие для паузы видео
     * @param event
     */
    @FXML
    private void pause(ActionEvent event) {
        mp.pause();
    }

    /**
     * Событие для остановки видео
     * @param event
     */
    @FXML
    private void stop(ActionEvent event) {
        mp.stop();
    }
}
