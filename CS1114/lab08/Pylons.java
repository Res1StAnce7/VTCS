import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A scenic picture of the Virginia Tech pylons.
 *
 *  @author Stephen Edwards
 *  @version 2021.09.26
 */
public class Pylons
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Pylon picture.
     */
    public Pylons()
    {
        super("pylons.png");
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Displays a transformed version of this image.
     */
    public void transform()
    {
        TransformablePicture customized = new TransformablePicture(this);
        
        // Modify to include any transformation(s) you'd like to see
        // customized.radialShadow(10);
        // customized.radialGlow(20);
        customized.colorShift(16);
        
        // display it on the screen
        customized.explore();
    }
}
