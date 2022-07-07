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
 *  This is the test file of FlowerPicker.
 *  Summarize what your test objectives are.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.15
 */
public class FlowerPickerTest
      extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlowerPickerTest test object.
     */
    public FlowerPickerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    /**
     * Test the pickLine() method on flower patch A's northwest corner.
     */
    public void testPickLine()
    {
        Island island = new Lab04Island();
        Jeroo bobby = new Jeroo(2); // Created with two flowers
    island.addObject(bobby, 6, 6);
    bobby.plant();
    Jeroo jessica = new Jeroo(1); // Created with one flower
    island.addObject(jessica, 3, 3);
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
    
    /**
     * Test the pickLine() method on flower patch B's northwest corner.
     */
    public void testPickLineB()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 5);

        picker.pickLine();

        assertThat(picker.getX()).isEqualTo(5); 
        assertThat(picker.getY()).isEqualTo(5);
        assertThat(picker.isFacing(EAST)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(4);
        assertThat(island.countFlowers()).isEqualTo(38);
    }
    
    /**
     * Test the pickLine() method on flower patch C's northwest corner.
     */
    public void testPickLineC()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 6, 9);

        picker.pickLine();

        assertThat(picker.getX()).isEqualTo(7); 
        assertThat(picker.getY()).isEqualTo(9);
        assertThat(picker.isFacing(EAST)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(2);
        assertThat(island.countFlowers()).isEqualTo(40);
    }
    
    /**
     * Test the pickLine() method on flower patch D's northwest corner.
     */
    public void testPickLineD()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 9, 2);
        picker.turn(RIGHT);
        
        picker.pickLine();

        assertThat(picker.getX()).isEqualTo(9); 
        assertThat(picker.getY()).isEqualTo(5);
        assertThat(picker.isFacing(SOUTH)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(4);
        assertThat(island.countFlowers()).isEqualTo(38);
    }
    
    /**
     * Test the pickLine() method on flower patch E's northeast corner.
     */
    public void testPickLineE()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 10, 8);
        picker.turn(RIGHT);

        picker.pickLine();
        
        assertThat(picker.getX()).isEqualTo(10);
        assertThat(picker.getY()).isEqualTo(10);
        assertThat(picker.isFacing(SOUTH)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(3);
        assertThat(island.countFlowers()).isEqualTo(39);
    }
    
    /**
     * Test the turnAroundRight() method on flower patch A's northwest corner.
     */
    public void testTurnAroundRight()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 2);
        
        picker.turnAroundRight();
        assertThat(picker.getX()).isEqualTo(2);
        assertThat(picker.getY()).isEqualTo(3);
        assertThat(picker.isFacing(WEST)).isTrue();
        assertThat(island.countFlowers()).isEqualTo(42);
    }
    
    /**
     * Test thepick2Lines() method on flower patch A's northwest corner.
     */
    public void testPick2LinesA()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 2);
        
        picker.pick2Lines();
        
        assertThat(picker.getX()).isEqualTo(2);
        assertThat(picker.getY()).isEqualTo(3);
        assertThat(picker.isFacing(WEST)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(10);
        assertThat(island.countFlowers()).isEqualTo(32);
    }
    
    /**
     * Test thepick2Lines() method on flower patch B's northwest corner.
     */
    public void testPick2LinesB()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 7);
        
        picker.pick2Lines();
        
        assertThat(picker.getX()).isEqualTo(2);
        assertThat(picker.getY()).isEqualTo(8);
        assertThat(picker.isFacing(WEST)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(8);
        assertThat(island.countFlowers()).isEqualTo(34);
    }
    
    /**
     * Test thepick2Lines() method on flower patch D's northwest corner.
     */
    public void testPick2LinesD()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 8, 3);
        
        picker.pick2Lines();
        
        assertThat(picker.getX()).isEqualTo(8);
        assertThat(picker.getY()).isEqualTo(4);
        assertThat(picker.isFacing(WEST)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(4);
        assertThat(island.countFlowers()).isEqualTo(38);
    }
    
    /**
     * Test thepick2Lines() method on flower patch E's northwest corner.
     */
    public void testPick2LinesE()
    {
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 9, 8);
        
        picker.pick2Lines();
        
        assertThat(picker.getX()).isEqualTo(9);
        assertThat(picker.getY()).isEqualTo(9);
        assertThat(picker.isFacing(WEST)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(4);
        assertThat(island.countFlowers()).isEqualTo(38);
    }
}
