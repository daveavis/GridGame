import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
//import grid.Constants;

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