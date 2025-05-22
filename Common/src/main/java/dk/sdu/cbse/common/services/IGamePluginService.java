package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * IGamePluginService allows an entity to be created, added to the world and removed from the world
 */

public interface IGamePluginService {
    /**
     * Spawns an entity in the world
     * @param gameData The context of the game
     * @param world The world holds all entities
     */
    void start(GameData gameData, World world);

    /**
     * Removes an entity from the world
//     * @param gameData The context of the game
     * @param world The world holds all entities
     */
    void stop(World world);
}
