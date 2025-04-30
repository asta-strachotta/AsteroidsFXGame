package dk.sdu.cbse.playersystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class PlayerPlugin implements IGamePluginService {
    private Entity player;

    public PlayerPlugin(){}

    @Override
    public void start(GameData gameData, World world) {
        player = createPlayer(gameData);
        world.addEntity(player);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(player);
    }

    private Entity createPlayer(GameData gameData){
        Entity player = new Player();
        player.setLives(10);
        player.setPolygonCoordinates(-5,-5,10,0,-5,5);
        player.setX((double)gameData.getDisplayHeight()/2);
        player.setY((double)gameData.getDisplayWidth()/2);
        player.setRadius(8);
        player.setCollided(false);
        return player;
    }
}
