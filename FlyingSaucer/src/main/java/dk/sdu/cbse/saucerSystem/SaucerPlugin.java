package dk.sdu.cbse.saucerSystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class SaucerPlugin implements IGamePluginService {
    private Entity saucer;

    public SaucerPlugin(){}

    @Override
    public void start(GameData gameData, World world) {
        saucer = createSaucer(gameData);
        world.addEntity(saucer);
    }

    @Override
    public void stop(World world) {
        world.removeEntity(saucer);
    }

    private Entity createSaucer(GameData gameData){
        Entity saucer = new FlyingSaucer();
        saucer.setHealth(10);
        saucer.setImagePath("enemyShip.png");
        saucer.setPolygonCoordinates(-5,-5,10,0,-5,5);
        saucer.setX((double) gameData.getDisplayHeight()/4);
        saucer.setY((double) gameData.getDisplayWidth()/4);
        saucer.setRadius(8);
        saucer.setCollided(false);
        return saucer;
    }
}
