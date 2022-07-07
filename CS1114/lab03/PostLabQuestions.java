//-------------------------------------------------------------------------
/**
 *  Post-lab questions for you to answer. Be sure to fill in the next
 *  two lines with your information.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.07
 */
public interface PostLabQuestions
{
    // ----------------------------------------------------------
    /**
     * Question 1: A while loop will continue to execute as long as... ?
     * 
     * A: the condition has a value
     * B: the condition remains true
     * C: the condition remains false
     * D: the condition doesn't have a value
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "B";


    // ----------------------------------------------------------
    /**
     * Question 2: Consider the following code: What happens if
     * there is water directly in front of the Jeroo?
     * 
     * if (this.seesWater(AHEAD))
     * {
     *     this.turn(RIGHT);
     * }
     * else
     * {
     *     this.turn(LEFT);
     * }
     * this.hop();
     * 
     * A: The jeroo will turn right and hop once.
     * B: The jeroo will turn left.
     * C: The jeroo will turn left and hop once.
     * D: The jeroo will turn right.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "A";


    // ----------------------------------------------------------
    /**
     * Question 3: Which of the following are valid conditional
     * statements?
     * 
     * A: if (this.isClear(AHEAD))
     * B: if (this.isFacing(NORTH))
     * C: if (this.seesNet(LEFT))
     * D: All of the statements are valid
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "D";

 
    // ----------------------------------------------------------
    /**
     * Question 4: What type of value is returned by the hasFlower()
     * method in the Jeroo class? 
     * 
     * A: String
     * B: void
     * C: int
     * D: boolean
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "D";

 
    // ----------------------------------------------------------
    /**
     * Question 5: Consider the following code for a NetRemover:
     * if there is a net to the left of the Jeroo while the Jeroo
     * is facing NORTH, what will the NetRemover object do?
     * 
     * if (this.isClear(LEFT))
     * {
     *     if (this.isFacing(NORTH))
     *     {
     *         this.hop();
     *     }
     *     else
     *     {
     *         this.turn(LEFT);
     *     }
     * }
     * this.pick();
     * 
     * A: It will pick a flower.
     * B: It will plant a flower.
     * C: It will hop forward and pick a flower.
     * D: It will turn left and pick a flower.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "A";
}
