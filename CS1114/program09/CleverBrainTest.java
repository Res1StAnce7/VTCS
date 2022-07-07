// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Test several conditions related to rateBoard() 
 *  and bestMove()
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.28
 */
public class CleverBrainTest
    extends TestCase
{
    //~ Fields ................................................................
    private CleverBrain myBrain;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CleverBrainTest test object.
     */
    public CleverBrainTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        myBrain = new CleverBrain();
    }

    
    /**
     * Test the rate board on the first row
     */
    public void testRateBoardOnRow0()
    {
        Board board = new Board(10, 24, "####      ");
        double score = myBrain.rateBoard(board);
        
        assertThat(score).isEqualTo(1.2, within(0.1));
    }
    
    /**
     * Test the behavior of brain when a right L piece appears
     */
    public void testLonRow0()
    {
        Board board = new Board(10, 24,
            "#### #####");
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 0);

        Move move = myBrain.bestMove(board, piece, 20);

        assertThat(move.getLocation()).isEqualTo(new Point(4, 0));

        assertThat(move.getPiece()).isEqualTo(
            Piece.getPiece(Piece.RIGHT_L, 3));
            
        move = myBrain.bestMove(board, piece, 3);
        assertThat(move.getLocation()).isEqualTo(new Point(4, 0));
    }
    
    /**
     * Test the behaviour of brain when a right LD piece appears
     */
    public void testLD()
    {
        Board board = new Board(10, 24,
            "#### #### ",
            "##########");
        Piece piece = Piece.getPiece(Piece.RIGHT_DOG, 0);

        Move move = myBrain.bestMove(board, piece, 20);

        assertThat(move.getLocation()).isEqualTo(new Point(6, 1));

        assertThat(move.getPiece()).isEqualTo(
            Piece.getPiece(Piece.RIGHT_DOG, 2));
    }
    
    /**
     * Test if the method will return the correct number
     * of holes in a column
     */
    public void testCountHoles()
    {
        Board board = new Board(10, 24,
            "#### #####",
            "### ######",
            "### ######");
        assertThat(myBrain.countHoles(board, 3)).isEqualTo(2);
    }
    
    /**
     * Similar to countHoles(), it will test if the method
     * will return the correct list representing the hole list
     */
    public void testGetHolesList()
    {
        Board board = new Board(10, 24,
            "#### #####",
            "### # ####",
            "### ######");
        List<Point> pointList = myBrain.getHolesList(board, 3);
        assertThat(pointList.contains(new Point(3, 0))).isTrue();
        assertThat(pointList.contains(new Point(3, 1))).isTrue();
    }
    
    /**
     * Test if the method will return the correct number of
     * blocks on a hole
     */
    public void testCountBlocksOnHoles()
    {
        Board board = new Board(10, 24,
            "#### #####",
            "##### ####",
            "### ######");
        assertThat(myBrain.countBlocksOnHoles(board, 
                    new Point(3, 0))).isEqualTo(2);
    }
    
    /**
     * Test if any column of the board reaches the heightLimit
     */
    public void testReachHeightLimit()
    {
        Board board = new Board(10, 24,
            "     #    ",
            "##### ####",
            "### ######");
        assertThat(myBrain.reachHeightLimit(board, 3)).isFalse();
        assertThat(myBrain.reachHeightLimit(board, 2)).isTrue();
    }
}
