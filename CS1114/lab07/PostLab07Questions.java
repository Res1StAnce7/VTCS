//-------------------------------------------------------------------------
/**
 *  Post-lab questions for you to answer. Be sure to fill in the next
 *  two lines with your information.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.07
 */
public interface PostLab07Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: In the overridden hop method, what method do you
     * call to make the CopyingJeroo object hop?
     * 
     * A: super()
     * B: this.move()
     * C: super.hop()
     * D: this.hop()
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "C";


    // ----------------------------------------------------------
    /**
     * Question 2: Consider your lab assignment when reviewing the
     * following code that will be placed in the CopyingJeroo class:
     * 
     * public void atFlower()
     * {
     *     if (this.seesFlower(HERE))
     *     {
     *         copier.plant();
     *         this.pick();
     *      }
     *  }
     * 
     * What would happen if this code was integrated in your solution?
     * 
     * A: The image would be removed from both islands.
     * B: The image would be present on both islands.
     * C: The image would only be on the first island.
     * D: The image would be created on the second island and
     *    removed from the first island.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "D";


    // ----------------------------------------------------------
    /**
     * Question 3: Consider the following fields in the
     * CopyingJerooTest class:
     * 
     *     private Island island;
     *     public Jeroo copier;
     *     private CopyingJeroo jeroo;
     * 
     * Which fields can be accessed within the CopyingJerooTest class?
     * 
     * A: copier
     * B: island and jeroo
     * C: All of the fields can be accessed
     * D: None of the fields can be accessed
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "C";

 
    // ----------------------------------------------------------
    /**
     * Question 4: Consider the following information:
     * 
     * A CopyingJeroo object is at (1, 1) and is facing east. The
     * associated Jeroo object is at (10, 1) and is facing south.
     * If the CopyingJeroo hops two times, what will the location
     * of the Jeroo object be?
     * 
     * A: (1, 3)
     * B: (3, 10)
     * C: (10, 3)
     * D: (3, 1)
     * 
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "C";

 
    // ----------------------------------------------------------
    /**
     * Question 5: What does delegation mean?
     * 
     * A: Delegation means the object's methods are split into
     *    simple functions.
     * B: Delegation means an object creates another object.
     * C: Delegation means an object uses another object to
     *    perform an action.
     * D: Delegation means the object contains methods for a
     *    variety of specific situations.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "C";
}
