import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.BulletSPI;
import dk.sdu.cbse.saucersystem.SaucerPlugin;
import dk.sdu.cbse.saucersystem.SaucerProcessing;

module FlyingSaucer {
    requires Common;
    requires CommonBullet;
    requires java.desktop;
    uses BulletSPI;
    uses dk.sdu.cbse.common.services.IScoreService;
    provides IGamePluginService with SaucerPlugin;
    provides IEntityProcessingService with SaucerProcessing;
}