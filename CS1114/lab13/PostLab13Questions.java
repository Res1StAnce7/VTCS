// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)

/**
 *  Post-lab questions for you to answer. Be sure to fill in the next
 *  two lines with your information.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.17
 */
public interface PostLab13Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: What alterations, if any, would you need to make
     * to your program if you added a method stub, void pick();, to
     * your Command interface?
     * 
     * A: All classes that implement the Command interface would
     *    need to add the pick() method.
     * B: The pick() method would need to be implemented in the
     *    Command interface.
     * C: The pick() method would need to be added to the
     *    ForwardCommand class.
     * D: No changes would need to be made.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "A";


    // ----------------------------------------------------------
    /**
     * Question 2: Assume your jeroo is located at (1, 5) facing East.
     * Assume its command map was initialized with the following mappings:
     * 
     * map.put("forward", new ForwardCommand(this));
     * map.put("starboard", new RightCommand(this));
     * map.put("port", new LeftCommand(this));
     * map.put("left", new ForwardCommand(this));
     * map.put("right", new ForwardCommand(this));
     * 
     * It is given a scanner containing the following information:
     * "right port forward starboard forward left". What will be
     * the final location of the jeroo if it interprets all the commands?
     * 
     * A: (3, 5)
     * B: (4, 4)
     * C: (2, 6)
     * D: (3, 6)
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "C";


    // ----------------------------------------------------------
    /**
     * Question 3: What is the syntactically correct way to declare
     * a method in an interface?
     * 
     * A: public void methodName();
     * B: private void methodName();
     * C: void methdName();
     * D: Both public void methodName(); and void methodName(); are
     *    syntactically correct.
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "D";

 
    // ----------------------------------------------------------
    /**
     * Question 4: Using the solution designed in your lab, what
     * is returned when map.get("forward") is called? Assume you
     * have a Map object named map populated with the key-value
     * pairs for the original three commands.
     * 
     * A: A ForwardCommand object
     * B: A RightCommand object
     * C: A LeftCommand object
     * D: A ReturnCommand object
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "A";

 
    // ----------------------------------------------------------
    /**
     * Question 5: What will this statement do?
     * 
     * map.put("return", new ReturnCommand());
     * 
     * Assume you have a Map object named map.
     * 
     * A: It will return the ReturnCommand object
     * B: It will add the String "return" to the hash map
     * C: It will remove the mapping from the hash map
     * D: It will map the String "return" to the provided
     *    ReturnCommand object
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "D";
}
