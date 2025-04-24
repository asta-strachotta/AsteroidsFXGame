package dk.sdu.cbse.system;

import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.ISpaceshipProvider;

public class SpaceshipProviderImpl implements ISpaceshipProvider {
    @Override
    public IEntityProcessingService getProcess(){
        return new SpaceshipProcessing();
    }

    @Override
    public IGamePluginService getPlugin(){
        return new SpaceshipPlugin();
    }
}
