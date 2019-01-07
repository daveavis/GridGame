/**
 * A Board is a 2 dimensional grid of square cells.
 * 
 * @author Dave Avis
 * @version 12.19.2018
 */
public class Board
{
    Cell[][] cells;  // an array of all of the cell values on the board
    
    /**
     * Initialize a board with the dimensions provided.
     * 
     * @param rows how many rows the board has
     * @param cols how many columns the board has
     */
    public Board( int rows, int cols )
    {
        this.cells = new Cell[rows][cols];
        for( int row = 0; row < rows; row++ )
        {
            for( int col = 0; col < cols; col++ )
            {
                cells[row][col] = new Cell( row, col );
            }
        }
    }
    
    /**
     * Overwrite the whole board with empty cells.
     */
    public void clearBoard()
    {
        for( int row = 0; row < cells.length; row++ )
        {
            for( int col = 0; col < cells[0].length; col++ )
            {
                cells[row][col] = new Cell( row, col );
            }
        }
    }
    
    /**
     * Gets the value of a cell on the board.
     * This is probably reduntant and can be handled by calling the cell.
     * Something to look at.
     * 
     * @param row the cell's row
     * @param col the cell's column
     * @return the current value of the cell
     */
    public Constants.CellValue getCellValue( int row, int col )
    {
        return cells[row][col].getValue();
    }
    
    /**
     * Sets the value of a cell on the board.
     * This is probably redundant and can be handled by calling the cell.
     * Something to look at.
     * 
     * @param row the cell's row
     * @param col the cell's column
     * @param value the value to set the cell to
     */
    public void setCellValue( int row, int col, Constants.CellValue value )
    {
        cells[row][col].setValue( value );
    }
}