// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
//-------------------------------------------------------------------------
/**
 *  Post-lab questions for you to answer. Be sure to fill in the next
 *  two lines with your information.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.28
 */
public interface PostLab06Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: What is the maximum intensity value for the color
     * components of a Pixel?
     * 
     * A: 100
     * B: 255
     * C: 1000
     * D: Integer.MAX_VALUE
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "B";


    // ----------------------------------------------------------
    /**
     * Question 2: Which RGB value below is closest to the color of
     * the pixel at (465, 115) in the Drillfield image? (Hint: use
     * explore() to find out; the actual color may be close to one
     * of those below, rather than identical)
     * 
     * A: (107, 118, 1)
     * B: (198, 163, 160)
     * C: (219, 223, 242)
     * D: (77, 86, 36)
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "D";


    // ----------------------------------------------------------
    /**
     * Question 3: Which of the following methods on the Picture class
     * will change the color of all pixels at once?
     * 
     * A: setGreen(int)
     * B: setAllBlue(int)
     * C: setColor(int, int, int)
     * D: None of the above: you use Pixel objects to change pixel colors
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "D";

 
    // ----------------------------------------------------------
    /**
     * Question 4: The reason for testing image methods using the
     * TestImage2x2 picture is: 
     * 
     * A: Using a controlled image makes it easy to know what to
     *    expect as the behavior from methods
     * B: Large, complex images require you to write large, complex
     *    test cases in order to check your methods
     * C: Smaller images are faster to process
     * D: All of the above
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "D";

 
    // ----------------------------------------------------------
    /**
     * Question 5: If a pixel in an image has the value (100, 100, 100)
     * and you execute maxRed(), followed by maxBlue(), followed by
     * maxGreen(), what color will the pixel have?
     * 
     * A: (255, 100, 100)
     * B: (100, 255, 100)
     * C: (100, 100, 255)
     * D: (255, 255, 255)
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "D";
}
