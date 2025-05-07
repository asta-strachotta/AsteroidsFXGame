package dk.sdu.cbse.asteroidssystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonasteroids.Asteroid;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {
        for(int i = 0; i < 10; i++) {
            asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData){
        asteroid = new Asteroid();
        Random random = new Random();
        int size = random.nextInt(10)+5;
        asteroid.setX(random.nextInt(gameData.getDisplayWidth()));
        asteroid.setY(random.nextInt(gameData.getDisplayHeight()));
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        asteroid.setRadius(size);
        asteroid.setRotation(random.nextInt(90));
        return asteroid;
    }
}
