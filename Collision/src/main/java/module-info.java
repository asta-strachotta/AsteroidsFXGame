import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.cbse.commonasteroids.IAsteroidSplitter;

module Collision {
    requires Common;
    requires CommonAsteroids;
    uses IAsteroidSplitter;
    provides IPostEntityProcessingService with dk.sdu.cbse.collisionsystem.CollisionControl;
}