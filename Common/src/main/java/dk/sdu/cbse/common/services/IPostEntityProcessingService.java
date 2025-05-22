package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {
    /**
     *
//     * @param gameData The context of the game
     * @param world The world holds all entities
     */
    void process(World world);
}
