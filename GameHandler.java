import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * GameHandler handles all of the graphics for the game.
 * There should not be any game logic in this class.
 * 
 * Students should not need to edit this file, though
 * the instructor will need to edit two places for each lab.
 * The instructor will need to update the instance variable gl
 * to be the type of the class that contains the game logic.
 * The instructor will also need to update the line where gl is
 * instantiated in the create() method.
 * 
 * @author Dave Avis
 * @version 12.19.2018
 */
public class GameHandler extends ApplicationAdapter
{
    // EDIT
    //private GameLogic gl;  // Generic // I'm trying to eliminate the need to edit this each lab.
    //private GameOfLife gl;  // Uncomment for the GameOfLife
    private Snake gl;  // Snake

    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private static Board board;  // contains the game board
    private int rows;  // the number of rows the board has. Identical to Constants.rows
    private int cols;  // the number of columns the board has. Identical to Constants.cols
    private float timeSinceLastFrame = 0f;  // use to determine how much time has passed since the last board update.
    private Constants.CellValue[] cellValue;  // holds all of the possible cell values. Copied from Constants.CellValue
    private String[] cellColor;  // holds all of the possible cell colors. Copied from Constants.CellColor

    /**
     * Default constructor. Sets up a 0x0 board.
     */
    public GameHandler()
    {
        board = new Board(0,0);
    }

    /**
     * Sets up a game board with the specified number of rows and columns.
     * 
     * @param boardRows the number of rows on the board.
     * @param boardCols the number of columns on the board.
     */
    public GameHandler( int boardRows, int boardCols )
    {
        board = new Board( boardRows, boardCols );
        rows = boardRows;
        cols = boardCols;
    }

    /**
     * Sets up the camera, the cell values and cell colors arrays, gets
     * things ready to draw, and starts up the class containing the game logic.
     */
    @Override
    public void create()
    {
        // setup the camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, cols, rows);  // false means y-axis is pointing up.
        camera.update();

        // Copy the contents of Constants.CellValue and Constants.CellColor into arrays.
        // This is done to make this class more general so students only have to modify
        // the CellValues and CellColors in the Constants class and not this class as well.
        cellValue = Constants.CellValue.values();
        Constants.CellColor[] cellColorValues = Constants.CellColor.values();
        cellColor = new String[ cellColorValues.length ];
        for( int i = 0; i < cellColorValues.length; i++ )
        {
            cellColor[i] = cellColorValues[i].toString();
        }

        shapeRenderer = new ShapeRenderer();

        InputHandler inputProcessor = new InputHandler();
        Gdx.input.setInputProcessor(inputProcessor);

        // EDIT
        //gl = new GameLogic();  // Generic
        //gl = new GameOfLife(); // Uncomment for the GameOfLife
        gl = new Snake();  // Snake
    }

    /**
     * Updates and draws the board after the specified time has passed.
     * The refresh interval is found in Constants.timeStep.
     */
    @Override
    public void render()
    {
        timeSinceLastFrame += Gdx.graphics.getDeltaTime();
        if( timeSinceLastFrame > Constants.timeStep )
        {
            gl.doUpdates();
            timeSinceLastFrame = 0f;
        }
        draw(); // don't put this in the loop. render() has to draw something each frame or the picture will flicker.
    }

    /**
     * Clean up, clean up, everybody everywhere.
     */
    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }

    /**
     * Checks the value of each cell in the grid, updates it with the proper color,
     * and draws the cell.
     */
    public void draw()
    {
        Color color;

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix( camera.combined );

        for( int row = 0; row < rows; row++ )
        {
            for( int col = 0; col < cols; col++ )
            {
                for( int i = 0; i < cellValue.length; i++ )
                {
                    if( board.getCellValue( row, col ) == cellValue[i] )
                    {
                        switch( cellColor[i] ) {
                        //switch( board.getCellValue( row, col ) ) {
                            case "BLACK": color = Color.BLACK; break;
                            case "BLUE": color = Color.BLUE; break;
                            case "BROWN": color = Color.BROWN; break;
                            case "CHARTREUSE": color = Color.CHARTREUSE; break;
                            case "CLEAR": color = Color.CLEAR; break;
                            case "CORAL": color = Color.CORAL; break;
                            case "CYAN": color = Color.CYAN; break;
                            case "DARK_GRAY": color = Color.DARK_GRAY; break;
                            case "FIREBRICK": color = Color.FIREBRICK; break;
                            case "FOREST": color = Color.FOREST; break;
                            case "GOLD": color = Color.GOLD; break;
                            case "GOLDENROD": color = Color.GOLDENROD; break;
                            case "GRAY": color = Color.GRAY; break;
                            case "GREEN": color = Color.GREEN; break;
                            case "LIGHT_GRAY": color = Color.LIGHT_GRAY; break;
                            case "LIME": color = Color.LIME; break;
                            case "MAGENTA": color = Color.MAGENTA; break;
                            case "MAROON": color = Color.MAROON; break;
                            case "NAVY": color = Color.NAVY; break;
                            case "OLIVE": color = Color.OLIVE; break;
                            case "ORANGE": color = Color.ORANGE; break;
                            case "PINK": color = Color.PINK; break;
                            case "PURPLE": color = Color.PURPLE; break;
                            case "RED": color = Color.RED; break;
                            case "ROYAL": color = Color.ROYAL; break;
                            case "SALMON": color = Color.SALMON; break;
                            case "SCARLET": color = Color.SCARLET; break;
                            case "SKY": color = Color.SKY; break;
                            case "SLATE": color = Color.SLATE; break;
                            case "TAN": color = Color.TAN; break;
                            case "TEAL": color = Color.TEAL; break;
                            case "VIOLET": color = Color.VIOLET; break;
                            case "WHITE": color = Color.WHITE; break;
                            case "YELLOW": color = Color.YELLOW; break;
                            default: color = Color.WHITE; break;
                        }
                        drawBox( color, row, col );
                    }
                }
            }
        }
        camera.update();
    }

    /**
     * This is where the actual drawing of the cell happens.
     * 
     * @param color the color to fill the cell with.
     * @param row the row the cell is in
     * @param col the column the cell is in
     */
    public void drawBox( Color color, int row, int col )
    {
        shapeRenderer.begin( ShapeType.Filled );
        shapeRenderer.setColor( color );
        shapeRenderer.rect( col, row, 1, 1 );  // draw using camera coordinates, width=1 height=1
        shapeRenderer.end();
    }

    /**
     * Get the board object.
     * 
     * @return the current board object
     */
    public static Board getBoard()
    {
        return board;
    }

    /**
     * Detects and returns which key was pressed.
     * 
     * @return a String with which key was pressed.
     */
    public static String whichKeyWasPressed()
    {
        if( InputHandler.key == Input.Keys.UP ) return "UP";
        if( InputHandler.key == Input.Keys.DOWN) return "DOWN";
        if( InputHandler.key == Input.Keys.LEFT) return "LEFT";
        if( InputHandler.key == Input.Keys.RIGHT) return "RIGHT";
        return "";
    }
}