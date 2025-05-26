package dk.sdu.cbse.gameloop;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import dk.sdu.cbse.common.services.IScoreService;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class Game {

    private List<IGamePluginService> plugins;
    private List<IEntityProcessingService> processes;
    private List<IPostEntityProcessingService> postProcesses;

    private final Pane gameWindow = new Pane();
    private Text scoreText;

    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();




    @Autowired
    public Game(List<IGamePluginService> plugins, List<IEntityProcessingService> processes,
                List<IPostEntityProcessingService> postProcesses){
        this.plugins = plugins;
        this.processes = processes;
        this.postProcesses = postProcesses;
    }


    public void start(Stage primaryStage){
        ImageView backgroundImage = new ImageView(new Image("space.jpg"));
        backgroundImage.toBack();
        backgroundImage.setFitWidth(gameData.getDisplayWidth());
        backgroundImage.setFitHeight(gameData.getDisplayHeight());

//        text = new Text(10, 20, "Destroyed asteroids: " + gameData.getDestroyedAsteroids());

        String currentScore = "0";
//        String currentScore = "0";
//        System.out.println("SCORE IS CURRENTLY: " + currentScore);



        scoreText = new Text(10, 20, "Score: " + currentScore);

//        System.out.println("SCORE IS CURRENTLY: " + currentScore);

        scoreText.setFill(Color.WHITE);
        scoreText.toFront();

        gameWindow.setPrefSize(gameData.getDisplayWidth(), gameData.getDisplayHeight());
        gameWindow.getChildren().addAll(scoreText, backgroundImage);

        Scene scene = new Scene(gameWindow);
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.A)) {
                gameData.getKeys().setKey(GameKeys.LEFT, true);
            }
            if (event.getCode().equals(KeyCode.D)) {
                gameData.getKeys().setKey(GameKeys.RIGHT, true);
            }
            if (event.getCode().equals(KeyCode.W)) {
                gameData.getKeys().setKey(GameKeys.UP, true);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setKey(GameKeys.SPACE, true);
            }
        });
        scene.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.A)) {
                gameData.getKeys().setKey(GameKeys.LEFT, false);
            }
            if (event.getCode().equals(KeyCode.D)) {
                gameData.getKeys().setKey(GameKeys.RIGHT, false);
            }
            if (event.getCode().equals(KeyCode.W)) {
                gameData.getKeys().setKey(GameKeys.UP, false);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setKey(GameKeys.SPACE, false);
            }

        });

        for (IGamePluginService iGamePlugin : plugins) {
            iGamePlugin.start(gameData, world);
        }
        for (Entity entity : world.getEntities()) {
            Polygon polygon = new Polygon(entity.getPolygonCoordinates());
            polygons.put(entity, polygon);
            gameWindow.getChildren().add(polygon);
        }
        primaryStage.setScene(scene);
        primaryStage.setTitle("ASTEROIDS");
        primaryStage.show();
    }

    public void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
                gameData.getKeys().update();
            }

        }.start();
    }

    private void update() {
        for (IEntityProcessingService entityProcessorService : processes) {
            entityProcessorService.process(gameData, world);
        }
        for (IPostEntityProcessingService postEntityProcessorService : postProcesses) {
            postEntityProcessorService.process(gameData, world);
        }
        ServiceLoader.load(IScoreService.class).stream().findFirst().ifPresent(
                        scoreService -> scoreText.setText("Score: " + scoreService.get().getScore()));
    }

    private void draw() {
        for (Entity polygonEntity : polygons.keySet()) {
            if(!world.getEntities().contains(polygonEntity)){
                Polygon removedPolygon = polygons.get(polygonEntity);
                polygons.remove(polygonEntity);
                gameWindow.getChildren().remove(removedPolygon);
            }
        }

        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            if (polygon == null) {
                polygon = new Polygon(entity.getPolygonCoordinates());
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());
        }

    }
}
