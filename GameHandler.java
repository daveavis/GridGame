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
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private static Board board;
    private int rows;
    private int cols;
    private GameLogic gl;   // I'm trying to eliminate the need to edit this each lab.
    private float timeSinceLastFrame = 0f; 
    private Constants.CellValue[] cellValue;
    //private Constants.CellColor[] cellColorValues;
    private String[] cellColor;
    
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
        
        cellValue = Constants.CellValue.values();
        Constants.CellColor[] cellColorValues = Constants.CellColor.values();
        cellColor = new String[ cellColorValues.length ];
        for( int i = 0; i < cellColorValues.length; i++ )
        {
            cellColor[i] = cellColorValues[i].toString();
        }
        
        //batch = new SpriteBatch();
        //batch.setProjectionMatrix( camera.combined );
        
        shapeRenderer = new ShapeRenderer();
        
        gl = new GameLogic();
    }
    
    @Override
    public void render()
    {
        timeSinceLastFrame += Gdx.graphics.getDeltaTime();
        if( timeSinceLastFrame > Constants.timeStep )
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
        Color color;
        
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        shapeRenderer.setProjectionMatrix( camera.combined );
        
        for( int row = 0; row < rows; row++ )
        {
            for( int col = 0; col < cols; col++ )
            {
                // if( board.getCellValue( row, col ) == Constants.CellValue.EMPTY )
                // {
                    // drawBox( Color.GREEN, row, col );
                // }
                // if( board.getCellValue( row, col ) == Constants.CellValue.FILLED )
                // {
                    // drawBox( Color.RED, row, col );
                // }
                for( int i = 0; i < cellValue.length; i++ )
                {
                    if( board.getCellValue( row, col ) == cellValue[i] )
                    {
                        switch( cellColor[i] ) {
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