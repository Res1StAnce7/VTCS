// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  It will create two islands
 *  which will initialize a random pattern of flowers
 *  on the left island
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.07
 */
public class DualIsland
    extends DualIslandBase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created DualIsland object.
     */
    public DualIsland()
    {
        this(true);
    }


    // ----------------------------------------------------------
    /**
     * Initializes a newly created DualIsland object.
     * @param random If true, use a random arrangement of flowers, instead of
     *        the default triangle shape.
     */
    public DualIsland(boolean random)
    {
        super(random);
    }


    //~ Methods ...............................................................

    public void myProgram()
    {
        Jeroo slave = new Jeroo(1000);
        this.addObject(slave, 10, 1);

        CopyingJeroo master = new CopyingJeroo(slave);
        this.addObject(master, 1, 1);

        master.walkIsland();
    }
}
