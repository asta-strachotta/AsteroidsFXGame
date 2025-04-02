package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 * IEntityProcessingService will process any implementing entity-class and make them move
 */

public interface IEntityProcessingService {

    /**
     * @param gameData The context of the game
     * @param world The world holds all entities
     */
    void process(GameData gameData, World world);
}
