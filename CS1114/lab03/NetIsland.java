import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 * It is source code file of the island
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.07
 */
public class NetIsland
    extends NetIslandBase
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created NetIsland object.
     */
    public NetIsland()
    {
        super();
    }
    
    /**
     * Create, add Jeroo to the island
     * and pick up flowers and disable nets
     */
    public void myProgram()
    {
        NetRemover remover = new NetRemover();
        this.addObject(remover, 3, 1);
        remover.pickFlowersAndDisableNets();
    }
}
