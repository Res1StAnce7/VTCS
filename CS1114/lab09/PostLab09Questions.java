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
 *  @version 2021.10.19
 */
public interface PostLab09Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: How do you remove a flower from the island inside
     * your Jeroo subclass?
     * 
     * A: this.remove(flower);
     * B: flower.pick();
     * C: this.pick(flower);
     * D: flower.remove();
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "D";


    // ----------------------------------------------------------
    /**
     * Question 2: When you add a flower to the end of the basket,
     * what code do you use?
     * 
     * 
     * A: list.add(flower);
     * B: basket.append(flower);
     * C: list.add(flower, 10);
     * D: basket.add(flower);
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "D";


    // ----------------------------------------------------------
    /**
     * Question 3: In your tests, is it sufficient to check only the
     * size of the list of flowers, or do you need to check each
     * individual flower in turn?
     * 
     * A: Yes, because the contents of the list do not matter.
     * B: No, you need to check each flower in the list to confirm it
     *    came from the correct island.
     * C: Yes, because the list is generic, and cannot contain anything
     *    except flowers because of the generic type parameter.
     * D: No, you need to check each flower in the list to make sure
     *    it is no longer on the island.
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "C";

 
    // ----------------------------------------------------------
    /**
     * Question 4: The correct expression for determining the number
     * of items in a list is:
     * 
     * A: basket.size()
     * B: basket.length
     * C: basket.count()
     * D: basket.length()
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "A";

 
    // ----------------------------------------------------------
    /**
     * Question 5: The number of flowers a FlowerCollector can hold
     * in its basket is:
     * 
     * A: 1
     * B: 10
     * C: 25, because that is the maximum number of flowers that will
     *    fit on the island
     * D: Unlimited, because the list will grow to hold as many items
     *    as needed
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "D";
}
