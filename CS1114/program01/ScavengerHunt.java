// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
/**
 *  It is the sub class of LongIsland
 *  Adds Jeroo to the island and calls myProgram()
 *  to do the job
 *  @author Siliang Zhang (906467527)
 *  @version 2021.08.31
 */
public class ScavengerHunt
        extends LongIsland
{
    /**
     * Initializes a newly created ScavengerHunt object.
     */
    public ScavengerHunt()
    {
        super();
        /*# Do any work to initialize your class here. */
    }
    
    /**
     * Creates and adds a Jeroo object to the island
     */
    public void myProgram()
    {
        Scavenger myJeroo = new Scavenger();
        this.addObject(myJeroo, 2, 1);
        myJeroo.collectFlowers();
    }
}
