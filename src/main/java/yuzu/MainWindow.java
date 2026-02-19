package yuzu;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *  MainWindow controller
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    private Yuzu yuzu;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/chat1.png"));
    private Image yuzuImage = new Image(this.getClass().getResourceAsStream("/images/chat2.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setYuzu(Yuzu yuzu) {
        this.yuzu = yuzu;
    }

    /**
     * two dialog boxes
     * clear user input after process
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = yuzu.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getYuzuDialog(response, yuzuImage)
        );
        userInput.clear();
    }
}