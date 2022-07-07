
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 * It is a subclass of Jeroo which will collect flowers
 * and disable all the nets
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.07
 */
public class NetRemover
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created NetRemover object 
     * and makes it face SOUTH
     */
    public NetRemover()
    {
        super();
          /*# Do any work to initialize your class here. */
    }

    /**
     * Pick and disable all the nets
     */
    public void pickFlowersAndDisableNets()
    {
        this.turn(RIGHT);
        int flowers = pickFlowersAndTurnAround();
        hopToOrigin(flowers);
        navigateToNets();
        autoDisable();
    }
    
    /**
     * Pick all the flowers and turn Jeroo around
     * @return flowers the amount of flowers Jeroo will pick
     */
    public int pickFlowersAndTurnAround()
    {
        int flowers = 0;
        while (this.seesFlower(AHEAD))
        {
            this.hop();
            this.pick();
            flowers++;
        }
        
        this.turn(RIGHT);
        this.turn(RIGHT);
        
        return flowers;
    }
    
    
    /**
     * Go back to the origin (3,1)
     * @param steps the steps Jeroo needs to hop back to the origin
     */
    public void hopToOrigin(int steps)
    {
        while (steps != 0)
        {
            this.hop();
            steps--;
        }
        
        this.turn(RIGHT);
    }
    
    /**
     * Find the nets
     */
    public void navigateToNets()
    {
        while (this.isClear(AHEAD) && !this.seesWater(AHEAD))
        {
            this.hop();
        }
    }
    
    /**
     * Disable as many nets as Jeroo can
     */
    public void autoDisable()
    {
        while (this.seesNet(AHEAD))
        {
            if (this.hasFlower())
            {
                this.toss();
                if (this.hasFlower())
                {
                    this.turn(RIGHT);
                    this.hop();
                    this.turn(LEFT);
                }
            }
        }
    }    
    
    //~ Methods ...............................................................
}
