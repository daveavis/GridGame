public class GameLogic implements GameHandlerInterface
{
    //public static final String TITLE = "Life"; // window title text
    //public static final int BOX_SIZE = 10; // pixel height and width for a box

    private int[][] liveNeighbors;
    public int rows = Constants.rows;
    public int cols = Constants.cols;
    private double initialPct = 0.2; // 20% of cells are alive to start
    private Board board;

    public GameLogic()
    {
        board = GameHandler.getBoard();
        liveNeighbors = new int[rows][cols];
        
        populate();
    }
    
    private void populate() 
    {
        //alive = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if( Math.random() < initialPct )
                {
                    board.setCellValue( row, col, Constants.CellValue.ALIVE );
                } else {
                    board.setCellValue( row, col, Constants.CellValue.DEAD );
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

                if( board.getCellValue( rowUp, colLeft ) == Constants.CellValue.ALIVE ) neighbors++;
                if( board.getCellValue( rowUp, col ) == Constants.CellValue.ALIVE ) neighbors++;
                if( board.getCellValue( rowUp, colRight ) == Constants.CellValue.ALIVE ) neighbors++;
                if( board.getCellValue( row, colLeft ) == Constants.CellValue.ALIVE ) neighbors++;
                if( board.getCellValue( row, colRight ) == Constants.CellValue.ALIVE ) neighbors++;
                if( board.getCellValue( rowDown, colLeft ) == Constants.CellValue.ALIVE ) neighbors++;
                if( board.getCellValue( rowDown, col ) == Constants.CellValue.ALIVE ) neighbors++;
                if( board.getCellValue( rowDown, colRight ) == Constants.CellValue.ALIVE ) neighbors++;

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
                if (board.getCellValue( row, col ) == Constants.CellValue.ALIVE ) 
                {
                    if (liveNeighbors[row][col] < 2)
                        board.setCellValue( row, col, Constants.CellValue.DEAD );
                    else if (liveNeighbors[row][col] == 2 || liveNeighbors[row][col] == 3)
                        board.setCellValue( row, col, Constants.CellValue.ALIVE );
                    else if (liveNeighbors[row][col] > 3)
                        board.setCellValue( row, col, Constants.CellValue.DEAD );
                } else {
                    if (liveNeighbors[row][col] == 3)
                        board.setCellValue( row, col, Constants.CellValue.ALIVE );
                }
            }
        }
    }

    @Override
    public void doUpdates()
    {
        countNeighbors();
        nextGen();
    }
}