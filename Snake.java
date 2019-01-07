import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * An implementation of the classic game Snake using my grid based
 * game library based on LibGDX and targeted at my high school students.
 *
 * @author Dave Avis
 * @version 12.22.2018
 */
public class Snake implements GameHandlerInterface
{
    // Required Constants and Variables
    public static final String WINDOW_TITLE = "Snake";
    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;
    public static float timeStep = 0.2f;
    
    // Game Specific Constants and Variables
    private Board board;
    
    //private int rows = Constants.rows;
    //private int cols = Constants.cols;
    private int headRow;
    private int headCol;
    private int tailRow;
    private int tailCol;
    private int foodRow;
    private int foodCol;
    private boolean ate; // did the snake just eat the food?
    private char direction; // UDLR
    private ArrayList<BodyPart> snake = new ArrayList<BodyPart>();
    private boolean gameOver = false;
    private Food food;
    
    /**
     * Constructor
     * Sets up a clear board, a hidden food object, and the head of the snake.
     */
    public Snake()
    {
        board = GameHandler.getBoard(); // Required
        clearBoard();
        food = new Food( ThreadLocalRandom.current().nextInt(0, ROWS-1), ThreadLocalRandom.current().nextInt(0, COLS-1), false ); // new food in random location and hidden
        
        headRow = ThreadLocalRandom.current().nextInt(3, ROWS-2);  // don't start at the edge
        headCol = ThreadLocalRandom.current().nextInt(3, COLS-2);
        tailRow = headRow;
        tailCol = headCol;
        snake.add( new BodyPart( headRow, headCol ) );
        direction = 'R';
        ate = false;
    }
    
    /**
     * Clears the board. Sets every location to BACKGROUND.
     */
    public void clearBoard()
    {
        for( int row = 0; row < ROWS; row++ )
        {
            for( int col = 0; col < COLS; col++ )
            {
                board.setCellValue( row, col, Constants.CellValue.BACKGROUND );
            }
        }
    }
    
    /**
     * Updates each location of the board.
     * First clears the board, then goes through the snake BodyParts and sets those values,
     * then draws the food if it is visible.
     */
    public void updateBoard()
    {
        clearBoard();
        for( BodyPart part : snake )
        {
            if( gameOver )
            {
                board.setCellValue( part.getRow(), part.getCol(), Constants.CellValue.DEAD );
            } else {
                board.setCellValue( part.getRow(), part.getCol(), Constants.CellValue.SNAKE );
            }
        }
        if( food.isShowing )
        {
            board.setCellValue( food.getRow(), food.getCol(), Constants.CellValue.FOOD );
        }
    }
        
    /**
     * Handles arrow key input. Does not allow the snake to reverse direction, which would be fatal.
     */
    public void handleInput()
    {
        switch( GameHandler.whichKeyWasPressed() ) {
            case "UP": 
                if( direction != 'D' ) direction = 'U'; break;
            case "DOWN": 
                if( direction != 'U' ) direction = 'D'; break;
            case "LEFT": 
                if( direction != 'R' ) direction = 'L'; break;
            case "RIGHT": 
                if( direction != 'L' ) direction = 'R'; break;
            default: break;
        }
    }
    
    /**
     * Move the snake. Also checks if the tail needs to grow or not.
     */
    public void moveSnake()
    {
        // move the head
        int prevHeadRow = snake.get(0).getRow();
        int prevHeadCol = snake.get(0).getCol();
        tailRow = snake.get( snake.size() - 1 ).getRow();
        tailCol = snake.get( snake.size() - 1 ).getCol();
        switch( direction ) {
            case 'U': snake.get(0).setRow( snake.get(0).getRow() + 1 ); break;
            case 'D': snake.get(0).setRow( snake.get(0).getRow() - 1 ); break;
            case 'R': snake.get(0).setCol( snake.get(0).getCol() + 1 ); break;
            case 'L': snake.get(0).setCol( snake.get(0).getCol() - 1 ); break;
            default: break;
        }
        
        // check for collision with walls, body, and food
        checkWallCollision();
        if( snake.size() > 2 ) checkBodyCollision();
        checkFoodCollision();
        
        // move the tail (if necessary)
        for( int i = snake.size() - 1; i > 1; i-- )
        {
            snake.get(i).setRow( snake.get(i-1).getRow() );
            snake.get(i).setCol( snake.get(i-1).getCol() );
        }
        if( snake.size() > 1 )
        {
            snake.get(1).setRow( prevHeadRow );
            snake.get(1).setCol( prevHeadCol );
        }
        if( ate )
        {
            snake.add( new BodyPart( tailRow, tailCol ) );
            ate = false;
        }
    }
    
    /**
     * Check if the snake collided with a visible food object.
     * If it does, then creates a new hidden food object.
     */
    public void checkFoodCollision()
    {
        if( snake.get(0).getRow() == food.getRow() && snake.get(0).getCol() == food.getCol() )
        {
            ate = true;
            food.isShowing = false;
            int newRow = ThreadLocalRandom.current().nextInt(0, ROWS-1);
            int newCol = ThreadLocalRandom.current().nextInt(0, COLS-1);
            while( board.getCellValue( newRow, newCol ) != Constants.CellValue.BACKGROUND )
            {
                newRow = ThreadLocalRandom.current().nextInt(0, ROWS-1);
                newCol = ThreadLocalRandom.current().nextInt(0, COLS-1);
            }
            food.setRow( newRow );
            food.setCol( newCol );
        }
    }
    
    /**
     * Check for collisions with walls
     */
    public void checkWallCollision()
    {
        if( snake.get(0).getRow() < 0 ) 
        {
            gameOver = true;
            snake.get(0).setRow( snake.get(0).getRow() + 1 );
        }
        if( snake.get(0).getRow() > ROWS - 1 )
        {
            gameOver = true;
            snake.get(0).setRow( snake.get(0).getRow() - 1 );
        }
        if( snake.get(0).getCol() < 0 )
        {
            gameOver = true;
            snake.get(0).setCol( snake.get(0).getCol() + 1 );
        }
        if( snake.get(0).getCol() > COLS - 1 )
        {
            gameOver = true;
            snake.get(0).setCol( snake.get(0).getCol() - 1 );
        }
    }
    
    /**
     * Check for collisions with other parts of the snake.
     */
    public void checkBodyCollision()
    {
        for( int i = 1; i < snake.size(); i++ )
        {
            if( snake.get(0).getRow() == snake.get(i).getRow() && snake.get(0).getCol() == snake.get(i).getCol() )
            {
                gameOver = true;
            }
        }
    }
    
    /**
     * Required method. Called every timeStep.
     * Handles keyboard input, Shows food semi-randomly, moves the snake, and updates the board.
     */
    @Override
    public void doUpdates()
    {
        handleInput();
        if( ! gameOver )
        {
            // generate new food if needed
            if( ! food.isShowing && Math.random() < 0.2 )
            {
                food.isShowing = true;
            }
            moveSnake();
        }
        updateBoard();
    }
    
    /**
     * Launches the application.
     * 
     * @param args not used.
     */
    public static void main( String[] args )
    {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();

        //cfg.title = Constants.windowTitle;
        //cfg.width = Constants.windowWidth;
        //cfg.height = Constants.windowHeight;
        
        cfg.title = WINDOW_TITLE;
        cfg.width = WINDOW_WIDTH;
        cfg.height = WINDOW_HEIGHT;

        //new LwjglApplication(new GameHandler( Constants.ROWS, Constants.COLS ), cfg);
        new LwjglApplication(new GameHandler( ROWS, COLS ), cfg);
    }
}
