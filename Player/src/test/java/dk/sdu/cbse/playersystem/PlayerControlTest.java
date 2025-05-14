package dk.sdu.cbse.playersystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.commonbullet.BulletSPI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControlTest {

    private Entity player;

    private World world;

    private GameData gameData;

    private double oldX;
    private double oldY;
    private double newX;
    private double newY;

    private PlayerControl pc;

    @Mock
    public BulletSPI bulletSPI;


    @Before
    public void setUp() throws Exception {
        world = new World();
        gameData = new GameData();
        player = new Player();

        player.setHealth(10);
        player.setPolygonCoordinates(-5,-5,10,0,-5,5);
        player.setX((double)gameData.getDisplayHeight()/2);
        player.setY((double)gameData.getDisplayWidth()/2);
        player.setRadius(8);
        player.setCollided(false);

        world.addEntity(player);
        pc = new PlayerControl();

    }

    @Test
    public void processMovement() {
        oldX = player.getX();
        oldY = player.getY();

        for(int i = 0; i < 30; i++) {
            gameData.getKeys().setKey(GameKeys.UP, true);
            gameData.getKeys().setKey(GameKeys.RIGHT, true);
            pc.process(gameData, world);
        }

        newX = player.getX();
        newY = player.getY();

        System.out.printf("X are: %f -> %f", oldX, newX);
        System.out.printf("Y are: %f -> %f\n\n", oldY, newY);

        assertNotEquals(String.format("X are equal: %f -> %f ", oldX, newX), oldX, newX);
        assertNotEquals(String.format("Y are equal: %f -> %f ", oldY, newY), oldY, newY);
    }

    @Test
    public void processHealth(){
        for(int i = 0; i < 10; i++) {
            player.minusOneHP();
            pc.process(gameData, world);
        }
        System.out.println("World contains player is " + world.getEntities().contains(player));
        assertFalse("World map should not contain the player",world.getEntities().contains(player));
    }

    @Test
    public void processWrap(){
        player.setX(gameData.getDisplayWidth()-5);

        oldX = player.getX();
        oldY = player.getY();

        for(int i = 0; i < 20; i++) {
            gameData.getKeys().setKey(GameKeys.UP, true);
            pc.process(gameData, world);
        }

        newX = player.getX();
        newY = player.getY();

        System.out.printf("X is: %f -> %f ", oldX, newX);

        assertTrue("\n\nThe player should have wrapped",oldX > newX);
    }

    @Test
    public void processShoot(){
        bulletSPI = mock(BulletSPI.class);
        Entity bullet = new Entity();
        int entitiesBefore = world.getEntities().size();

        when(bulletSPI.createBullet(any(), any())).thenReturn(bullet);

        gameData.getKeys().setKey(GameKeys.SPACE, true);

        PlayerControl playerControl = new PlayerControl() {
          @Override
          List<BulletSPI> getShooters(){
              return List.of(bulletSPI);
          }
        };

        playerControl.process(gameData, world);

        int entitiesAfter = world.getEntities().size();
        verify(bulletSPI, times(1)).createBullet(player, gameData);
        assertTrue(entitiesBefore < entitiesAfter);
    }


    @After
    public void tearDown() throws Exception {
        player = null;
        world = null;
        gameData = null;
    }
}