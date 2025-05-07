import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.BulletSPI;
import dk.sdu.cbse.enemysystem.SpaceshipPlugin;
import dk.sdu.cbse.enemysystem.SpaceshipProcessing;

module EnemySpaceship {
    requires Common;
    requires CommonBullet;
    requires java.desktop;
    uses BulletSPI;
    provides IGamePluginService with SpaceshipPlugin;
    provides IEntityProcessingService with SpaceshipProcessing;
}