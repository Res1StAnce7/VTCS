// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A picture that supports basic color transformations for Lab 06.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.28
 */
public class TransformablePicture
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created TransformablePicture object as a copy
     * of another image.
     * @param original the picture object
     */
    public TransformablePicture(Picture original)
    {
        super(original);
    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Turns the red intensity of every pixel in this image up to
     * the maximum value.
     */
    public void maxRed()
    {
        for (Pixel pix : this.getPixels())
        {
            pix.setRed(255);
        }
    }
    
    /**
     * Turns the green intensity of every pixel in this image up to
     * the maximum value.
     */
    public void maxGreen()
    {
        for (Pixel pix : this.getPixels())
        {
            pix.setGreen(255);
        }
    }
    
    /**
     * Turns the blue intensity of every pixel in this image up to
     * the maximum value.
     */
    public void maxBlue()
    {
        for (Pixel pix : this.getPixels())
        {
            pix.setBlue(255);
        }
    }
    
    /**
     * Adds the specified amount to each of the red, green, 
     * and blue components of each pixel's color.
     * @param amount the amount of brightness
     */
    public void brighten(int amount)
    {
        for (Pixel pix : this.getPixels())
        {
            int currentRed = pix.getRed() + amount;
            int currentGreen = pix.getGreen() + amount;
            int currentBlue = pix.getBlue() + amount;
            
            pix.setRed(currentRed);
            pix.setGreen(currentGreen);
            pix.setBlue(currentBlue); 
        }
    }
}
