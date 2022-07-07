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
 *  The test class of CopyingJeroo
 *  It will test all the methods and conditions in it
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.06
 */
public class CopyingJerooTest
    extends TestCase
{
    //~ Fields ................................................................

    private Island island;
    private CopyingJeroo jeroo;
    private Jeroo copier;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CopyingJerooTest test object.
     */
    public CopyingJerooTest()
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
        island = new DualIsland();
        
        Jeroo andy = new Jeroo(1000);
        copier = andy;
        island.addObject(copier, 10, 1);
        
        jeroo = new CopyingJeroo(copier);
        island.addObject(jeroo, 1, 1);
    }

    // ----------------------------------------------------------
    /**
     * Test if the Jeroo has walked the whole island
     */
    public void testWalkIsland()
    {
        jeroo.walkIsland();
        assertThat(jeroo.getX() == 1).isTrue();
        assertThat(jeroo.getY() == 8).isTrue();
        assertThat(copier.getX() == 10).isTrue();
        assertThat(copier.getY() == 8).isTrue();
    }
    /**
     * Check hopToWater(), assuming that setUp() places the
     * jeroo at (1, 1) facing east.
     */
    public void testHopToWater()
    {
        jeroo.hopToWater();
        assertThat(jeroo.getX()).isEqualTo(8);
        assertThat(jeroo.seesWater(AHEAD)).isTrue();
        assertThat(copier.getX()).isEqualTo(17);
        assertThat(copier.seesWater(AHEAD)).isTrue();
    }
    
    /**
     * Place a new Jeroo at the ned point and the method
     * should return true
     */
    public void testIsAtEndPoint()
    {
        jeroo.setLocation(1, 8);
        assertThat(jeroo.isAtEndPoint()).isTrue();
        
        jeroo.setLocation(1, 7);
        assertThat(jeroo.isAtEndPoint()).isFalse();
        
        jeroo.setLocation(2, 7);
        assertThat(jeroo.isAtEndPoint()).isFalse();
    }
    
    /**
     * Test if hop() (overrided) is working 
     */
    public void testHop()
    {
        jeroo.hop();
        assertThat(jeroo.getX()).isEqualTo(2);
        assertThat(copier.getX()).isEqualTo(11);
    }
    
    /**
     * Test if turn() (overrieded) is working
     */
    public void testTurn()
    {
        jeroo.turn(RIGHT);
        assertThat(jeroo.isFacing(SOUTH)).isTrue();
        assertThat(copier.isFacing(SOUTH)).isTrue();
    }
    
    /**
     * Test if the copier plants when the master sees a flower HERE 
     */
    public void testPlantIfSeesFlower()
    {
        if (!island.hasFlowerAt(8, 8))
        {
            island.addObject(new Flower(), 8, 8);
        }
        jeroo.setLocation(8, 8);
        jeroo.plantIfSeesFlower();
        
        assertThat(copier.getFlowers()).isEqualTo(999);
        assertThat(island.hasFlowerAt(10, 1)).isTrue();
    }
}
