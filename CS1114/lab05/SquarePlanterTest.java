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
 *  It is the test class of flowerPerSide
 *  which will test all the methods in this class
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.21
 */
public class SquarePlanterTest
    extends TestCase
{
    //~ Fields ................................................................
    private Island island;
    private SquarePlanter jeroo;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new flowerPerSideTest test object.
     */
    public SquarePlanterTest()
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
        island = new Island();
        jeroo = new SquarePlanter(6);
        island.addObject(jeroo, 1, 1);
    }

    /**
     * the test method of plantSquare()
     */
    public void testPlantSquare()
    {
        jeroo.plantSquare();
        
        assertThat(island.countFlowers()).isEqualTo(24);
        for (int i = 1; i <= 7; i++)
        {
            assertThat(island.hasFlowerAt(i, 1)).isTrue();
            assertThat(island.hasFlowerAt(i, 7)).isTrue();
            assertThat(island.hasFlowerAt(1, i)).isTrue();
            assertThat(island.hasFlowerAt(7, i)).isTrue();
        }
        assertThat(jeroo.getHeading()).isEqualTo(EAST);

    }
    
    /**
     * the second test method of plantSquare()
     */
    public void testTwoPlantSquare()
    {
        jeroo.remove();

        jeroo = new SquarePlanter(8);
        island.addObject(jeroo, 1, 1);
        jeroo.plantSquare();
        
        assertThat(island.countFlowers()).isEqualTo(32);
        for (int i = 1; i <= 9; i++)
        {
            assertThat(island.hasFlowerAt(i, 1)).isTrue();
            assertThat(island.hasFlowerAt(i, 9)).isTrue();
            assertThat(island.hasFlowerAt(1, i)).isTrue();
            assertThat(island.hasFlowerAt(9, i)).isTrue();
        }
        assertThat(jeroo.getHeading()).isEqualTo(EAST);
    }
    
    /**
     * the test method of plantOneSide()
     */
    public void testPickOneSide()
    {
        jeroo.plantOneSide();
        
        for (int i = 1; i <= 6; i++)
        {
            assertThat(island.hasFlowerAt(i, 1)).isTrue();
        }
        assertThat(jeroo.getHeading()).isEqualTo(EAST);
    }
}
