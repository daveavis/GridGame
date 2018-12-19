public class Cell
{
    // enum CellValue  // could this go in the class with the game logic?
    // {
        // EMPTY, FILLED
    // }
    
    private int row;
    private int col;
    Constants.CellValue value;
    
    public Cell()
    {
        this.row = 0;
        this.col = 0;
        //this.value = Constants.CellValue.EMPTY;
    }
    
    public Cell( int row, int col )
    {
        this.row = row;
        this.col = col;
        //this.value = Constants.CellValue.EMPTY;
    }
    
    public Cell( Constants.CellValue value )
    {
        this.value = value;
    }
    
    public Cell( int row, int col, Constants.CellValue value )
    {
        this.row = row;
        this.col = col;
        this.value = value;
    }
    
    public int getrow()
    {
        return row;
    }
    
    public int getY()
    {
        return col;
    }
    
    public Constants.CellValue getValue()
    {
        return value;
    } 
    public void setValue( Constants.CellValue value )
    {
        this.value = value;
    }
}