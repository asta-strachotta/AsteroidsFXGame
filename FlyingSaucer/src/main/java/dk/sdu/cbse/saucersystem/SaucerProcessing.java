package dk.sdu.cbse.saucersystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IScoreService;
import dk.sdu.cbse.commonbullet.BulletSPI;

import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class SaucerProcessing implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        Random random = new Random();
        for (Entity spaceship : world.getEntities(FlyingSaucer.class)) {
            if(spaceship.getHealth() <= 0){
                for(IScoreService scoreService : getScoreServices()){
                    scoreService.putScore(1);
                }
                world.removeEntity(spaceship);
            }

            int randoomInt = random.nextInt(-3,3);
            spaceship.setRotation(spaceship.getRotation() + randoomInt);
            double changeX = Math.cos(Math.toRadians(spaceship.getRotation()));
            double changeY = Math.sin(Math.toRadians(spaceship.getRotation()));
            spaceship.setX(spaceship.getX() + changeX);
            spaceship.setY(spaceship.getY() + changeY);

            if (spaceship.getX() < 0) {
                spaceship.setX(gameData.getDisplayWidth());
            }

            if (spaceship.getX() > gameData.getDisplayWidth()) {
                spaceship.setX(1);
            }

            if (spaceship.getY() < 0) {
                spaceship.setY(gameData.getDisplayHeight());
            }

            if (spaceship.getY() > gameData.getDisplayHeight()) {
                spaceship.setY(1);
            }

            if(random.nextDouble(0,1) > 0.95){
                getShooters().stream().findFirst().ifPresent(
                        bulletSPI -> {
                            world.addEntity(bulletSPI.createBullet(spaceship, gameData));
                        }
                );
            }

        }
    }

    private List<BulletSPI> getShooters(){
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }

     private List<IScoreService> getScoreServices(){
        return ServiceLoader.load(IScoreService.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }

}
