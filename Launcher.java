import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher
{
    public static void main( String[] args )
    {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        //cfg.title = GameLogic.TITLE;
        //cfg.width = GameLogic.cols * GameLogic.BOX_SIZE;
        //cfg.height = GameLogic.rows * GameLogic.BOX_SIZE;
        cfg.title = "Life";
        cfg.width = 200;
        cfg.height = 200;

        new LwjglApplication(new GameHandler( GameLogic.rows, GameLogic.cols ), cfg);
    }
}