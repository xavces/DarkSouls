package lsg.graphics.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import lsg.graphics.widgets.texts.GameLabel;

public class MessagePane extends VBox {

    public MessagePane() {
    }

    public void showMessage(String msg){
        GameLabel message = new GameLabel(msg);
        message.setMinHeight(Region.USE_PREF_SIZE);
        message.setMinWidth(Region.USE_PREF_SIZE);
        this.getChildren().add(message);
    }
}
