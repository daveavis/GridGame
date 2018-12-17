import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;

public class GameHandler extends ApplicationAdapter
{
    //public int width = 800;
    //public int height = 600;
    
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private static Board board;
    private int rows;
    private int cols;
    private GameLogic gl;
    private float timeStep = 1.0f;  // seconds between updates
    private float timeSinceLastFrame = 0f; 
    
    public GameHandler()
    {
        board = new Board(0,0);
    }
    
    public GameHandler( int boardRows, int boardCols )
    {
        board = new Board( boardRows, boardCols );
        rows = boardRows;
        cols = boardCols;
    }
    
    @Override
    public void create()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, cols, rows);  // false means y-axis is pointing up.
        camera.update();
        
        //batch = new SpriteBatch();
        //batch.setProjectionMatrix( camera.combined );
        
        shapeRenderer = new ShapeRenderer();
        
        gl = new GameLogic();
    }
    
    @Override
    public void render()
    {
        
        
        timeSinceLastFrame += Gdx.graphics.getDeltaTime();
        if( timeSinceLastFrame > timeStep )
        {
            
            gl.doUpdates();
            timeSinceLastFrame = 0f;
        }
        
            draw();

        
    }
    
    @Override
    public void dispose()
    {
        //batch.dispose();
        shapeRenderer.dispose();
    }
    
    public void draw()
    {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        shapeRenderer.setProjectionMatrix( camera.combined );
        
        for( int row = 0; row < rows; row++ )
        {
            for( int col = 0; col < cols; col++ )
            {
                if( board.getCellValue( row, col ) == Cell.CellValue.EMPTY )
                {
                    drawBox( Color.GREEN, row, col );
                }
                if( board.getCellValue( row, col ) == Cell.CellValue.FILLED )
                {
                    drawBox( Color.RED, row, col );
                }
            }
        }
        camera.update();
    }
    
    public void drawBox( Color color, int row, int col )
    {
        shapeRenderer.begin( ShapeType.Filled );
        shapeRenderer.setColor( color );
        shapeRenderer.rect( col, row, 1, 1 );  // draw using camera coordinates, width=1 height=1
        shapeRenderer.end();
    }
    
    public static Board getBoard()
    {
        return board;
    }
}