package dk.sdu.cbse.collisionsystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

public class CollisionControl implements IPostEntityProcessingService {

    public CollisionControl(){}

    @Override
    public void process(World world) {
        for(Entity e : world.getEntities()){
            for(Entity a : world.getEntities()){
                if (e.getID().equals(a.getID()) || e.getClass().equals(a.getClass())) {
                    continue;
                }
                if(collision(e,a)) {
                    e.setCollided(true);
                    a.setCollided(true);
                    e.minusOneHP();
                    a.minusOneHP();
                }
            }
        }
    }

    private boolean collision(Entity e, Entity a){
        float dx = (float) e.getX() - (float) a.getX();
        float dy = (float) e.getY() - (float) a.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (e.getRadius() + a.getRadius());

    }

}
