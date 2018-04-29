package lsg.graphics.panes;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CreationPane extends VBox {

    private TextField nameField;

    public TextField getNameField() {
        return nameField;
    }

    public CreationPane() {
        this.nameField = new TextField();
        this.getChildren().add(nameField);
    }
}
