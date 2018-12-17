public class Board
{
    Cell[][] cells;
    
    // initialize a board of proper dimensions with empty cells
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
    
    public void clearBoard()
    {
        for( int row = 0; row < cells.length; row++ )
        {
            for( int col = 0; col < cells[0].length; col++ )
            {
                cells[row][col] = new Cell( row, col, Cell.CellValue.EMPTY );
            }
        }
    }
    
    public Cell.CellValue getCellValue( int row, int col )
    {
        return cells[row][col].getValue();
    }
    
    public void setCellValue( int row, int col, Cell.CellValue value )
    {
        cells[row][col].setValue( value );
    }
}