import dk.sdu.cbse.bulletsystem.BulletProcessing;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.BulletSPI;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides IGamePluginService with dk.sdu.cbse.bulletsystem.BulletPlugin;
    provides IEntityProcessingService with dk.sdu.cbse.bulletsystem.BulletProcessing;
    provides BulletSPI with BulletProcessing;
}