// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
// -------------------------------------------------------------------------
/**
 *  A pallet is a stack of bricks on a wooden base.
 *  This class is a part of an application for a company producing bricks.
 *  Bricks are delivered in pallets (stacks of bricks).  This class
 *  is supposed to provide methods telling its height and weight.
 *
 *  There are (at least) four errors in this project. Find them. Fix them.
 *
 * @author Michael Kolling
 * @version 2002.02.08
 */
public class Pallet
{
    //~ Instance/static variables .............................................
    private Brick aBrick;
    private int   bricksInPlane;
    private int   height;
    
    // constants:
    private static final double BASE_WEIGHT = 6.5;  // in kg
    private static final double BASE_HEIGHT = 15;   // in cm


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a pallet with a given number of bricks.
     * @param bricksInPlane  is the number of bricks in each level on the
     *                       base
     * @param height         is the number of bricks stacked on top of each
     *                       other
     */
    public Pallet(int bricksInPlane, int height)
    {
        aBrick = new Brick(8, 20, 12);
        this.bricksInPlane = bricksInPlane;
        this.height        = height;
    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get the weight of this palette.
     * @return the weight of the palette (in kg)
     */
    public double getWeight()
    {
        int numberOfBricks = this.bricksInPlane * this.height;
        return aBrick.getWeight() * numberOfBricks
               + this.BASE_WEIGHT;
    }

    // ----------------------------------------------------------
    /**
     * Get the height of this palette.
     * @return the height of this stack (in cm)
     */
    public double getHeight()
    {
        return (aBrick.getHeight() * this.height)
                + this.BASE_HEIGHT;
    }
}
