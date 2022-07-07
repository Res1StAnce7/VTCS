import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  This class will be able to solve lab2
 *  It will manipulate Jeroo to do his job.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.08.31
 */
public class Lab02Solution
    extends PlantationIsland
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Lab02Solution object.
     */
    public Lab02Solution()
    {
        super();
        myProgram();        
    }
    
    public void myProgram()
    {
        Harvester myJeroo_0 = new Harvester();
        this.addObject(myJeroo_0, 2, 3);
        myJeroo_0.harvestRow();
        
        SkippingHarvester myJeroo_1 = new SkippingHarvester();
        this.addObject(myJeroo_1, 2, 5);
        myJeroo_1.harvestRow();
        
        PlantingHarvester myJeroo_2 = new PlantingHarvester();
        this.addObject(myJeroo_2, 2 ,7);
        myJeroo_2.harvestRow();
    }


    //~ Methods ...............................................................


}
