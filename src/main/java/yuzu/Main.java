package yuzu;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * GUI for Yuzu using FXML
 */
public class Main extends Application {
    private Yuzu yuzu = new Yuzu("data/yuzu.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Yuzu");
            fxmlLoader.<MainWindow>getController().setYuzu(yuzu);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}