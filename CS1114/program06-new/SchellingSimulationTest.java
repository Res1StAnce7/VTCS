// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.media.*;
import java.awt.Color;
import student.micro.*;
import static org.assertj.core.api.Assertions.*;
// -------------------------------------------------------------------------
/**
 *  The test class of SchellingSimulation
 *  which will test all the method (conditions) of it
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.03
 */
public class SchellingSimulationTest
    extends TestCase
{
    //~ Fields ................................................................
    private SchellingSimulation sim;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SchellingSimulationTest test object.
     */
    public SchellingSimulationTest()
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
        sim = new SchellingSimulation(3, 3);
    }

    /**
     * test if the satisification threshold value returned
     * is the preset value
     */ 
    public void testGetSatisfactionThreshold()
    {
        assertThat(sim.getSatisfactionThreshold()).isEqualTo(0.3);
    }
    
    /**
     * test if the satisfication thresold value will change to 
     * the one I set
     */
    public void testSetSatisfactionThreshold()
    {
        sim.setSatisfactionThreshold(0.55);
        assertThat(sim.getSatisfactionThreshold()).isEqualTo(0.55);
    }
    
    /**
     * test if the redLine value returned
     * is the preset value
     */ 
    public void testGetRedLine()
    {
        assertThat(sim.getRedLine()).isEqualTo(0);
    }
    
    /**
     * test if the redLine value will change to 
     * the one I set
     */
    public void testSetRedLine()
    {
        sim.setRedLine(2);
        assertThat(sim.getRedLine()).isEqualTo(2);
    }
    
    /**
     * test if two different kinds of agents are correctly randomized
     * In the case, I just test if the blue agents can be randomized 
     * under preset percentage and values
     * since blue and orange have the same algorithm
     * And it is hard to directly call populate to do the test,
     * so I paste part of it to make the test
     */
    public void testPopulate()
    {
        sim.populate(1.0, 0);
        for (Pixel pix : sim.getPixels())
        {
            assertThat(pix.getColor()).isEqualTo(Color.BLUE);
        }
        
        setAllToWhite();
        sim.populate(0, 1.0);
        for (Pixel pix : sim.getPixels())
        {
            assertThat(pix.getColor()).isEqualTo(Color.ORANGE);
        }
        
        setAllToWhite();
        sim.setRedLine(1);
        sim.populate(0, 1.0);
        for (Pixel pix : sim.getPixels())
        {
            if (pix.getY() >= 1)
            {
                assertThat(pix.getColor()).isEqualTo(Color.ORANGE);
            }
        }
        
        setAllToWhite();
        sim.populate(0.5, 0.5);
        int blue = 0;
        int orange = 0;
        for (Pixel pix : sim.getPixels())
        {
            if (pix.getColor().equals(Color.BLUE))
            {
                blue++;
            }
            else if (pix.getColor().equals(Color.ORANGE))
            {
                orange++;
            }
        }
        assertThat(blue >= 2).isTrue();
        assertThat(orange >= 2).isTrue();
    }
    
    /**
     * Test if two pixels have the same color
     */
    public void testAreSameColor()
    {
        Pixel pix1 = sim.getPixel(0, 0);
        Pixel pix2 = sim.getPixel(0, 1);
        
        pix1.setColor(Color.ORANGE);
        pix2.setColor(Color.BLUE);
        
        assertThat(sim.areSameColor(pix1, pix2)).isFalse();
    }
    
    /**
     * Test if the color of the selected pixel is white
     */
    public void testIsEmpty()
    {
        Pixel pix = sim.getPixel(0, 0);
        pix.setColor(Color.BLUE);
        
        assertThat(sim.isEmpty(pix)).isFalse();
    }
    
    /**
     * Test if an agent of the specified Color 
     * would be satisfied at the given Pixel location
     */
    public void testIsSatisfied()
    {
        Pixel pix1 = sim.getPixel(0, 0);
        Pixel pix2 = sim.getPixel(1, 0);
        Pixel pix3 = sim.getPixel(2, 0);
        Pixel pix4 = sim.getPixel(0, 1);
        Pixel pix5 = sim.getPixel(1, 1);
        Pixel pix6 = sim.getPixel(2, 1);
        Pixel pix7 = sim.getPixel(0, 2);
        Pixel pix8 = sim.getPixel(1, 2);
        Pixel pix9 = sim.getPixel(2, 2);
        pix1.setColor(Color.ORANGE);
        pix2.setColor(Color.ORANGE);
        pix3.setColor(Color.ORANGE);
        pix4.setColor(Color.ORANGE);
        pix5.setColor(Color.ORANGE);
        pix7.setColor(Color.ORANGE);
        pix8.setColor(Color.ORANGE);
        pix9.setColor(Color.ORANGE);
        
        assertThat(sim.isSatisfied(pix6, Color.BLUE)).isFalse();
        
        setAllToWhite();
        assertThat(sim.isSatisfied(pix1, Color.BLUE)).isFalse();
    
        sim.setRedLine(2);
        assertThat(sim.isSatisfied(pix4, Color.ORANGE)).isFalse();
    }
    
    /**
     * Test all three conditions (when relocate a blue agent, 
     * a orange agent and when they cannot be moved)
     */
    public void testMaybeRelocate()
    {
        sim.getPixel(0, 0).setColor(Color.BLUE);
        boolean didMove1 = sim.maybeRelocate(sim.getPixel(0, 0));
        assertThat(didMove1).isFalse();
        
        sim.getPixel(0, 0).setColor(Color.ORANGE);
        boolean didMove2 = sim.maybeRelocate(sim.getPixel(0, 0));
        assertThat(didMove2).isFalse();
        
        for (Pixel pix : sim.getPixels())
        {
            pix.setColor(Color.ORANGE);
        }
        
        boolean didMove3 = sim.maybeRelocate(sim.getPixel(1, 1));
        assertThat(didMove3).isFalse();
        
        for (Pixel pix : sim.getPixels())
        {
            pix.setColor(Color.BLUE);
        }
        sim.getPixel(1, 1).setColor(Color.ORANGE);
        boolean didMove4 = sim.maybeRelocate(sim.getPixel(1, 1));
        assertThat(didMove4).isFalse();
        
        setAllToWhite();
        sim.getPixel(1, 1).setColor(Color.ORANGE);
        boolean didMove5 = sim.maybeRelocate(sim.getPixel(1, 1));
        assertThat(didMove5).isFalse();
        
        setAllToWhite();
        sim.getPixel(0, 0).setColor(Color.ORANGE);
        sim.getPixel(2, 1).setColor(Color.ORANGE);
        sim.getPixel(2, 2).setColor(Color.ORANGE);
        sim.getPixel(1, 0).setColor(Color.BLUE);
        sim.getPixel(0, 1).setColor(Color.BLUE);
        
        boolean didMove6 = sim.maybeRelocate(sim.getPixel(0, 0));
        assertThat(sim.getPixel(0, 0).getColor()).isEqualTo(Color.WHITE);
        int num = 0;
        for (Pixel pix : sim.getPixels())
        {
            if (pix.getColor().equals(Color.ORANGE))
            {
                num++;
            }
        }
        assertThat(num).isEqualTo(3);
    }
    
    /**
     * A blue agent will at (0, 0) will be surrounded by three 
     * orange agents, it should relocate once
     */
    public void testCycleAgents()
    {
        sim.getPixel(0, 0).setColor(Color.BLUE);
        sim.getPixel(0, 1).setColor(Color.ORANGE);
        sim.getPixel(1, 0).setColor(Color.ORANGE);

        assertThat(sim.isSatisfied(sim.getPixel(0, 0), Color.BLUE)).isFalse();
        
        assertThat(sim.maybeRelocate(sim.getPixel(0, 0))).isFalse();
        
        int num = sim.cycleAgents();
        assertThat(num).isEqualTo(0);
        
        setAllToWhite();  
        sim.getPixel(1, 1).setColor(Color.BLUE);
        num = sim.cycleAgents();
        assertThat(num).isEqualTo(0);
        
        setAllToWhite();
        sim.getPixel(0, 0).setColor(Color.ORANGE);
        sim.getPixel(2, 0).setColor(Color.ORANGE);
        sim.getPixel(2, 1).setColor(Color.ORANGE);
        sim.getPixel(0, 2).setColor(Color.ORANGE);
        sim.getPixel(1, 2).setColor(Color.ORANGE);
        sim.getPixel(1, 0).setColor(Color.BLUE);
        sim.getPixel(0, 1).setColor(Color.BLUE);
        sim.getPixel(1, 1).setColor(Color.BLUE);
        
        num = sim.cycleAgents();
        assertThat(num).isEqualTo(2);
    }
    
    /**
     * Test if the helper method is working as expectation
     */
    public void testIsSatisfiedHelperOne()
    {
        Pixel pix = sim.getPixel(0, 0);
        pix.setColor(Color.BLUE);
        
        double num = sim.isSatisfiedHelperOne(pix, Color.BLUE, 6);
        assertThat(num).isEqualTo(7);
    }
    
    /**
     * Test if the helper method is working as expected
     */
    public void testIsSatisfiedHelperTwo()
    {
        Pixel pix = sim.getPixel(0, 0);
        pix.setColor(Color.BLUE);
        
        double num = sim.isSatisfiedHelperTwo(pix, Color.ORANGE, 6);
        assertThat(num).isEqualTo(7);
    }
    
    /**
     * Call the method and pass two neighbor pixels
     * to test if it will return true
     */
    public void testAreNeighbors()
    {
        Pixel pix1 = sim.getPixel(0, 0);
        Pixel pix2 = sim.getPixel(1, 0);
        Pixel pix3 = sim.getPixel(2, 0);
        Pixel pix4 = sim.getPixel(0, 1);
        Pixel pix5 = sim.getPixel(1, 1);
        Pixel pix6 = sim.getPixel(2, 1);
        Pixel pix7 = sim.getPixel(0, 2);
        Pixel pix8 = sim.getPixel(1, 2);
        Pixel pix9 = sim.getPixel(2, 2);
        
        //related to west
        assertThat(sim.areNeighbors(pix1, pix5)).isEqualTo(true);
        assertThat(sim.areNeighbors(pix4, pix5)).isEqualTo(true);
        assertThat(sim.areNeighbors(pix7, pix5)).isEqualTo(true);
        
        //north & south
        assertThat(sim.areNeighbors(pix2, pix5)).isEqualTo(true);
        assertThat(sim.areNeighbors(pix8, pix5)).isEqualTo(true);
        
        //related to east
        assertThat(sim.areNeighbors(pix3, pix5)).isEqualTo(true);
        assertThat(sim.areNeighbors(pix6, pix5)).isEqualTo(true);
        assertThat(sim.areNeighbors(pix9, pix5)).isEqualTo(true);
    }
    
    /**
     * Test if the given number is a fraction
     */
    public void testIsFraction()
    {
        assertThat(sim.isFraction(6666.6666)).isTrue();
        assertThat(sim.isFraction(6666)).isFalse();
    }
    
    /**
     * Test if the given number belongs to ten's place
     */
    public void testIsTensPlace()
    {
        assertThat(sim.isTensPlace(12, 26)).isFalse();
        assertThat(sim.isTensPlace(1, 22)).isTrue();
        assertThat(sim.isTensPlace(1, 2)).isTrue(); 
        assertThat(sim.isTensPlace(22, 2)).isTrue();         
    }
    
    /**
     * Sets all the pixels to white
     */
    public void setAllToWhite()
    {
        for (Pixel pix : sim.getPixels())
        {
            pix.setColor(Color.WHITE);
        }
    }
    
    /**
     * If the pixel is orange, test if it is below the redLine
     */
    public void testIsBelowRedLine()
    {
        sim.setRedLine(1);
        boolean isBelow = sim.isBelowRedLine(0, Color.ORANGE);
        assertThat(isBelow).isFalse();
    }
    
    /**
     * Pass two same pixels and return true
     */
    public void testIsThePixel()
    {
        Pixel pix = sim.getPixel(0, 0);
        boolean same = sim.isThePixel(pix, 0, 0);
        assertThat(same).isTrue();
    }
}
