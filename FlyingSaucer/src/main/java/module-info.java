import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.BulletSPI;
import dk.sdu.cbse.system.SaucerPlugin;
import dk.sdu.cbse.system.SaucerProcessing;

module FlyingSaucer {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IGamePluginService with SaucerPlugin;
    provides IEntityProcessingService with SaucerProcessing;
//    provides ISpaceshipProvider with SpaceshipProviderImpl;
}