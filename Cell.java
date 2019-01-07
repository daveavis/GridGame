/**
 * One cell on the Board.
 * 
 * @author Dave Avis
 * @version 12.19.2018
 */
public class Cell
{
    private int row;  // which row this cell is in
    private int col;  // which column this cell is in
    Constants.CellValue value;  // the value of this cell
    
    /**
     * Default constructor.
     */
    public Cell()
    {
        this.row = 0;
        this.col = 0;
    }
    
    /**
     * Constructs a cell at a certain row and column.
     * 
     * @param row the row of the cell
     * @param col the column of the cell
     */
    public Cell( int row, int col )
    {
        this.row = row;
        this.col = col;
    }
    
    /**
     * Constructs a cell at a certain row and column containing
     * the starting value provided.
     * 
     * @param row the row of the cell
     * @param col the column of the cell
     * @param value the value for the cell to have
     */
    public Cell( int row, int col, Constants.CellValue value )
    {
        this.row = row;
        this.col = col;
        this.value = value;
    }
    
    /**
     * Gets what row the cell is in.
     * 
     * @return the row the cell is in
     */
    public int getrow()
    {
        return row;
    }
    
    /**
     * Gets what column the cell is in.
     * 
     * @return the column the cell is in
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * Gets the value of the cell.
     * 
     * @return the value of the cell
     */
    public Constants.CellValue getValue()
    {
        return value;
    }
    
    /**
     * Sets the value of the cell.
     * 
     * @param value the value to put in the cell
     */
    public void setValue( Constants.CellValue value )
    {
        this.value = value;
    }
}