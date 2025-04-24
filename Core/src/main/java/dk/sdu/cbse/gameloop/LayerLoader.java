package dk.sdu.cbse.gameloop;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class LayerLoader {
    public static ModuleLayer createLayer(String path, String module){
        Path pluginDir = Paths.get(path).normalize().toAbsolutePath();

        ModuleFinder finder = ModuleFinder.of(pluginDir);
        ModuleLayer parent = ModuleLayer.boot();

        Configuration configuration = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of(module));

        return parent.defineModulesWithOneLoader(configuration, ClassLoader.getSystemClassLoader());
    }
}
