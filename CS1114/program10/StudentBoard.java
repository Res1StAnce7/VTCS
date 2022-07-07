// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.tetris2.*;
import java.util.*;

/**
 *  Implements a Tetris board which provide a common
 *  set of features that are defined by the Board interface
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.06
 */
public class StudentBoard
    implements Board
{
    private int width;
    private int height;
    private int[] columnHeights;
    private int[] blocksInAllRows;
    private boolean[][] grid;
    private int maxHeight;

    /**
     * Initializes a newly created StudentBoard object.
     * @param tempWidth The width of the board.
     * @param tempHeight The height of the board.
     */
    public StudentBoard(int tempWidth, int tempHeight)
    {
        super();
        this.width = tempWidth;
        this.height = tempHeight;
        this.columnHeights = new int[tempWidth];
        this.blocksInAllRows = new int[tempHeight];
        this.grid = new boolean[tempHeight][tempWidth];
        this.maxHeight = 0;
    }
    
    /**
     * Get the width of the board.
     * @return The width of the board.
     */
    public int getWidth()
    {
        return this.width;
    }
    
    /**
     * Get the Height of the board.
     * @return The height of the board.
     */
    public int getHeight()
    {
        return this.height;
    }
    
    /**
     * Get a 1-dimensional array of integers that is the 
     * same size as the board's width, 
     * holding the current height of each column on the board. 
     * @return The array of the heights.
     */
    public int[] getColumnHeights()
    {
        return this.columnHeights;
    }
    
    /**
     * Get a 1-dimensional array of integers that is the 
     * same size as the board's height, 
     * holding the number of blocks in each row on the board.
     * @return The array of the number of the blocks.
     */
    public int[] getBlocksInAllRows()
    {
        return this.blocksInAllRows;
    }
    
    /**
     * Get a 2-dimensional array of booleans 
     * that represents the entire board, 
     * indicating which locations are occupied 
     * by blocks (true) or empty (false).
     * @return Get the array of booleans.
     */
    public boolean[][] getGrid()
    {
        return this.grid;
    }
    
    /**
     * Returns one boolean value from your grid, indicating 
     * whether the given position is occupied or not.
     * @param point The position of the board.
     * @return If the point is occupied or not.
     */
    public boolean hasBlockAt(Point point)
    {
        return grid[point.getY()][point.getX()];
    }
    
    /**
     * Attempts to add the body of a piece to the board.
     * Copies the piece blocks into the board grid.
     * Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     * for a regular placement that causes at least one row to be filled.
     * Error cases:
     * If part of the piece would fall out of bounds, the placement
     * does not change the board at all, and PLACE_OUT_BOUNDS is returned.
     * If the placement is "bad"--interfering with existing blocks in the
     * grid--then the placement is halted partially complete and PLACE_BAD
     * is returned.
     * @param piece The Piece object.
     * @param location The location to add the piece.
     * @return The code of place.
     */
    public int place(Piece piece, Point location) 
    {
        Point[] points = piece.getBody();
        int result = Board.PLACE_OK;
        int x = location.getX();
        int y = location.getY();
        if (x < 0 || x + piece.getWidth() > this.width 
            || y < 0 || y + piece.getHeight() > this.height) 
        {
            return Board.PLACE_OUT_BOUNDS;
        }
        for (int i = 0; i < points.length; i++) 
        {
            int col = points[i].getX() + x;
            int row = points[i].getY() + y;
            if (this.grid[row][col]) 
            {
                return Board.PLACE_BAD;
            }
            if (row  > this.columnHeights[col] - 1) 
            {
                this.columnHeights[col] = row + 1;
                if (row > this.maxHeight - 1)
                {
                    this.maxHeight = row + 1;
                }
            }
            this.blocksInAllRows[row]++;
            this.grid[row][col] = true;
            if (this.blocksInAllRows[row] == this.width) 
            {
                result = Board.PLACE_ROW_FILLED;
            }
        }
        return result;
    }
    
    /**
     * Clear rows if any is (are) filled.
     * @return if any is (are) clear, return true
     *         else return false.
     */
    public boolean clearRows()
    {
        List<Integer> list = new ArrayList<Integer>();
        boolean clear = false;
        for (int i = 0; i < this.height; i++)
        {
            if (this.blocksInAllRows[i] == this.width)
            {
                clear = true;
                list.add(i);
            }
        }
        if (!clear)
        {
            return false;
        }
        int num = 0;
        for (int i = 0; i < list.size(); i++)
        {
            int row = list.get(i) - num;
            num++;
            for (int j = row + 1; j <= maxHeight; j++)
            {
                if (this.blocksInAllRows[j] != this.width)
                {
                    for (int k = 0; k < this.width; k++)
                    {
                        this.grid[row][k] = this.grid[j][k];
                    }
                    this.blocksInAllRows[row] = this.blocksInAllRows[j];
                    row++;
                }
            }
            for (int k = row; k < this.maxHeight; k++)
            {
                for (int l = 0; l < this.width; l++)
                {
                    this.grid[k][l] = false;
                }
                this.blocksInAllRows[k] = 0;
            }
            for (int m = 0; m < this.width; m++)
            {
                int n;
                for (n = this.columnHeights[m] - 1; n >= 0 
                    && !this.grid[n][m]; --n) 
                { 
                }
                this.columnHeights[m] = n + 1;
            }
            this.maxHeight--;
        }
        return clear;
    }  
    
    /**
     * Get the largest Hheight
     * @return The largest height.
     */
    public int getMaxHeight()
    {
        return this.maxHeight;
    }
}
