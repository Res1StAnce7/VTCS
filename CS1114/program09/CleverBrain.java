// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)

import student.tetris.*;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Act as the "Brain" for an automated Tetris player
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.28
 */
public class CleverBrain
    implements Brain
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created CleverBrain object.
     */
    public CleverBrain()
    {
        super();
    }


    //~ Methods ...............................................................
    /**
     * Take and board a object and rate the board which represents
     * how difficult the board is.
     * The board have will have more points, 
     * if the following conditions happen:
     * Greater average height (main), holes and blocks on the top of holes.
     * Since average height is more important while rating,
     * its point will be trippled.
     * Column rating will involve the number of holes 
     * plus the max number of blocks on the top of holes.
     * The total points will be the points of average height 
     * plus the average column rating.
     * @param board The board to be rated
     * @return The rating score of the board
     */
    public double rateBoard(Board board)
    {
        int column = 0;
        double rating = 0.0;
        double colRating = 0.0;
        int[] columnArr = board.getColumnHeights();
        int blocksOnHoles = 0;
        List<Point> holesList = null;
        
        for (int num : columnArr)
        {
            rating += num;
        }
        rating = rating / (double) (board.getWidth()) * 3;
        
        while (column < board.getWidth())
        {
            colRating += countHoles(board, column);
            holesList = getHolesList(board, column);
            for (Point point : holesList)
            {
                blocksOnHoles = Math.max(blocksOnHoles, 
                                countBlocksOnHoles(board, point));
            }
            
            colRating += blocksOnHoles;
            column++;
        }
        rating += colRating / (double) board.getWidth();
        
        return rating;
    }
    
    /**
     * Take a Board object, a Piece object and an integer
     * It will try every position and every column on the board
     * to try to place it under the heightLimit
     * @param board The Board object
     * @param piece The piece object
     * @param heightLimit The piece should be place below it
     * @return The best move 
     */
    public Move bestMove(Board board, Piece piece, int heightLimit)
    {
        Move move = new Move(piece);
        int tempRotation = -1;
        int tempX = -1;
        Piece[] pieceRotations = piece.getRotations();
        int[] columnArr = board.getColumnHeights();
        List<Double> rateList = new ArrayList<Double>();
        List<Point> pointList = new ArrayList<Point>();
        List<Integer> rotationList = new ArrayList<Integer>();
        
        for (int i = 0; i < piece.numRotations(); i++)
        {
            for (int j = 0; j < board.getWidth(); j++)
            {
                int placeResult = board.place(pieceRotations[i],
                    new Point(j, columnArr[j]));  
                if ((placeResult == Board.PLACE_OK 
                    || placeResult == Board.PLACE_ROW_FILLED)
                    && !reachHeightLimit(board, heightLimit))
                {                  
                    board.clearRows();
                    rateList.add(rateBoard(board));  
                    pointList.add(new Point(j, columnArr[j]));
                    rotationList.add(i);
                }      
                board.undo();
            }
        }
        
        if (rateList.size() != 0)
        {
            double tempRate = rateList.get(0);
            int index = 0;
            for (int i = 0; i < rateList.size(); i++)
            {
                if (rateList.get(i) < tempRate)
                {
                    tempRate = rateList.get(i);
                    index = i;
                }
            }
            
            move.setLocation(pointList.get(index));
            move.setScore(tempRate);
            move.setPiece(pieceRotations[rotationList.get(index)]);
        }
        else
        {
            move.setLocation(new Point(0, heightLimit));
        }
        return move;
    }
        
    /**
     * Take a Board object and an integer represent the column of the board
     * count the number of holes in the column
     * @param board The Board obejct
     * @param column The column needs to count holes
     * @return The number of holes in the column
     */
    public int countHoles(Board board, int column)
    {
        int num = 0;
        int[] columnArr = board.getColumnHeights();
        
        for (int i = 0; i < columnArr[column]; i++)
        {
            Point point = new Point(column, i);
            if (!board.hasBlockAt(point))
            {
                num++;
            }
        }
        
        return num;
    }
    
    /**
     * Take a Board object and an integer represent the column of the board
     * get the holes in the column as a List
     * @param board The Board obejct
     * @param column The column of the board
     * @return The list which represents the Points of holes
     */
    public List<Point> getHolesList(Board board, int column)
    {
        List<Point> pointList = new ArrayList<Point>();
        int[] columnArr = board.getColumnHeights();
        
        for (int i = 0; i < columnArr[column]; i++)
        {
            Point point = new Point(column, i);
            if (!board.hasBlockAt(point))
            {
                pointList.add(point);
            }
        }
        
        return pointList;
    }
    
    /**
     * Take a Board object and a Point obejct
     * count the max number of blocks above a hole
     * @param board The Board obejct
     * @param point The Point object
     * @return The max number of blocks above a hole
     */
    public int countBlocksOnHoles(Board board, Point point)
    {
        int num = 0;
        int[] columnArr = board.getColumnHeights();
        
        for (int i = point.getY() + 1; i < columnArr[point.getX()]; i++)
        {
            Point p = new Point(point.getX(), i);
            if (board.hasBlockAt(p))
            {
                num++;
            }
        }
        
        return num;
    }
    
    /**
     * Take a Board object and an integer,
     * check if there is any column of the board
     * reaches exceed the height limit
     * @param board The board object
     * @param heightLimit The height limit
     * @return If the board exceeds the limit return true, vice versa
     */
    public boolean reachHeightLimit(Board board, int heightLimit)
    {
        int[] heights = board.getColumnHeights();

        for (int i = 0; i < heights.length; i++)
        {
            if (heights[i] > heightLimit)
            {
                return true;
            }
        }
        return false;
    }
}
