import dk.sdu.cbse.asteroidssystem.AsteroidSplitImpl;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IScoreService;
import dk.sdu.cbse.commonasteroids.IAsteroidSplitter;

module Asteroids {
    requires Common;
    requires CommonAsteroids;
    uses IAsteroidSplitter;
    uses IScoreService;
    provides IAsteroidSplitter with AsteroidSplitImpl;
    provides IGamePluginService with dk.sdu.cbse.asteroidssystem.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.cbse.asteroidssystem.AsteroidProcessing;
}