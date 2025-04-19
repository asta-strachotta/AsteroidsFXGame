import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.BulletSPI;
import dk.sdu.cbse.system.PlayerControl;
import dk.sdu.cbse.system.PlayerPlugin;

module Player {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControl;
}