package dk.sdu.cbse.asteroidssystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IScoreService;
import dk.sdu.cbse.commonasteroids.Asteroid;
import dk.sdu.cbse.commonasteroids.IAsteroidSplitter;

import java.util.ServiceLoader;

public class AsteroidProcessing implements IEntityProcessingService {

    private IAsteroidSplitter splitter = new AsteroidSplitImpl();

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            if(asteroid.isCollided()){
                if(asteroid.getRadius() > 7) {
                    splitter.createSplitAsteroid(asteroid, world);
                }else {
                    getScoreService().putScore(1);
                    world.removeEntity(asteroid);
                }
            }

            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);

            if (asteroid.getX() < 0) {
                asteroid.setX(gameData.getDisplayWidth());
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(1);
            }

            if (asteroid.getY() < 0) {
                asteroid.setY(gameData.getDisplayHeight());
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(1);
            }
        }
    }

    public IScoreService getScoreService(){
        return ServiceLoader.load(IScoreService.class).stream().map(ServiceLoader.Provider::get).findFirst().get();
    }
}
