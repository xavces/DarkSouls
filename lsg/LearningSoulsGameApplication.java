package lsg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.texts.GameLabel;
import javafx.scene.control.Label;


public class LearningSoulsGameApplication extends Application {

    private Scene scene;
    private AnchorPane root;
    private TitlePane gameTitle;
    private CreationPane creationPane;
    public String heroName;

    @Override
    public void start(Stage stage) throws Exception {
        root = new AnchorPane();
        scene = new Scene(root, 1200, 800);
        stage.setTitle("Learning Souls Game");
        stage.setScene(scene);
        stage.setResizable(false);
        buildUI();
        addListeners();
        stage.show();
        startGame();
    }

    private void buildUI() {
        scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));

        gameTitle = new TitlePane(scene, "Learning Souls Game");
        creationPane = new CreationPane();


        root.setLeftAnchor(gameTitle, 0.0);
        root.setRightAnchor(gameTitle, 0.0);
        root.setTopAnchor(gameTitle, 0.0);
        root.getChildren().add(gameTitle);


        root.setLeftAnchor(creationPane, 0.0);
        root.setRightAnchor(creationPane, 0.0);
        root.setTopAnchor(creationPane, 0.0);
        root.setBottomAnchor(creationPane, 0.0);
        creationPane.setOpacity(0);
        root.getChildren().add(creationPane);
    }

    public void startGame() {
//        gameTitle.zoomIn(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                creationPane.fadeIn(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        gameTitle.zoomOut(new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent event) {
//                                ImageFactory.preloadAll();
//                            }
//                        });
//
//                    }
//
//                });
//
//            }
//        });


        gameTitle.zoomIn((event -> {
            creationPane.fadeIn((event1 -> {
                ImageFactory.preloadAll((() -> {
                    System.out.println("Pré-chargement des images terminé");
                }));
            }));
        }));

        System.out.println("Animation lancée!");

    }

    private void addListeners() {
        creationPane.getNameField().setOnAction((event -> {
            heroName = creationPane.getNameField().getText();
            System.out.println("Nom du héro : " + heroName);
            if (!heroName.isEmpty()) {
                root.getChildren().remove(creationPane);
                gameTitle.zoomOut(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });
            }
        }));
    }
}
