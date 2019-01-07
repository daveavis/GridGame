// import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
// import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

// /**
 // * This is an implementation of Conway's Game of Life.
 // * 
 // * @author Dave Avis
 // * @version 12.19.2018
 // */

// public class GameOfLife implements GameHandlerInterface
// {
    // private int[][] liveNeighbors;
    // public int rows = Constants.rows;
    // public int cols = Constants.cols;
    // private double initialPct = 0.2; // 20% of cells are alive to start
    // private Board board;

    // /**
     // * Start the game of life.
     // */
    // public GameOfLife()
    // {
        // board = GameHandler.getBoard();
        // liveNeighbors = new int[rows][cols];
        
        // populate();
    // }
    
    // /**
     // * Populate the initial board where a certain percentage of the cells are alive.
     // */
    // private void populate() 
    // {
        // for (int row = 0; row < rows; row++) {
            // for (int col = 0; col < cols; col++) {
                // if( Math.random() < initialPct )
                // {
                    // board.setCellValue( row, col, Constants.CellValue.ALIVE );
                // } else {
                    // board.setCellValue( row, col, Constants.CellValue.DEAD );
                // }
            // }
        // }
    // }

    // /**
     // * For each cell on the board, count how many of its neighbors are alive.
     // */
    // private void countNeighbors() 
    // {
        // int rowUp;
        // int rowDown;
        // int colLeft;
        // int colRight;

        // for (int row = 0; row < rows; row++) {
            // for (int col = 0; col < cols; col++) {
                // int neighbors = 0;

                // rowUp = (row - 1);
                // if (rowUp < 0) rowUp += rows;  // wrap around the top and bottom

                // rowDown = (row + 1) % (rows - 1);

                // colLeft = col - 1;
                // if (colLeft < 0) colLeft += cols;  // wrap around the sides

                // colRight = (col + 1) % (cols - 1);

                // if( board.getCellValue( rowUp, colLeft ) == Constants.CellValue.ALIVE ) neighbors++;
                // if( board.getCellValue( rowUp, col ) == Constants.CellValue.ALIVE ) neighbors++;
                // if( board.getCellValue( rowUp, colRight ) == Constants.CellValue.ALIVE ) neighbors++;
                // if( board.getCellValue( row, colLeft ) == Constants.CellValue.ALIVE ) neighbors++;
                // if( board.getCellValue( row, colRight ) == Constants.CellValue.ALIVE ) neighbors++;
                // if( board.getCellValue( rowDown, colLeft ) == Constants.CellValue.ALIVE ) neighbors++;
                // if( board.getCellValue( rowDown, col ) == Constants.CellValue.ALIVE ) neighbors++;
                // if( board.getCellValue( rowDown, colRight ) == Constants.CellValue.ALIVE ) neighbors++;

                // liveNeighbors[row][col] = neighbors;
            // }
        // }
    // }

    // /**
     // * Determine which cells are alive and dead in the next generation.
     // */
    // private void nextGen() 
    // {
        // for (int row = 0; row < rows; row++) 
        // {
            // for (int col = 0; col < cols; col++) 
            // {
                // if (board.getCellValue( row, col ) == Constants.CellValue.ALIVE ) 
                // {
                    // if (liveNeighbors[row][col] < 2)
                        // board.setCellValue( row, col, Constants.CellValue.DEAD );
                    // else if (liveNeighbors[row][col] == 2 || liveNeighbors[row][col] == 3)
                        // board.setCellValue( row, col, Constants.CellValue.ALIVE );
                    // else if (liveNeighbors[row][col] > 3)
                        // board.setCellValue( row, col, Constants.CellValue.DEAD );
                // } else {
                    // if (liveNeighbors[row][col] == 3)
                        // board.setCellValue( row, col, Constants.CellValue.ALIVE );
                // }
            // }
        // }
    // }

    // /**
     // * Update the board by counting neighbors and populating the next generation.
     // */
    // @Override
    // public void doUpdates()
    // {
        // countNeighbors();
        // nextGen();
    // }
// }