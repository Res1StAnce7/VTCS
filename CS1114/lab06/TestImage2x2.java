import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A simple 2x2 image with a solid color filling all pixels.
 *  This class is useful for testing simple color transformations.
 *
 *  @author Stephen Edwards
 *  @version 2021.09.26
 */
public class TestImage2x2
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created TestImage2x2 object.
     */
    public TestImage2x2()
    {
        this(100);
    }


    // ----------------------------------------------------------
    /**
     * Initializes a newly created TestImage2x2 object.
     */
    public TestImage2x2(int colorValue)
    {
        super(2, 2);
        
        for (Pixel pix : this.getPixels())
        {
            pix.setRed(colorValue);
            pix.setGreen(colorValue);
            pix.setBlue(colorValue);
        }
    }
}
