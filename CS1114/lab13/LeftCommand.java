// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;
import static student.micro.jeroo.RelativeDirection.*;

/**
 *  Make Jeroo turn left.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.17
 */
public class LeftCommand
    implements Command
{
    private Jeroo jeroo;
    
    /**
     * Initializes a newly created LeftCommand object.
     * @param tempJeroo The Jeroo.
     */
    public LeftCommand(Jeroo tempJeroo)
    {
        super();
        this.jeroo = tempJeroo;
    }
    
    /**
     * The turn-left command.
     */
    public void execute()
    {
        this.jeroo.turn(LEFT);
    }
}
