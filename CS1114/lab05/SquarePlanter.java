// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
//-------------------------------------------------------------------------
/**
 *  It is a subclass of Jeroo
 *  It will create a K+1 by K+1 square 
 *  on the island by planting K flowers
 *  on each side
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.21
 */
public class SquarePlanter
    extends Jeroo
{
    //~ Fields ................................................................
    private int flowers;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created flowerPerSide object.
     * @param flowerPerSide the value needed to call the constructor
     */
    public SquarePlanter(int flowerPerSide)
    {
        super(4 * flowerPerSide);
        flowers = flowerPerSide;
        
        /*# Do any work to initialize your class here. */
    }
    
    //~ Methods ...............................................................
    /**
     * It will make a square by planting 
     * K flowers on each side
     */
    public void plantSquare()
    {
        for (int i = 0; i < 4; i++)
        {
            plantOneSide();
            this.turn(RIGHT);
        }
    }
    
    /**
     * It will plant certain numbers of flowers
     * on each side
     */
    public void plantOneSide()
    {
        int temp = flowers;
        while (temp > 0)
        {
            this.plant();
            this.hop();
            temp--;
        }
    }
}
