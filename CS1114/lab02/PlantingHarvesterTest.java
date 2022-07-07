import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.micro.jeroo.*;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your test class here.
 *  Summarize what your test objectives are.
 *
 *  @author your name (your-pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class PlantingHarvesterTest
    extends TestCase
{
    //~ Fields ................................................................

    private Island island;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PlantingHarvesterTest test object.
     */
    public PlantingHarvesterTest()
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
        Island island = new Island();
    }


    public void testA()
    {
         Jeroo bobby = new Jeroo(2); // Created with two flowers
    island.add(bobby, 6, 6);
    bobby.plant();
    Jeroo jessica = new Jeroo(1); // Created with one flower
    add(jessica, 3, 3);
    bobby = jessica;
    jessica.plant();
    if (bobby.hasFlower())
    {
        System.out.println("Bobby has a flower.");
    }
    else
    {
        System.out.println( "Bobby has NO flowers.");
    }   
    }

}
