package lsg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.characters.Hero;
import lsg.characters.Monster;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.pane.TitlePane;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.HUDPane;
import lsg.graphics.widgets.characters.renderers.HeroRenderer;
import lsg.graphics.widgets.characters.renderers.ZombieRenderer;
import lsg.graphics.widgets.texts.GameLabel;
import lsg.weapons.Sword;

public class LearningSoulsGameApplication extends Application {
    private Scene scene;
    private AnchorPane root;
    private TitlePane gameTitle;
    private CreationPane creationPane;
    private String heroName;
    private AnimationPane animationPane;

    private Hero hero;
    private HeroRenderer heroRenderer;
    private Monster zombie;
    private ZombieRenderer zombieRenderer;

    private HUDPane hudPane;

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

    public void createHero(){
        hero = new Hero(heroName);
        hero.setWeapon(new Sword());
        heroRenderer = animationPane.createHeroRenderer();
        heroRenderer.goTo(animationPane.getPrefWidth()*0.5 - heroRenderer.getFitWidth()*0.65, null);
    }

    public void createMonster(EventHandler<ActionEvent> finishedHandler){
        zombie = new Monster();
        zombie.setWeapon(new Sword());
        zombieRenderer  = animationPane.createZombieRenderer();
        zombieRenderer.goTo(animationPane.getPrefWidth()*0.5 - zombieRenderer.getBoundsInLocal().getWidth() * 0.15, finishedHandler);
    }

    private void buildUI(){
        this.scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
        //this.root.getChildren().addAll(new GameLabel("Learning Soul Game"));
        gameTitle = new TitlePane(scene, "Learning Souls Game");
        creationPane = new CreationPane();
        hudPane = new HUDPane();

        this.root.setLeftAnchor(gameTitle, 350.0);
        this.root.setRightAnchor(gameTitle, 0.0);
        this.root.setTopAnchor(gameTitle, 10.0);
        this.root.getChildren().add(gameTitle);

        creationPane.setOpacity(0.0);
        this.root.setLeftAnchor(creationPane, 0.0);
        this.root.setRightAnchor(creationPane, 0.0);
        this.root.setTopAnchor(creationPane, 0.0);
        this.root.setBottomAnchor(creationPane, 0.0);
        this.root.getChildren().add(creationPane);

        animationPane = new AnimationPane(root);

        this.root.setLeftAnchor(hudPane, 0.0);
        this.root.setRightAnchor(hudPane, 0.0);
        this.root.setTopAnchor(hudPane, 0.0);
        this.root.setBottomAnchor(hudPane, 0.0);
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
        root.getChildren().add(hudPane);
        //animationPane.startDemo();
        createHero();
        createMonster((event -> {
            hudPane.getMessagePane().showMessage("¨Fight !");
        }));
    }
}
