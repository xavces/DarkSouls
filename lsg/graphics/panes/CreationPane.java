package lsg.graphics.panes;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

public class CreationPane extends VBox {
    private TextField nameField;
    private GameLabel playerName;

    private static final Duration ANIMATION_DURATION = Duration.millis(1500);

    public TextField getNameField() {
        return nameField;
    }

    public CreationPane() {
        this.nameField = new TextField();
        this.playerName = new GameLabel("Player Name");

        this.setAlignment(Pos.CENTER);
        nameField.setMaxSize(200.0, 40);
        this.getChildren().add(playerName);
        this.getChildren().add(nameField);
    }

    public void fadeIn(javafx.event.EventHandler<javafx.event.ActionEvent> finieshedHandler) {
        FadeTransition ft = new FadeTransition(ANIMATION_DURATION);

        ft.setFromValue(0);
        ft.setToValue(1);

        ft.setCycleCount(1);
        ft.setOnFinished(finieshedHandler);
        ft.setNode(this);
        ft.play();
    }

}
