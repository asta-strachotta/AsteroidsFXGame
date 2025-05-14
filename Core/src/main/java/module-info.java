import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Core {
    requires Common;
    requires javafx.graphics;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    requires spring.web;
    requires spring.boot;

    opens dk.sdu.cbse.gameloop to javafx.graphics, spring.context, spring.core;

    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;

    exports dk.sdu.cbse.gameloop to spring.beans;

}