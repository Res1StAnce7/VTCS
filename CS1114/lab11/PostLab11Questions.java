//-------------------------------------------------------------------------
/**
 *  Post-lab questions for you to answer. Be sure to fill in the next
 *  two lines with your information.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.03
 */
public interface PostLab11Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: For the following array, what are valid index
     * positions?
     * 
     * int[] numbers = new int[100];
     * 
     * A: 0-100
     * B: 1-100
     * C: 1-99
     * D: 0-99
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "D";


    // ----------------------------------------------------------
    /**
     * Question 2: Using the 2-Dimensional array created in this lab,
     * what reference is contained in events[0][0] if it has
     * never been assigned a value?
     * 
     * A: The integer value 0
     * B: Accessing that spot will produce a null pointer exception
     * C: null
     * D: A reference to a new Event object
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "C";


    // ----------------------------------------------------------
    /**
     * Question 3: What does the @Override annotation do?
     * 
     * A: It instructs the compiler to double-check the method declaration
     *    is correct.
     * B: It instructs the compiler to ignore other methods of the
     *    same name.
     * C: It only adds to readability; it performs no other functions
     *    beyond that.
     * D: It instructs the compiler to ignore calls to super.
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "A";

 
    // ----------------------------------------------------------
    /**
     * Question 4: Assume you have the following array:
     * 
     * int[] values = new int[15];
     * 
     * What will happen if the following code is executed?
     * 
     * int[15] = 20;
     * 
     * A: The array will grow in size by one and the value will be
     *    added to the array.
     * B: The value will be added to the array.
     * C: Nothing will happen.
     * D: You will get an ArrayIndexOutOfBoundsException.
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "D";

 
    // ----------------------------------------------------------
    /**
     * Question 5: Mutators and accessors can also be referred to
     * as what?
     * 
     * A: Setters and getters
     * B: Alters and admittors
     * C: Setters and admittors
     * D: Alters and getters
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "A";
}
