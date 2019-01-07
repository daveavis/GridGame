/**
 * A single body part of the snake.
 * 
 * @author Dave Avis
 * @version 12.22.2018
 */
public class BodyPart
{
    private int row;
    private int col;
    private int nextRow;
    private int nextCol;
    
    /**
     * Constructor
     * 
     * @param row the row the body part is in.
     * @param col the column the body part is in.
     */
    public BodyPart( int row, int col )
    {
        this.row = row;
        this.col = col;
    }
    
    /**
     * Constructor
     * 
     * @param row the row the body part is in.
     * @param col the column the body part is in.
     * @param nextRow the row of the BodyPart ahead of this one in the snake.
     * @param nextCol the column of the BodyPart ahead of this one in the snake.
     */
    public BodyPart( int row, int col, int nextRow, int nextCol )
    {
        this.row = row;
        this.col = col;
        this.nextRow = nextRow;
        this.nextCol = nextCol;
    }
    
    /**
     * Set the location of this BodyPart.
     * 
     * @param row the row of this body part.
     * @param col the column of this body part.
     */
    public void setLocation( int row, int col )
    {
        this.row = row;
        this.col = col;
    }
    
    /**
     * Set the location of the BodyPart ahead of this one in the snake.
     * 
     * @param nextRow the row of the BodyPart ahead of this one in the snake.
     * @param nextCol the column of the BodyPart ahead of this one in the snake.
     */
    public void setNextLocation( int nextRow, int nextCol )
    {
        this.nextRow = nextRow;
        this.nextCol = nextCol;
    }
    
    /**
     * Get the row of this BodyPart.
     * 
     * @return the row of this BodyPart.
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * Get the column of this BodyPart.
     * 
     * @return the column of this BodyPart.
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * Get the row of the BodyPart ahead of this one in the snake.
     * 
     * @return the row of the BodyPart ahead of this one in the snake.
     */
    public int getNextRow()
    {
        return nextRow;
    }
    
    /**
     * Get the column of the BodyPart ahead of this one in the snake.
     * 
     * @return the column of the BodyPart ahead of this one in the snake.
     */
    public int getNextCol()
    {
        return nextCol;
    }
    
    /**
     * Set the row of this BodyPart.
     * 
     * @param row the row this BodyPart should be.
     */
    public void setRow( int row )
    {
        this.row = row;
    }
    
    /**
     * Set the column of this BodyPart.
     * 
     * @param col the column this BodyPart should be.
     */
    public void setCol( int col )
    { 
        this.col = col;
    }
    
    /**
     * Set the row of the BodyPart ahead of this one in the snake.
     * 
     * @param row the row the BodyPart ahead of this one should be.
     */
    public void setNextRow( int row ) 
    {
        this.nextRow = row;
    }
    
    /**
     * Set the column of the BodyPart ahead of this one in the snake.
     * 
     * @param col the column the BodyPart ahead of this one should be.
     */
    public void setNextCol( int col )
    {
        this.nextCol = col;
    }
}