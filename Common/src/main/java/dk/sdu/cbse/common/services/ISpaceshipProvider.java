package dk.sdu.cbse.common.services;

public interface ISpaceshipProvider {
    IGamePluginService getPlugin();
    IEntityProcessingService getProcess();
}
