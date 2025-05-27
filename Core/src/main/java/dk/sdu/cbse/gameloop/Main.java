package dk.sdu.cbse.gameloop;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //the context looks at classes annotated with @Configuration and loads them(?)
        context.register(SpringConfig.class);
        //^^ register my configuration that returns the beans
        context.refresh();

        Game game = context.getBean(Game.class);

        game.setOnPlayerDeath(()-> {
            Platform.exit();
        });

        game.start(window);
        game.render();
    }
}
