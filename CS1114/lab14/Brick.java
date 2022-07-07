// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
// -------------------------------------------------------------------------
/**
 *  Models a simple brick.
 *  This class is a part of an application for a company producing bricks.
 *  Bricks are delivered in palettes (stacks of bricks).
 * 
 *  There are (at least) four errors in this project. Find them. Fix them.
 *
 * @author Michael Kolling
 * @version 2002.02.08
 */
public class Brick
{
    //~ Instance/static variables .............................................

    // instance variables:
    private int height;
    private int width;
    private int depth;

    // Constant: weight per cubic cm in grams
    private static final int WEIGHT_PER_CM3 = 2;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a Brick. Parameters are edge lengths.
     * @param height in centimeters
     * @param width  in centimeters
     * @param depth  in centimeters
     */
    public Brick(int height, int width, int depth)
    {
        this.height = height;
        this.width  = width;
        this.depth  = depth;
    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get this brick's surface area.
     * @return the surface area in square centimeters
     */
    public double getSurfaceArea()
    {
        double side1 = this.width * this.height;
        double side2 = this.width * this.depth;
        double side3 = this.depth * this.height;
        double total = (side1 + side2 + side3) * 2;

        return total;
    }

    // ----------------------------------------------------------
    /**
     * Get this brick's weight.
     * @return the weight in kg.
     */
    public double getWeight()
    {
        return (getVolume() * this.WEIGHT_PER_CM3) 
               / (double)1000;
    }

    // ----------------------------------------------------------
    /**
     * Get this brick's volume.
     * @return the volume in qubic centimeters
     */
    public double getVolume()
    {
        return this.width * this.height * this.depth;
    }
    
    /**
     * Get this brick's height
     * @return the height in qubic centimeters
     */
    public double getHeight()
    {
        return this.height;
    }
}
