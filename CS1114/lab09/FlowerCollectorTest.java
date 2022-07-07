// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;
import java.util.*;
import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  The test class which will test all 
 *  the methods in FlowerCollector
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.19
 */
public class FlowerCollectorTest
    extends TestCase
{
    //~ Fields ................................................................
    private FlowerCollector jeroo;
    private FlowerIsland island;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlowerCollectorTest test object.
     */
    public FlowerCollectorTest()
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
        jeroo = new FlowerCollector();
        island = new FlowerIsland(6, 6);
        island.addObject(jeroo, 1, 1);
    }

    /**
     * Test if jeroo will be located at the right-lower 
     * corner of the island
     */
    public void testCollectFlowers()
    {
        jeroo.collectFlowers();
        assertThat(jeroo.getX()).isEqualTo(4);
        assertThat(jeroo.getY()).isEqualTo(4);
        assertThat(jeroo.getBasket().size()).isEqualTo(8);
    }
    
    /**
     * The basket is empty on a newly created flower collector
     */
    public void testGetBasket()
    {
        assertThat(jeroo.getBasket().size()).isEqualTo(0);
    }
    
    /**
     * Test the overrided pick()
     */
    public void testPick()
    {
        if (!island.hasFlowerAt(1, 1))
        {
            island.addObject(new Flower(), 1, 1);
        }
        jeroo.pick();
        assertThat(jeroo.getBasket().size()).isEqualTo(1);
    }
}
