
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  This class is the subclass of Jeroo
 *  It will be able to harvest flowers
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.08.31
 */
public class Harvester
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Harvester object.
     */
    public Harvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }

    public void hopAndPick()
    {
        hop();
        pick();
    }
    
    public void hop2AndPick()
    {
        hopAndPick();
        hopAndPick();
    }
    
    public void harvestRow()
    {
        hop2AndPick();
        hop2AndPick();
        hop2AndPick();
    }
    
    
    //~ Methods ...............................................................


}
