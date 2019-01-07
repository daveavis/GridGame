/**
 * This class contains the bare minimum requirements that any
 * class containing a game's main logic must have.
 * Simply change the class name, fill in the variables with 
 * appropriate values, and make the game logic.
 */
public class GenericGameLogic implements GameHandlerInterface
{
    public enum CellValue {
    }
    
    public enum CellColor {
    }
    
    public static String windowTitle = "Title";
    public static int rows = 30;
    public static int cols = 30;
    public static int windowWidth = 800;
    public static int windowHeight = 800;
    public static float timeStep = 0.1f;
    
    @Override
    public void doUpdates()
    {
    }
}