// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test case of bricks.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.12.01
 */
public class BrickTest
    extends TestCase
{
    //~ Fields ................................................................

    private Brick brick;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BrickTest test object.
     */
    public BrickTest()
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
        brick = new Brick(8, 20, 12);
    }

    // ----------------------------------------------------------
    /**
     * Test the basic accessors on a brand new Brick.
     */
    public void testBrickConstructor()
    {
        assertThat(brick.getHeight()).isEqualTo(8);
        assertThat(brick.getSurfaceArea()).isEqualTo(992);
        assertThat(brick.getVolume()).isEqualTo(1920);
        assertThat(brick.getWeight()).isEqualTo(3.84);
    }
}
