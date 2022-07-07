// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.*;
import student.micro.jeroo.*;
import java.util.Scanner;
import student.IOHelper;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;

/**
 *  Tests for the RemoteJeroo class.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.10
 */
public class RemoteJerooTest
    extends TestCase
{
    private RemoteJeroo jeroo;

    /**
     * Creates a new RemoteJerooTest test object.
     */
    public RemoteJerooTest()
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
        //empty
    }

    /**
     * Test RemoteJeroo with a scanner containing three "forward" commands.
     */
    public void testForward()
    {
        Island island = new Island();
        jeroo = new RemoteJeroo();
        island.addObject(jeroo, 3, 3);
        // Set the built-in scanner's contents
        setIn("forward forward forward");
        
        // Could provide multiple lines to setIn(), which has the
        // same effect as if each string included a line terminator at
        // the end:
        setIn(
            "forward",
            "forward",
            "forward");

        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(6);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing three "forward" commands.
     */
    public void testLeft()
    {
        Island island = new Island();
        jeroo = new RemoteJeroo();
        island.addObject(jeroo, 3, 3);
        setIn("left left left");
        jeroo.interpretAllCommands(in());
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
        jeroo = new RemoteJeroo();
        island.addObject(jeroo, 3, 3);
        setIn("right right right");
        jeroo.interpretAllCommands(in());
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(NORTH)).isTrue();
    }
    
    /**
     * Jeroo should follow the command in the URL
     */
    public void testJeroo()
    {
        Island island = new Island();
        jeroo = new RemoteJeroo();
        island.addObject(jeroo, 3, 3);
        Scanner input = IOHelper.createScannerForURL(
            "https://courses.cs.vt.edu/~cs1114/Fall2021/jeroo-commands.txt");

        jeroo.interpretAllCommands(input);
        assertThat(jeroo.getX()).isEqualTo(8);
        assertThat(jeroo.getY()).isEqualTo(9);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
}
