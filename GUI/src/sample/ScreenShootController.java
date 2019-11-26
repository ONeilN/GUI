package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ScreenShootController {

    @FXML
    ImageView imageView = new ImageView();

    @FXML
    public void initialize() {
        imageView.setImage(Controller.getScreenShoots().get(0));
    }
}
