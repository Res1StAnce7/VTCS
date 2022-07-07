// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;
import java.util.Scanner;

/**
 *  A remotely controllable jeroo that reads commands
 *  from a scanner and carries out the corresponding actions
 *  one at a time.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.10
 */
public class RemoteJeroo
    extends Jeroo
{
    /**
     * Creates a new RemoteJeroo object.
     */
    public RemoteJeroo()
    {
        super();
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
        String word = input.next();
        System.out.println(word);
        if (word.equals("forward"))
        {
            forward();
        }
        else if (word.equals("left"))
        {
            left();
        }
        else
        {
            right();
        }
    }

    /**
     * Moves the actor forward one square.
     */
    public void forward()
    {
        this.hop();
    }

    /**
     * Turns the actor left 90 degrees.
     */
    public void left()
    {
        this.turn(LEFT);
    }

    /**
     * Turns the actor right 90 degrees.
     */
    public void right()
    {
        this.turn(RIGHT);
    }
}
