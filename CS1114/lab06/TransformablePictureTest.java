// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.*;
import student.media.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Unit tests for Transformable Picture in Lab 06.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.28
 */
public class TransformablePictureTest
    extends TestCase
{
    //~ Fields ................................................................

    private TransformablePicture image;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TransformablePictureTest test object.
     */
    public TransformablePictureTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        // Create a transformable picture for testing.
        // It contains a 2x2 test image where all pixels are (100, 100, 100).
        image = new TransformablePicture(new TestImage2x2());
    }


    // ----------------------------------------------------------
    /**
     * To test if the red component of all pixels
     * in the image is set to the max value
     */
    public void testMaxRed()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        image.maxRed();
        
        // 3. Check expected behavior
        
        // The test image is so small, we can check individual pixels
        assertThat(image.getPixel(0, 0).getRed()).isEqualTo(255);
        assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);

        // Or, since the image is the same color everywhere, we can
        // check all the pixels in a loop
        for (Pixel pix : image.getPixels())
        {
            assertThat(pix.getRed()).isEqualTo(255);
            assertThat(pix.getGreen()).isEqualTo(100);
            assertThat(pix.getBlue()).isEqualTo(100);
        }
    }
    
    /**
     * To test if the green component of all pixels
     * in the image is set to the max value
     */
    public void testMaxGreen()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        image.maxGreen();
        
        // 3. Check expected behavior
        
        // The test image is so small, we can check individual pixels
        assertThat(image.getPixel(0, 0).getRed()).isEqualTo(100);
        assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(255);
        assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);

        // Or, since the image is the same color everywhere, we can
        // check all the pixels in a loop
        for (Pixel pix : image.getPixels())
        {
            assertThat(pix.getRed()).isEqualTo(100);
            assertThat(pix.getGreen()).isEqualTo(255);
            assertThat(pix.getBlue()).isEqualTo(100);
        }
    }
    
    /**
     * To test if the blue component of all pixels
     * in the image is set to the max value
     */
    public void testMaxBlue()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        image.maxBlue();
        
        // 3. Check expected behavior
        
        // The test image is so small, we can check individual pixels
        assertThat(image.getPixel(0, 0).getRed()).isEqualTo(100);
        assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(255);

        // Or, since the image is the same color everywhere, we can
        // check all the pixels in a loop
        for (Pixel pix : image.getPixels())
        {
            assertThat(pix.getRed()).isEqualTo(100);
            assertThat(pix.getGreen()).isEqualTo(100);
            assertThat(pix.getBlue()).isEqualTo(255);
        }
    }
    
    /**
     * To test if the brightness of the image is increased
     * by 20
     */
    public void testBrighten()
    {
        image.brighten(20);
        
        for (Pixel pix : image.getPixels())
        {
            assertThat(pix.getRed()).isEqualTo(120);
            assertThat(pix.getGreen()).isEqualTo(120);
            assertThat(pix.getBlue()).isEqualTo(120);
        }
    }
}
