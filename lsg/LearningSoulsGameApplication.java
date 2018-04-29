package lsg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.pane.TitlePane;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.widgets.texts.GameLabel;

public class LearningSoulsGameApplication extends Application {
    private Scene scene;
    private AnchorPane root;
    private TitlePane gameTitle;
    private CreationPane creationPane;
    private String heroName;
    private AnimationPane animationPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Learning Souls Game");
        this.root = new AnchorPane();
        this.scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        this.buildUI();
        this.addListeners();
        primaryStage.show();
        startGame();
    }

    private void buildUI(){
        this.scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
        //this.root.getChildren().addAll(new GameLabel("Learning Soul Game"));
        gameTitle = new TitlePane(scene, "Learning Souls Game");
        creationPane = new CreationPane();

        this.root.setLeftAnchor(gameTitle, 350.0);
        this.root.setRightAnchor(gameTitle, 0.0);
        this.root.setTopAnchor(gameTitle, 10.0);
        this.root.getChildren().add(gameTitle);

        creationPane.setOpacity(0.0);
        root.setLeftAnchor(creationPane, 0.0);
        root.setRightAnchor(creationPane, 0.0);
        root.setTopAnchor(creationPane, 0.0);
        root.setBottomAnchor(creationPane, 0.0);
        root.getChildren().add(creationPane);

        animationPane = new AnimationPane(root);
    }

    /**
     * Lance les animations de départ
     */
    private void startGame(){
        gameTitle.zoomIn((event -> {
            System.out.println("ZOOM terminé");
            creationPane.fadeIn((eventBis -> {
                System.out.println("FADE terminé !");
                ImageFactory.preloadAll((() -> {
                    System.out.println("Pré-chargement des images terminé !");
                }));
            }));
        }));
    }

    /**
     * Ecouteur qui attend une action
     */
    private void addListeners(){
        creationPane.getNameField().setOnAction((event -> {
            heroName = creationPane.getNameField().getText();
            System.out.println("Nom du héros : " + heroName);
            if (!heroName.isEmpty()) {
                root.getChildren().remove(creationPane);
                gameTitle.zoomOut((eventBis -> {
                    System.out.println("DEZOOM terminé !");
                    play();
                }));
            }
        }));
    }

    private void play() {
        root.getChildren().add(animationPane);
        animationPane.startDemo();
    }
}
