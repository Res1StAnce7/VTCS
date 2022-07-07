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
 *  @version 2021.10.12
 */
public interface PostLab08Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: Nested loops are called nested because:
     * 
     * A: We use the term "nest" to refer to the portion of the
     *    for loop where the "i++" appears
     * B: The curly braces around the loop body look like a mother
     *    bird's wings
     * C: Writing loop statements is called "nesting"
     * D: One loop appears inside the body (curly braces) of another
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "D";

    // ----------------------------------------------------------
    /**
     * Question 2: Which RGB value below is closest to the color of
     * the pixel at (608, 299) in the Pylons image? (Hint: use
     * explore() to find out; the actual color may be close to one
     * of those below, rather than identical)
     * 
     * A: (132, 117, 62)
     * B: (219, 232, 246)
     * C: (253, 229, 205)
     * D: (46, 83, 2)
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "C";

    // ----------------------------------------------------------
    /**
     * Question 3: Does checking the color of a pixel in a test case
     * require separate assertions for its red, green, and blue values?
     * 
     * A: Yes, the only way to check a pixel's color is by using its
     *    getRed(), getGreen(), and getBlue() accessors.
     * B: No, there are custom assertions that work only on Pixel objects
     *    for this purpose.
     * C: No, you can use a pixel's getColor() accessor to get a single
     *    color value that can be tested.
     * D: Yes, it is always more accurate to test the 3 color values
     *    separately.
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "C";

    // ----------------------------------------------------------
    /**
     * Question 4: The reason for testing image methods using the
     * 3x3 TestImage picture is: 
     * 
     * A: Using a controlled image makes it easy to know what to
     *    expect as the behavior from methods
     * B: Large, complex images require you to write large, complex
     *    test cases in order to check your methods
     * C: A 3x3 image allows testing different rate values, and includes
     *    pixels at multiple distances from each corner.
     * D: All of the above
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "D";
 
    // ----------------------------------------------------------
    /**
     * Question 5: Which of the following is NOT an advantage of using
     * a numeric for loop?
     * 
     * A: Numeric for loops execute faster and more efficiently than other
     *    types of loops.
     * B: Using a number to control the loop makes it easier to create
     *    loops that repeat a specific number of times.
     * C: The variable used in the loop allows you to refer to the
     *    number of the current iteration within your computations.
     * D: Numeric for loops give you 3 places to put the initialization,
     *    condition, and update step, so that you don't forget to include
     *    each one.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "A";
}
