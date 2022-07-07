// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;
import java.util.*;

/**
 *  A remotely controllable jeroo that reads commands
 *  from a scanner and uses a map to translate words
 *  into commands.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.17
 */
public class InterpreterJeroo
    extends Jeroo
{
    private Map<String, Command> map;
    /**
     * Creates a new InterpreterJeroo object.
     */
    public InterpreterJeroo()
    {
        super();
        map = new HashMap<String, Command>();
        map.put("forward", new ForwardCommand(this));
        map.put("Forward", new ForwardCommand(this));
        map.put("left", new LeftCommand(this));
        map.put("Left", new LeftCommand(this));
        map.put("right", new RightCommand(this));
        map.put("Right", new RightCommand(this));
    }

    /**
     * Calls interpretCommand() repeatedly until there are no more
     * words left in the given Scanner.
     * 
     * @param input The Scanner to read the command from.
     */
    public void interpretAllCommands(Scanner input)
    {
        while (input.hasNext())
        {
            interpretCommand(input);
        }
    }

    /**
     * Reads one word from the scanner (if there is any), and executes
     * the corresponding command.  If the scanner has no words remaining,
     * then nothing happens.
     * 
     * @param input The Scanner to read the command from.
     */
    public void interpretCommand(Scanner input)
    {
        String text = input.next();
        map.get(text).execute();
    }
}
