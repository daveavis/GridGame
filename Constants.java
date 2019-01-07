import com.badlogic.gdx.graphics.Color;

/**
 * This class contains constants relating to the setup of the game.
 * Edit the constants as needed.
 * 
 * @author Dave Avis
 * @version 12.18.2018
 */
public class Constants
{
    /**
     * The list of possible values for a cell. You can name them anything you want.
     * Examples: ON, OFF, EMPTY, FULL, GREEN, FOOD, SNAKE, ALIVE, DEAD.
     * Values should be one word in ALL CAPS.
     */
    public enum CellValue {
        //ON,  // Generic
        //OFF  // Generic
        //DEAD,  // GameOfLife
        //ALIVE  // GameOfLife
        BACKGROUND, // Snake
        SNAKE,      // Snake
        FOOD,       // Snake
        DEAD        // Snake
    }
    
    /**
     * These are the colors that are associated with each CellValue.  The colors must
     * be in the same order as the CellValues above. The list of available colors is at the
     * end of this file.
     */
    public enum CellColor {
        //WHITE, // Generic
        //BLACK  // Generic
        //WHITE, // GameOfLife
        //BLACK  // GameOfLife
        BLACK,  // Snake
        FOREST, // Snake
        CYAN,   // Snake
        SCARLET // Snake
    }
    
    // The string that goes in the title bar of the window.
    //public static String windowTitle = "Window Title";
    //public static String windowTitle = "Game of Life"; // GameOfLife
    public static String windowTitle = "Snake";  // Snake
    
    // The dimensions of the grid.
    //public static int rows = 100;  // Generic
    //public static int cols = 100;  // Generic
    //public static int rows = 100;  // GameOfLife
    //public static int cols = 100;  // GameOfLife
    public static int rows = 10;    // Snake
    public static int cols = 10;    // Snake
    
    // The dimensions of the game window in pixels.
    //public static int windowWidth = 400;  // Generic
    //public static int windowHeight = 400; // Generic
    //public static int windowWidth = 400;  // GameOfLife
    //public static int windowHeight = 400; // GameOfLife
    public static int windowWidth = 400;   // Snake
    public static int windowHeight = 400;  // Snake
    
    // The number of seconds between grid updates
    //public static float timeStep = 0.1f;   // Generic
    //public static float timeStep = 0.1f; // GameOfLife
    public static float timeStep = 0.2f;   // Snake
}

/* 
 * This is the list of colors you can use as a CellColor
 * BLACK
 * BLUE
 * BROWN
 * CHARTREUSE
 * CLEAR
 * CORAL
 * CYAN
 * DARK_GRAY
 * FIREBRICK
 * FOREST
 * GOLD
 * GOLDENROD
 * GRAY
 * GREEN
 * LIGHT_GRAY
 * LIME
 * MAGENTA
 * MAROON
 * NAVY
 * OLIVE
 * ORANGE
 * PINK
 * PURPLE
 * RED
 * ROYAL
 * SALMON
 * SCARLET
 * SKY
 * SLATE
 * TAN
 * TEAL
 * VIOLET
 * WHITE
 * YELLOW
 */