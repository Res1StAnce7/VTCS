
import student.micro.lightbot.*;

//-------------------------------------------------------------------------
/**
 *  A simple level with a 3x3 square of blocks representing a tiny
 *  castle for the PatrolBot.
 *
 *  @author Stephen Edwards
 *  @version 2014.01.29
 */
public class Castle
    extends Level
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Castle object.
     */
    public Castle()
    {
        super();
        
        // set up the castle outline
        this.addObject(new Block(), 1, 2);
        this.addObject(new Block(), 2, 2);
        this.addObject(new Block(), 3, 2);
        this.addObject(new Block(), 3, 3);
        this.addObject(new Block(), 3, 4);
        this.addObject(new Block(), 2, 4);
        this.addObject(new Block(), 1, 4);
        this.addObject(new Block(), 1, 3);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Steps to execute when "Run" is pressed.
     */
    public void myProgram()
    {
        PatrolBot patroller = new PatrolBot();
        this.addObject(patroller, 0, 1);
 
        patroller.patrolCastle();
    }
}
