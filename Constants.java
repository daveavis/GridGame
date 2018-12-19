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
    // The list of possible values for a cell. You can name them anything you want.
    // Examples: ON, OFF, EMPTY, FULL, GREEN, FOOD, SNAKE
    public enum CellValue {
        DEAD,
        ALIVE
    }
    
    // These are the colors that are associated with each CellValue.  The colors must
    // be in the same order as the CellValues. See the list of available colors at the
    // end of this file.
    public enum CellColor {
        WHITE,
        BLACK
    }
    
    // The string that goes in the title bar of the window.
    public static String windowTitle = "Game of Life";
    
    // the dimensions of the grid.
    public static int rows = 100;
    public static int cols = 100;
    
    // the dimensions of the game window in pixels.
    public static int windowWidth = 400;
    public static int windowHeight = 400;
    
    // the number of seconds between grid updates
    public static float timeStep = 0.25f;
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