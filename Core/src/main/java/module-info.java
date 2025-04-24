import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.cbse.common.services.ISpaceshipProvider;

module Core {
    requires Common;
    requires javafx.graphics;
    opens dk.sdu.cbse.gameloop to javafx.graphics;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
    uses ISpaceshipProvider;
}