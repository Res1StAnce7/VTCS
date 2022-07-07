import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;

//-------------------------------------------------------------------------
/**
 *  An island with a fixed layout that can be used as a testing
 *  ground for individual MazeRunner methods.
 *
 *  @author Stephen Edwards
 *  @version 2021.09.12
 */
public class TestingIsland
    extends Island
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created TestingIsland object.
     */
    public TestingIsland()
    {
        super(12, 9);
        
        addObject(new Water(), 2, 2);
        addObject(new Water(), 3, 2);
        addObject(new Water(), 4, 2);
        addObject(new Water(), 4, 1);

        addObject(new Water(), 2, 4);
        addObject(new Water(), 3, 4);
        addObject(new Water(), 4, 4);
        addObject(new Water(), 2, 5);
        addObject(new Water(), 2, 6);
        addObject(new Water(), 3, 6);
        addObject(new Water(), 4, 6);
        addObject(new Water(), 5, 6);

        addObject(new Water(), 6, 1);
        addObject(new Water(), 6, 2);
        addObject(new Water(), 8, 1);
        addObject(new Water(), 8, 2);
        addObject(new Water(), 9, 2);

        addObject(new Water(), 6, 4);
        addObject(new Water(), 7, 4);
        addObject(new Water(), 9, 4);
        addObject(new Water(), 9, 5);

        addObject(new Water(), 6, 5);
        addObject(new Water(), 6, 6);
        addObject(new Water(), 6, 7);
        addObject(new Water(), 7, 6);
        addObject(new Water(), 9, 6);
        addObject(new Water(), 10, 6);
    }
}
