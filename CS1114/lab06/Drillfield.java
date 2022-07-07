import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A scenic picture of the Virginia Tech drillfield.
 *
 *  @author Stephen Edwards
 *  @version 2021.09.26
 */
public class Drillfield
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Drillfield picture.
     */
    public Drillfield()
    {
        super("drillfield.png");
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
        customized.maxRed();
        
        // display it on the screen
        customized.explore();
    }
}
