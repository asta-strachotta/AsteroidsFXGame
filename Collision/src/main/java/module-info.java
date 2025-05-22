import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonAsteroids;
    provides IPostEntityProcessingService with dk.sdu.cbse.collisionsystem.CollisionControl;
}