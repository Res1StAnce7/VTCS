
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  It is the subclass of Harvest
 *  It will implement the second Jeroo to harvest flowers
 *  @author Siliang Zhang (906467527)
 *  @version 2021.08.31
 */
public class SkippingHarvester
    extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created SkippingHarvester object.
     */
    public SkippingHarvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }
    
    public void hop2AndPick()
    {
        hopAndPick();
        hop();
    }

    //~ Methods ...............................................................


}
