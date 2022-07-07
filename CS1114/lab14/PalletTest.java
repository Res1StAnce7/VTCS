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
 *  Test class of Pallet.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.12.01
 */
public class PalletTest
    extends TestCase
{
    //~ Fields ................................................................

    private Pallet pallet;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PalletTest test object.
     */
    public PalletTest()
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
        pallet = new Pallet(5, 4);
    }

    // ----------------------------------------------------------
    /**
     * Test the basic accessors on a brand new Pallet.
     */
    public void testPalletConstructor()
    {
        assertThat(pallet.getWeight()).isEqualTo(83.3);
        assertThat(pallet.getHeight()).isEqualTo(47);
    }

}
