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

/**
 *  Tests for the InterpreterJeroo class.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.17
 */
public class InterpreterJerooTest
    extends TestCase
{
    private InterpreterJeroo jeroo;

    /**
     * Creates a new InterpreterJerooTest test object.
     */
    public InterpreterJerooTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        jeroo = new InterpreterJeroo();
    }

    /**
     * Test RemoteJeroo with a scanner containing three "forward" commands.
     */
    public void testForward()
    {
        Island island = new Island();
        island.addObject(jeroo, 3, 3);
        // Set the built-in scanner's contents
        setIn("forward forward forward");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(6);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing three "left" commands.
     */
    public void testLeft()
    {
        Island island = new Island();
        island.addObject(jeroo, 3, 3);
        // Set the built-in scanner's contents
        setIn("Left Left Left");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(SOUTH)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing three "right" commands.
     */
    public void testRight()
    {
        Island island = new Island();
        island.addObject(jeroo, 3, 3);
        // Set the built-in scanner's contents
        setIn("right right Right");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(NORTH)).isTrue();
    }
}
