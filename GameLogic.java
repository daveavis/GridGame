import com.badlogic.gdx.Gdx;

public class GameLogic
{
    public static final String TITLE = "Life"; // window title text
    public static final int BOX_SIZE = 10; // pixel height and width for a box

    private boolean[][] alive;
    private int[][] liveNeighbors;
    public static int rows = 20;
    public static int cols = 20;
    private double initialPct = 0.2; // 20% of cells are alive to start
    private Board board;

    public GameLogic()
    {
        board = GameHandler.getBoard();
        populate();
    }
    
    private void populate() 
    {
        alive = new boolean[rows][cols];
        liveNeighbors = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if( Math.random() < initialPct )
                {
                    board.setCellValue( row, col, Cell.CellValue.FILLED );
                }
            }
        }
    }

    private void countNeighbors() 
    {
        int rowUp;
        int rowDown;
        int colLeft;
        int colRight;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int neighbors = 0;

                rowUp = (row - 1);
                if (rowUp < 0) rowUp += rows;

                rowDown = (row + 1) % (rows - 1);

                colLeft = col - 1;
                if (colLeft < 0) colLeft += cols;

                colRight = (col + 1) % (cols - 1);

                if( board.getCellValue( rowUp, colLeft ) == Cell.CellValue.FILLED ) neighbors++;
                if( board.getCellValue( rowUp, col ) == Cell.CellValue.FILLED ) neighbors++;
                if( board.getCellValue( rowUp, colRight ) == Cell.CellValue.FILLED ) neighbors++;
                if( board.getCellValue( row, colLeft ) == Cell.CellValue.FILLED ) neighbors++;
                if( board.getCellValue( row, colRight ) == Cell.CellValue.FILLED ) neighbors++;
                if( board.getCellValue( rowDown, colLeft ) == Cell.CellValue.FILLED ) neighbors++;
                if( board.getCellValue( rowDown, col ) == Cell.CellValue.FILLED ) neighbors++;
                if( board.getCellValue( rowDown, colRight ) == Cell.CellValue.FILLED ) neighbors++;

                liveNeighbors[row][col] = neighbors;
            }
        }
    }

    private void nextGen() 
    {
        for (int row = 0; row < rows; row++) 
        {
            for (int col = 0; col < cols; col++) 
            {
                if (board.getCellValue( row, col ) == Cell.CellValue.FILLED ) 
                {
                    if (liveNeighbors[row][col] < 2)
                        board.setCellValue( row, col, Cell.CellValue.EMPTY );
                    else if (liveNeighbors[row][col] == 2 || liveNeighbors[row][col] == 3)
                        board.setCellValue( row, col, Cell.CellValue.FILLED );
                    else if (liveNeighbors[row][col] > 3)
                        board.setCellValue( row, col, Cell.CellValue.EMPTY );
                } else {
                    if (liveNeighbors[row][col] == 3)
                        board.setCellValue( row, col, Cell.CellValue.FILLED );
                }
            }
        }
    }

    public void doUpdates()
    {
        countNeighbors();
        nextGen();
    }
}