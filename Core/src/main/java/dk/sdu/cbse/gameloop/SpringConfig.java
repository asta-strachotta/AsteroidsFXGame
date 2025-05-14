package dk.sdu.cbse.gameloop;

import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@Configuration
public class SpringConfig {

    public SpringConfig(){}

    @Bean
    public Game Game(){
        return new Game(plugins(), processes(), postProcesses());
    }

    @Bean
    public List<IGamePluginService> plugins(){
        return ServiceLoader.load(IGamePluginService.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }

    @Bean
    public List<IEntityProcessingService> processes(){
        return ServiceLoader.load(IEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }

    @Bean
    public List<IPostEntityProcessingService> postProcesses(){
        return ServiceLoader.load(IPostEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
