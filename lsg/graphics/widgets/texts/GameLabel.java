package lsg.graphics.widgets.texts;

import javafx.scene.control.Label;
import lsg.graphics.CSSFactory;

public class GameLabel extends Label {
    public GameLabel(String text) {
        super(text);
        this.getStylesheets().add(CSSFactory.getStyleSheet("LSGFont.css"));
        this.getStyleClass().addAll("game-font");
        this.getStyleClass().addAll("game-font-fx");

    }

    public GameLabel() {
        super();
        this.getStylesheets().add(CSSFactory.getStyleSheet("LSGFont.css"));
        this.getStyleClass().addAll("game-font");
        this.getStyleClass().addAll("game-font-fx");

    }
}
