package sample;

import Helpers.FileChooserHelper;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private MediaView mediaView = new MediaView();
    private MediaPlayer mp = null;
    private FileChooserHelper fileChooserHelper = new FileChooserHelper("Select Video", "user.dir");
    private static ArrayList<WritableImage> screenShoots = new ArrayList<>();
    private int startIndex = 0;

    public static ArrayList<WritableImage> getScreenShoots() {
        return screenShoots;
    }

    /**
     *  ImageView вкладки "Главная"
     */
    @FXML
    ImageView imageViewTop;
    @FXML
    ImageView imageViewCenter;
    @FXML
    ImageView imageViewBottom;

    /**
     * ImageView вкладки "Галерея"
     */
    @FXML
    ImageView imageView0;
    @FXML
    ImageView imageView1;
    @FXML
    ImageView imageView2;
    @FXML
    ImageView imageView3;
    @FXML
    ImageView imageView4;
    @FXML
    ImageView imageView5;
    @FXML
    ImageView imageView6;
    @FXML
    ImageView imageView7;
    @FXML
    ImageView imageView8;

    /**
     * Событие для открытия видео
     *
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

        screenShoots.add(null);
        screenShoots.add(null);
        screenShoots.add(null);
        screenShoots.add(null);
        screenShoots.add(null);
        screenShoots.add(null);
        screenShoots.add(null);
        screenShoots.add(null);
        screenShoots.add(null);
    }

    /**
     * Событие для запуска видео
     *
     * @param event
     */
    @FXML
    private void start(ActionEvent event) {
        mp.play();
        mp.setMute(true);
    }

    /**
     * Событие для паузы видео
     *
     * @param event
     */
    @FXML
    private void pause(ActionEvent event) {
        mp.pause();
    }

    /**
     * Событие для остановки видео
     *
     * @param event
     */
    @FXML
    private void stop(ActionEvent event) {
        mp.stop();
    }

    @FXML
    private void snapshot(ActionEvent event) {
        WritableImage image = mediaView.snapshot(null, null);
        screenShoots.add(image);

        imageViewTop.setImage(screenShoots.get(screenShoots.size() - 3));
        imageViewCenter.setImage(screenShoots.get(screenShoots.size() - 2));
        imageViewBottom.setImage(screenShoots.get(screenShoots.size() - 1));

        imageView0.setImage(screenShoots.get(startIndex));
        imageView0.setImage(screenShoots.get(startIndex + 1));
        imageView0.setImage(screenShoots.get(startIndex + 2));
        imageView0.setImage(screenShoots.get(startIndex + 3));
        imageView0.setImage(screenShoots.get(startIndex + 4));
        imageView0.setImage(screenShoots.get(startIndex + 5));
        imageView0.setImage(screenShoots.get(startIndex + 6));
        imageView0.setImage(screenShoots.get(startIndex + 7));
        imageView0.setImage(screenShoots.get(startIndex + 8));

        double time = mp.getCurrentTime().toSeconds();
        File file = new File(".\\GUI\\Screenshoots\\" + time + ".png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
    }

    @FXML
    private void openScreenShoot(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScreenShootScene.fxml"));
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setScene(new Scene(root, 1600, 800));

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        newWindow.show();
    }
}
