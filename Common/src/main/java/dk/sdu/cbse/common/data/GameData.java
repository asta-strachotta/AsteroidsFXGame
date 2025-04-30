package dk.sdu.cbse.common.data;

public class GameData {

    private int displayWidth  = 800 ;
    private int displayHeight = 600;
    private final GameKeys keys = new GameKeys();

    private int ticks;

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
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
