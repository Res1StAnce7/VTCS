// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A picture that supports basic color transformations for Lab 08
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.12
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
     * Adds a radial shadow that gets darker the farther a pixel is from
     * the upper left corner.
     * 
     * @param rate The speed at which the shadow gets darker, where
     *             a larger number produces a more gradual shadow
     */
    public void radialShadow(int rate)
    {
        for (int x = 0; x < this.getWidth(); x++)
        {
            for (int y = 0; y < this.getHeight(); y++)
            {
                int value = (x + y) / rate;
                Pixel pix = this.getPixel(x, y);
                adjustPixel(pix, -value);
            }
        }       
    }
    
    /**
     * Takes a pixel and a integer
     * then add centain amount of brightness to the pixel
     * @param pix the pixel object
     * @param num the value of brightness
     */
    public void adjustPixel(Pixel pix, int num)
    {
        pix.setRed(pix.getRed() + num);
        pix.setBlue(pix.getBlue() + num);
        pix.setGreen(pix.getGreen() + num);
    }

    /**
     * Adds a radial Glow that gets darker the farther a pixel is from
     * the lower right corner.
     * 
     * @param rate The speed at which the glow gets brigher, where
     *             a larger number produces a more gradual glow
     */
    public void radialGlow(int rate)
    {
        for (int x = 0; x < this.getWidth(); x++)
        {
            for (int y = 0; y < this.getHeight(); y++)
            {
                int value = ((this.getWidth() - x - 1) 
                    + (this.getHeight() - y - 1)) / rate;
                Pixel pix = this.getPixel(x, y);
                adjustPixel(pix, value);
            }
        }          
    }
    
    /**
     * Adds a radial Glow that gets darker the farther a red 
     * pixel is from the lower right corner.
     * Adds a radial shadow that gets darker the farther a blue 
     * pixel is from the upper left corner.
     * 
     * @param rate The speed at which the glow gets brigher, where
     *             a larger number produces a more gradual glow
     *             The speed at which the shadow gets darker, where
     *             a larger number produces a more gradual shawod
     */
    public void colorShift(int rate)
    {
        for (int x = 0; x < this.getWidth(); x++)
        {
            for (int y = 0; y < this.getHeight(); y++)
            {
                int value = ((this.getWidth() - x - 1) 
                    + (this.getHeight() - y - 1)) / rate;
                Pixel pix = this.getPixel(x, y);
                pix.setRed(pix.getRed() + value);
            }
        } 
        for (int x = 0; x < this.getWidth(); x++)
        {
            for (int y = 0; y < this.getHeight(); y++)
            {
                int value = (x + y) / rate;
                Pixel pix = this.getPixel(x, y);
                pix.setBlue(pix.getBlue() + value);
            }
        } 
    }
}
