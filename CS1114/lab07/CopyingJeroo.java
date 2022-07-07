// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (90646527)
import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  A Jeroo that walks every cell in on an island and uses delegation
 *  to instruct a second jeroo to follow its motions and plant a flower
 *  anywhere it finds one.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.07
 */
public class CopyingJeroo
    extends Jeroo
{
    //~ Fields ................................................................
    private Jeroo copier;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created CopyingJeroo object.
     * @param jeroo the jeroo object
     */
    public CopyingJeroo(Jeroo jeroo)
    {
        super();
        copier = jeroo;
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Walk a pattern over every grid location on the current island.
     */
    public void walkIsland()
    {
        boolean turnTo = false;
        while (!isAtEndPoint())
        {
            hopToWater();
            plantIfSeesFlower();
            
            if (!turnTo)
            {
                
                this.turn(RIGHT);
                this.hop();
                this.turn(RIGHT);
            }
            else 
            {
                this.turn(LEFT);
                if (!isAtEndPoint())
                {
                    this.hop();
                    this.turn(LEFT);
                }  
            }
            
            if (!turnTo)
            {
                turnTo = true;
            }
            else
            {
                turnTo = false;
            }
        }
    }

    /**
     * Hop forward until we reach the water.
     */
    public void hopToWater()
    {
        while (!this.seesWater(AHEAD))
        {
            plantIfSeesFlower();
            this.hop();
        }
    }
    
    /**
     * Check if Jeroo is at the end point
     * @return if the Jeroo is at the end point return true
     */
    public boolean isAtEndPoint()
    {
        return (this.getX() == 1 && this.getY() == 8);
    }
    
    /**
     * Override the hop() method so that
     * both Jerooes will hop
     */
    public void hop()
    {
        super.hop();
        copier.hop();
    }
    
    /**
     * Override the turn() method so that
     * both Jerooes will turn 
     * @param direction the direction to turn to
     */
    public void turn(RelativeDirection direction)
    {
        super.turn(direction);
        copier.turn(direction);
    }
    
    /**
     * The copier will plant if the master sees a flower HERE
     */
    public void plantIfSeesFlower()
    {
        if (this.seesFlower(HERE))
        {
            copier.plant();
        }
    }
    
}
