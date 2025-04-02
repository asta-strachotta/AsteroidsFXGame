package dk.sdu.cbse.asteroidssystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.commonasteroids.Asteroid;
import dk.sdu.cbse.commonasteroids.IAsteroidSplitter;

public class AsteroidSplitImpl implements IAsteroidSplitter {
    @Override
    public void createSplitAsteroid(Entity e, World w) {
        Entity splitA = new Asteroid();
        Entity splitB = new Asteroid();

        splitA.setX(e.getX()+2);
        splitA.setY(e.getY()+2);

        splitB.setX(e.getX()-2);
        splitB.setY(e.getY()-2);

        float size = e.getRadius() / 2;

        splitA.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        splitA.setRadius(size);
        splitA.setRotation(e.getRotation() - 45);

        splitB.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        splitB.setRadius(size);
        splitB.setRotation(e.getRotation() + 45);

        w.removeEntity(e);
        w.addEntity(splitA);
        w.addEntity(splitB);

    }
}
