import student.media.*;
import java.awt.Color;

//-------------------------------------------------------------------------
/**
 *  A simple image of a specified size with a solid color filling all pixels.
 *  This class is useful for testing simple color transformations.
 *
 *  @author Stephen Edwards
 *  @version 2021.10.08
 */
public class TestImage
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created TestImage object where all pixels
     * are (100, 100, 100).
     * 
     * @param width The width of the image
     * @param height The height of the image
     */
    public TestImage(int width, int height)
    {
        this(width, height, 100);
    }


    // ----------------------------------------------------------
    /**
     * Initializes a newly created TestImage object.
     * 
     * @param width The width of the image
     * @param height The height of the image
     * @param colorValue The color to paint all pixels
     */
    public TestImage(int width, int height, int colorValue)
    {
        super(width, height);
        this.setAllPixelsToAColor(
            new Color(colorValue, colorValue, colorValue));
    }
}
