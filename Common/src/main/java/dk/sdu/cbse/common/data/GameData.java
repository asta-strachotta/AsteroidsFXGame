package dk.sdu.cbse.common.data;

public class GameData {

    private int displayWidth  = 800 ;
    private int displayHeight = 600;
    private int destroyedAsteroids = 0;

    private final GameKeys keys = new GameKeys();

    public int getDestroyedAsteroids(){
        return destroyedAsteroids;
    }

    public void plusOneAsteroids(){
        destroyedAsteroids++;
    }

    public GameKeys getKeys() {
        return keys;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }


}
