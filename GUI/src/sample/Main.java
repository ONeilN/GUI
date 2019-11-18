package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 1600, 800));
        primaryStage.setMaxWidth(1600);
        primaryStage.setMaxHeight(800);
        primaryStage.setMinWidth(1600);
        primaryStage.setMinHeight(800);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
