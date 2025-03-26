import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;

module Asteroids {
    requires Common;
    requires CommonAsteroids;
    provides IGamePluginService with dk.sdu.cbse.asteroidssystem.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.cbse.asteroidssystem.AsteroidProcessing;
}