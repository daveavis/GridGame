import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * This class is used to launch our grid based game.
 * 
 * Students should not need to edit this file.
 * 
 * @author Dave Avis
 * @version 12.19.2018
 */
public class Launcher
{
    public static void main( String[] args )
    {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();

        cfg.title = Constants.windowTitle;
        cfg.width = Constants.windowWidth;
        cfg.height = Constants.windowHeight;

        new LwjglApplication(new GameHandler( Constants.rows, Constants.cols ), cfg);
    }
}