package dk.sdu.cbse.enemysystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class SpaceshipPlugin implements IGamePluginService {
    private Entity spaceship;

    public SpaceshipPlugin(){}

    @Override
    public void start(GameData gameData, World world) {
        spaceship = createSpaceship(gameData);
        world.addEntity(spaceship);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(spaceship);
    }

    private Entity createSpaceship(GameData gameData){
        Entity spaceship = new Spaceship();
        spaceship.setPolygonCoordinates(-5,-5,10,0,-5,5);
        spaceship.setX((double) gameData.getDisplayHeight()/4);
        spaceship.setY((double) gameData.getDisplayWidth()/4);
        spaceship.setRadius(8);
        spaceship.setCollided(false);
        return spaceship;
    }
}
