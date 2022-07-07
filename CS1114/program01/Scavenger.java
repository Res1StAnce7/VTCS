// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  It is the subclass of Jeroo
 *  It will controll the Jeroo to pick all the flowers and stop
 *  at the center
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.01
 */
public class Scavenger
    extends Jeroo
{
    /**
     * Initializes a newly created Scavenger object.
     */
    public Scavenger()
    {
        super(SOUTH);
        /*# Do any work to initialize your class here. */
    }
    
    
    /**
     * Collects all the flowers and stops at the center
     */
    public void collectFlowers()
    {
        hopAndLeft(3);
        hopAndLeft(3);
        hopAndPick(3, 3);
        hopAndLeft(5);
        hopAndRight(1);
        hopAndPick(3, 3);
        hopAndRight(1);
        hopAndRight(2);
        hopAndPick(1, 1);
        hopAndPick(3, 0);
        hopAndPick(2, 1);
        hopAndLeft(7);
        hopAndRight(1);
        hopAndPick(1, 1);
        hopAndPick(4, 1);
        hopAndLeft(4);
        hopAndPick(1, 0);
    }
    
    /**
     * Hops for n times then turns left
     * @param n hops for a certain times
     */
    public void hopAndLeft(int n)
    {
        this.hop(n);
        this.turn(LEFT);
    }
    
    /**
     * Hops for n times then turns right
     * @param n hops for a certain times
     */
    public void hopAndRight(int n)
    {
        this.hop(n);
        this.turn(RIGHT);
    }
    
    /**
     * Picks and turns around
     */
    public void pickAndUturn()
    {
        this.pick();
        this.turn(RIGHT);
        this.turn(RIGHT);
    }
    
    /**
     * Hops for n times, picks and turns to a certain direction
     * @param n hops for a certain times
     * @param direction turns to a certain direction
     */
    public void hopAndPick(int n, int direction)
    {
        if (direction == 1) 
        {
            this.hop(n);
            this.pick();
            this.turn(LEFT);
        } 
        else if (direction == 2) 
        { 
            this.hop(n);
            this.pick();
            this.turn(RIGHT);
        }
        else if (direction == 3) 
        {  
            this.hop(n);
            pickAndUturn();
        }
        else 
        {
            this.hop(n);
            this.pick();
        }
    }
    //~ Methods ...............................................................
}
