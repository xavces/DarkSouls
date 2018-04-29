package lsg.graphics.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class HUDPane extends BorderPane {

    private MessagePane messagePane;

    public HUDPane() {
        buildCenter();
    }

    public MessagePane getMessagePane() {
        return messagePane;
    }

    private void buildCenter(){
        messagePane = new MessagePane();
        this.getChildren().add(messagePane);
    }
}
