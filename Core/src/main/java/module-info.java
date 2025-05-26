import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.cbse.common.services.IScoreService;

module Core {
    requires Common;
    requires javafx.graphics;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    requires spring.web;
//    requires spring.boot;
//    requires micrometer.observation;

    opens dk.sdu.cbse.gameloop to javafx.graphics, spring.context, spring.core, spring.web;

    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
    uses IScoreService;

    exports dk.sdu.cbse.gameloop to spring.beans;

}