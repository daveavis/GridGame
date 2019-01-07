/**
 * The list of possible values for a cell. You can name them anything you want.
 * Examples: ON, OFF, EMPTY, FULL, GREEN, FOOD, SNAKE, ALIVE, DEAD.
 * Values should be one word in ALL CAPS.
 * 
 * @author Dave Avis
 * @version 12.20.2018
 */
public enum CellValue {
    //ON,  // Generic
    //OFF  // Generic
    //ALIVE,  // GameOfLife
    //DEAD   // GameOfLife
    BACKGROUND, // Snake
    SNAKE,      // Snake
    FOOD,       // Snake
    DEAD        // Snake
}