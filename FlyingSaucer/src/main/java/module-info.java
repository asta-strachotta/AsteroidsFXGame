import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.BulletSPI;
import dk.sdu.cbse.saucerSystem.SaucerPlugin;
import dk.sdu.cbse.saucerSystem.SaucerProcessing;

module FlyingSaucer {
    requires Common;
    requires CommonBullet;
    requires java.desktop;
    uses BulletSPI;
    provides IGamePluginService with SaucerPlugin;
    provides IEntityProcessingService with SaucerProcessing;
}