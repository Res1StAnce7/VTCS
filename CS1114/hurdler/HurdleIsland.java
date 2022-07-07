import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  An example island for showing how to write unit tests.
 *
 *  @author Stephen Edwards
 *  @version 2021.09.12
 */
public class HurdleIsland
    extends Island
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created HurdleIsland object.
     */
    public HurdleIsland()
    {
        super();
        
        this.addObject(new Flower(), 1, 10);
        this.addObject(new Flower(), 2, 10);
        this.addObject(new Flower(), 3, 10);
        this.addObject(new Flower(), 4, 10);
        this.addObject(new Flower(), 5, 10);
        this.addObject(new Flower(), 6, 10);
        this.addObject(new Flower(), 7, 10);
        this.addObject(new Flower(), 7, 9);
        this.addObject(new Flower(), 7, 8);
        this.addObject(new Flower(), 7, 7);
        this.addObject(new Flower(), 7, 6);
        this.addObject(new Flower(), 7, 5);
        this.addObject(new Flower(), 7, 4);
        this.addObject(new Flower(), 8, 4);
        this.addObject(new Flower(), 9, 4);
        this.addObject(new Flower(), 10, 4);
        this.addObject(new Flower(), 10, 5);
        this.addObject(new Flower(), 10, 6);
        this.addObject(new Flower(), 10, 7);
        this.addObject(new Flower(), 10, 8);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public void myProgram()
    {
        Hurdler rosa = new Hurdler();
        this.addObject(rosa, 1, 10);
        
        rosa.myProgram();
    }
}
