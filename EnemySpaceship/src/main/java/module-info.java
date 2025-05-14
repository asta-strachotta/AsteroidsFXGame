import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.BulletSPI;
import dk.sdu.cbse.system.SpaceshipPlugin;
import dk.sdu.cbse.system.SpaceshipProcessing;

module EnemySpaceship {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IGamePluginService with SpaceshipPlugin;
    provides IEntityProcessingService with SpaceshipProcessing;
//    provides ISpaceshipProvider with SpaceshipProviderImpl;
}