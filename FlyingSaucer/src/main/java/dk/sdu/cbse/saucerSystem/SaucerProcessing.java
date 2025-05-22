package dk.sdu.cbse.saucerSystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.commonbullet.BulletSPI;

import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class SaucerProcessing implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        Random random = new Random();
        for (Entity saucer : world.getEntities(FlyingSaucer.class)) {
            if(saucer.getHealth() <= 0){
                world.removeEntity(saucer);
            }

            int randoomInt = random.nextInt(-3,3);
            saucer.setRotation(saucer.getRotation() + randoomInt);
            double changeX = Math.cos(Math.toRadians(saucer.getRotation()));
            double changeY = Math.sin(Math.toRadians(saucer.getRotation()));
            saucer.setX(saucer.getX() + changeX);
            saucer.setY(saucer.getY() + changeY);

            if (saucer.getX() < 0) {
                saucer.setX(gameData.getDisplayWidth());
            }

            if (saucer.getX() > gameData.getDisplayWidth()) {
                saucer.setX(1);
            }

            if (saucer.getY() < 0) {
                saucer.setY(gameData.getDisplayHeight());
            }

            if (saucer.getY() > gameData.getDisplayHeight()) {
                saucer.setY(1);
            }

            if(random.nextDouble(0,1) > 0.95){
                getShooters().stream().findFirst().ifPresent(
                        bulletSPI -> {
                            world.addEntity(bulletSPI.createBullet(saucer, gameData));
                        }
                );
            }

        }
    }

    private List<BulletSPI> getShooters(){
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }


}
