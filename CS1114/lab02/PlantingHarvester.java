
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  It is the another subclass of Harvester
 *  It will implement the third Jeroo to do the job
 *  @author Siliang Zhang (906467527)
 *  @version 2021.08.31
 */
public class PlantingHarvester
    extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created PlantingHarvester object.
     */
    public PlantingHarvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }

    public void hop2AndPick()
    {
        hopAndPick();
        hop();
        plant();
    }
    //~ Methods ...............................................................


}
