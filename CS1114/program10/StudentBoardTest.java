// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris2.*;

/**
 *  The Test class of StudentBoard which test its constructor
 *  and all the including methods
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.06
 */
public class StudentBoardTest
    extends TestCase
{
    private StudentBoard board;
    
    /**
     * Creates a new StudentBoardTest test object.
     */
    public StudentBoardTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        board = new StudentBoard(10, 24);
    }

    /**
     * Test the constructor of StudentBoard (getters)
     */
    public void testStudentBoard()
    {
        assertThat(board.getWidth()).isEqualTo(10);
        assertThat(board.getHeight()).isEqualTo(24);
        
        int[] columnArr = board.getColumnHeights();
        for (int num : columnArr)
        {
            assertThat(num).isEqualTo(0);
        }
        
        int[] rowArr = board.getBlocksInAllRows();
        for (int num : rowArr)
        {
            assertThat(num).isEqualTo(0);
        }
        
        boolean[][] gridArr = board.getGrid();
        for (boolean[] arr : gridArr)
        {
            for (boolean test : arr)
            {
                assertThat(test).isEqualTo(false);
            }
        }
    }
    
    /**
     * Given a point occupied by a block,
     * the method should return true.
     * Given a clear point, the method should return false.
     */
    public void testHasBlockAt()
    {
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " ### #####",
            " # # # ###"
            );
        Point point1 = new Point(1, 0);
        Point point2 = new Point(0, 0);
        assertThat(board.hasBlockAt(point1)).isTrue();
        assertThat(board.hasBlockAt(point2)).isFalse();
    }
    
    /**
     * Test if the test will correctly place the board
     * and return the correct code
     */
    public void testPlace()
    {
        //Board.PLACE_OK
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #        ");
        Piece piece = Piece.getPiece(Piece.LEFT_DOG, 0);
        int result = board.place(piece, new Point(0, 1));
        assertThat(result).isEqualTo(Board.PLACE_OK);
        assertThat(board.getMaxHeight()).isEqualTo(3);
        
        //Board.PLACE_OUT_BOUNDS
        result = board.place(piece, new Point(-1, 0));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        result = board.place(piece, new Point(-1, -1));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        result = board.place(piece, new Point(-1, 0));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        result = board.place(piece, new Point(10, 24));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        result = board.place(piece, new Point(10, 0));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        result = board.place(piece, new Point(0, 24));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        result = board.place(piece, new Point(11, -1));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        result = board.place(piece, new Point(-2, 25));
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);
        
        //Board.PLACE_ROW_FILLED
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #########");
        piece = Piece.getPiece(Piece.STICK, 0);
        result = board.place(piece, new Point(0, 0));
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #########");
        piece = Piece.getPiece(Piece.T, 3);
        result = board.place(piece, new Point(0, 0));
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        
        //Board.PLACE_BAD
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #########");
        piece = Piece.getPiece(Piece.STICK, 0);
        result = board.place(piece, new Point(0, 0));
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        piece = Piece.getPiece(Piece.T, 3);
        result = board.place(piece, new Point(0, 0));
        assertThat(result).isEqualTo(Board.PLACE_BAD);
    }
    
    /**
     * Test the behaviour of the board when it is empty,
     * has zero filled rows, has one filled row 
     * and has multiple filled rows.
     */
    public void testClearRows()
    {
        //empty board
        StudentBoard tempBoard = new StudentBoard(10, 24);
        board.clearRows();
        assertThat(tempBoard.getBlocksInAllRows()).
                   isEqualTo(board.getBlocksInAllRows());
        assertThat(tempBoard.getMaxHeight())
                   .isEqualTo(board.getMaxHeight());
        assertThat(tempBoard.getColumnHeights()).
                   isEqualTo(board.getColumnHeights());
        assertThat(tempBoard.getGrid()).isEqualTo(board.getGrid());
                   
        //zero filled rows
        tempBoard = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #        ");
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #        ");
        board.clearRows();
        assertThat(tempBoard.getBlocksInAllRows()).
                   isEqualTo(board.getBlocksInAllRows());
        assertThat(tempBoard.getMaxHeight())
                   .isEqualTo(board.getMaxHeight());
        assertThat(tempBoard.getColumnHeights()).
                   isEqualTo(board.getColumnHeights());
        assertThat(tempBoard.getGrid()).isEqualTo(board.getGrid());

        //one filled row
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #########");
        Piece piece = Piece.getPiece(Piece.STICK, 0);
        int result = board.place(piece, new Point(0, 0));
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        assertThat(board.getMaxHeight()).isEqualTo(4);
        board.clearRows();
        assertThat(board.getMaxHeight()).isEqualTo(3);
        int[] columnArr = {3, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < columnArr.length; i++)
        {
            assertThat(columnArr[i]).isEqualTo(board.getColumnHeights()[i]);
        }
        boolean[] boolArr = {true, true, true, false};
        for (int i = 0; i < boolArr.length; i++)
        {
            assertThat(boolArr[i]).isEqualTo(board.getGrid()[i][0]);
        }
        int[] rowArr = {1, 1, 1, 0};
        for (int i = 0; i < rowArr.length; i++)
        {
            assertThat(rowArr[i]).isEqualTo(board.getBlocksInAllRows()[i]);
        }
        
        //multiple filled rows
        board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            " #########",
            "  ## #####",
            " ###### ##",
            " #########");
        piece = Piece.getPiece(Piece.STICK, 0);
        result = board.place(piece, new Point(0, 0));
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        board.clearRows();
        assertThat(board.getMaxHeight()).isEqualTo(2);
        assertThat(board.getBlocksInAllRows()[0]).isEqualTo(9);
        assertThat(board.getBlocksInAllRows()[1]).isEqualTo(8);
        assertThat(board.getBlocksInAllRows()[2]).isEqualTo(0);
        assertThat(board.getBlocksInAllRows()[3]).isEqualTo(0);
        int[] columnArr2 = {2, 1, 2, 2, 1, 2, 2, 2, 2, 2};
        assertThat(columnArr2).isEqualTo(board.getColumnHeights());
    }
    
    /**
     * Get the largest height
     */
    public void testGetMaxHeight()
    {
        assertThat(board.getMaxHeight()).isEqualTo(0);
    }
}
