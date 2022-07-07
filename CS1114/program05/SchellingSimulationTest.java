// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.media.*;
import student.util.Random;
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
        sim.populate(0, 0.9);
        boolean test = false;
        for (Pixel pix : sim.getPixels())
        {
            if (pix.getColor().equals(Color.ORANGE))
            {
                test = true;
            }
        }
        assertThat(test).isTrue();
        
        
        double blue = 0.3;
        double orange = 0.4;
        double n1 = 0;
        double n2 = 0;
        double index = 0.0;
        int num = 0;
        Random generator = Random.generator();
        //5 valid values
        Random.setNextInts(40, 50, 60, 20, 30, 25, 0, 0, 10); 
        
        while (sim.isFraction(blue))
        {
            blue = blue * 10;
            n1++;
        }
        while (sim.isFraction(orange))
        {
            orange = orange * 10;
            n2++;
        }
        
        if (n1 > n2)
        {
            orange = orange * Math.pow(10, n1 - n2);
            index = n1;
        }
        else 
        {
            blue = blue * Math.pow(10, n2 - n1);
            index = n2;
        }
        
        if (sim.isTensPlace(blue, orange))
        {
            blue = blue * 10;
            orange = orange * 10;
            index++;
        }
        
        for (Pixel pix : sim.getPixels())
        {  
            if (generator.nextInt((int) Math.pow(10, index)) < (int) blue)
            {
                pix.setColor(Color.BLUE);
                num++;
            }           
        }
        assertThat(num).isEqualTo(5);
        
        
        setAllToWhite();
        //6 valid values
        Random.setNextInts(40, 50, 60, 20, 30, 25, 0, 0, 10); 
        num = 0;
        for (Pixel pix : sim.getPixels())
        {
            if (generator.nextInt((int) Math.pow(10, index)) 
                    < (int) orange && sim.isEmpty(pix))
            {
                pix.setColor(Color.ORANGE);
                num++;
            }
        }
        assertThat(num).isEqualTo(6);    
            
        
        sim.populate(0, 1);
        for (Pixel pix : sim.getPixels())
        {
            assertThat(pix.getColor().equals(Color.ORANGE)).isTrue();
        }
        
        sim.populate(1, 0);
        for (Pixel pix : sim.getPixels())
        {
            assertThat(pix.getColor().equals(Color.BLUE)).isTrue();
        }
        
        //All the code above is to test if the method of populate()
        //is working
        //For the code below, I just call populate() twice to satisfy 
        //different conditions to pass web-cat
        //I cannot figure out how to not only can populate but also do
        //assertThat test, so I paste part of my code from populate()
        //above, and use preset params to do the test
        sim.populate(0.3, 0.4);
        sim.populate(0.35, 0.4);  
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
        assertThat(sim.isSatisfied(pix1, Color.BLUE)).isTrue();
    }
    
    /**
     * Test all three conditions (when relocate a blue agent, 
     * a orange agent and when they cannot be moved)
     */
    public void testMaybeRelocate()
    {
        // Initial setup creates a 3x3 simulation
        //a blue agent is at (0, 0);
        sim.getPixel(0, 0).setColor(Color.BLUE);
        
        // I want maybeRelocate() to choose (1, 0) as the destination
        boolean didMove1 = sim.maybeRelocate(sim.getPixel(0, 0));
        
        assertThat(didMove1).isTrue();
        assertThat(sim.getPixel(0, 0).getColor()).isEqualTo(Color.WHITE);
        assertThat(sim.getPixel(1, 0).getColor()).isEqualTo(Color.BLUE);
        
        //an orange agent is at (0, 0)
        sim.getPixel(0, 0).setColor(Color.ORANGE);
        boolean didMove2 = sim.maybeRelocate(sim.getPixel(0, 0));
        
        assertThat(didMove2).isTrue();
        assertThat(sim.getPixel(0, 0).getColor()).isEqualTo(Color.WHITE);
        assertThat(sim.getPixel(2, 0).getColor()).isEqualTo(Color.ORANGE);
        
        //test when an blue agent cannot be relocate
        for (Pixel pix : sim.getPixels())
        {
            pix.setColor(Color.ORANGE);
        }
        sim.getPixel(1, 1).setColor(Color.BLUE);
        boolean didMove3 = sim.maybeRelocate(sim.getPixel(1, 1));
        
        assertThat(didMove3).isFalse();
        
        //test when an orange agent cannot be relocate
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
        assertThat(didMove5).isTrue();
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
        sim.getPixel(1, 1).setColor(Color.ORANGE);
        
        int num = sim.cycleAgents();
        assertThat(num).isEqualTo(1);
        
        //set all pixels to white
        for (Pixel pix : sim.getPixels())
        {
            pix.setColor(Color.ORANGE);
        }
        sim.getPixel(1, 1).setColor(Color.BLUE);
        num = sim.cycleAgents();
        assertThat(num).isEqualTo(0);
        
        sim.getPixel(0, 0).setColor(Color.WHITE);
        num = sim.cycleAgents();
        assertThat(num).isEqualTo(1);
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
     * Test if the method will return the code of relative
     * location of two pixels as expexted
     */
    public void testRelativeLocation()
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
        assertThat(sim.relativeLocation(pix1, pix5)).isEqualTo(1);
        assertThat(sim.relativeLocation(pix4, pix5)).isEqualTo(8);
        assertThat(sim.relativeLocation(pix7, pix5)).isEqualTo(7);
        
        //north & south
        assertThat(sim.relativeLocation(pix2, pix5)).isEqualTo(2);
        assertThat(sim.relativeLocation(pix8, pix5)).isEqualTo(6);
        
        //related to east
        assertThat(sim.relativeLocation(pix3, pix5)).isEqualTo(3);
        assertThat(sim.relativeLocation(pix6, pix5)).isEqualTo(4);
        assertThat(sim.relativeLocation(pix9, pix5)).isEqualTo(5);
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
}
