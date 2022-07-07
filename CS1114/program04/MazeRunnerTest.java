// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  It is test class of MazeRunner
 *  which will test all the methods and conditions 
 *  in the MazeRunner
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.19
 */
public class MazeRunnerTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    
    public void testStartCheck()
    {
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        
        int check = runner.startCheck();
        assertThat(check).isEqualTo(2);
    }

}
