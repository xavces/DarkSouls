package lsg.graphics.panes;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;



public class CreationPane extends VBox {

    private static final Duration ANIMATION_DURATION = Duration.millis(1500);


    private TextField nameField;
    private GameLabel playerName;

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
