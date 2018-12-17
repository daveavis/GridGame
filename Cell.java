public class Cell
{
    enum CellValue  // could this go in the class with the game logic?
    {
        EMPTY, FILLED
    }
    
    private int row;
    private int col;
    CellValue value;
    
    public Cell()
    {
        this.row = 0;
        this.col = 0;
        this.value = CellValue.EMPTY;
    }
    
    public Cell( int row, int col )
    {
        this.row = row;
        this.col = col;
        this.value = CellValue.EMPTY;
    }
    
    public Cell( CellValue value )
    {
        this.value = value;
    }
    
    public Cell( int row, int col, CellValue value )
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
    
    public CellValue getValue()
    {
        return value;
    } 
    public void setValue( CellValue value )
    {
        this.value = value;
    }
}