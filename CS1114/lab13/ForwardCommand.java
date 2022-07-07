// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;

/**
 *  Make Jeroo move forward.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.17
 */
public class ForwardCommand 
    implements Command
    
{
    private Jeroo jeroo;

    /**
     * Initializes a newly created ForwardCommand object.
     * @param tempJeroo The Jeroo.
     */
    public ForwardCommand(Jeroo tempJeroo)
    {
        super();
        this.jeroo = tempJeroo;
    }

    /**
     * The forward command.
     */
    public void execute()
    {
        this.jeroo.hop();
    }
}
