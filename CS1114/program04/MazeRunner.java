// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  It will make Jeroo walk the maze
 *  that pick all the flowers
 *  disable all the nets
 *  and go back to the starting position
 *  @author Siliang Zhang (906467527)
 *  @version 2021.09.19
 */
public class MazeRunner
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created MazeRunner object with 10 flowers.
     */
    public MazeRunner()
    {
        super(10);
        /*# Do any work to initialize your class here. */
    }
    
    /**
     * Collects all the flowers, disables all the nets, 
     * and returns to Jeroo's starting position (1, 1)
     */
    public void clearMaze()
    {
        if (this.seesWater(AHEAD))
        {
            this.turn(RIGHT);
        }
        
        if (this.seesFlower(HERE))
        {
            this.pick();
        }
        
        autoNavigate();  
    }
    
    /**
     * It will automatically naviagte Jeroo to pick all the flowers,
     * disable every nets, reach every position on the islands and
     * go back to the starting position (1, 1)
     */
    public void autoNavigate()
    {
        int origin = 0;
        boolean turnCheck = false;
        int directions = startCheck();
        
        while (origin != directions) 
        {
            turnCheck = autoNavigateHelper();
            
            if (!turnCheck)
            {
                if (this.seesWater(AHEAD) && this.seesWater(LEFT) 
                    && this.seesWater(RIGHT))
                {
                    turnAround();
                }
            
                else 
                {
                    this.turn(LEFT);
                }
            }
            
            origin += reachOrigin();
        } 
    }
    
    /**
     * The helper method designed for autoNavigate()
     * When there is no water ahead and no way right, 
     * it will call pickOrTossOrHop()
     * After that, if there is way right (stick to the right), 
     * it will make Jeroo turn right
     * @return It will return true if Jeroo has turned right
     * Otherwise it will return false to the main function
     * to let it decide whether Jeroo should turn left
     * or turn around
     */
    public boolean autoNavigateHelper()
    {
        while (!this.seesWater(AHEAD) && (!this.seesFlower(RIGHT) 
            || !this.seesNet(RIGHT) || !this.isClear(RIGHT)))
        {
            pickOrTossOrHop();
            
            if (this.seesFlower(RIGHT) || this.seesNet(RIGHT) 
                || this.isClear(RIGHT)) 
            {
                this.turn(RIGHT);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Makes Jeroo hop and pick once
     */
    public void hopAndPick()
    {
        this.hop();
        this.pick();
    }
    
    
    /**
     * Makes Jeroo turn Around
     */
    public void turnAround()
    {
        this.turn(RIGHT);
        this.turn(RIGHT);
    }
    
    /**
     * It is a helper method designed for pickAndHopAndDisable() 
     * which will make Jeroo hop and pick once, just toss, or just hop
     */
    public void pickOrTossOrHop()
    {
        if (this.seesFlower(AHEAD))
        {
            hopAndPick();
        }
        else if (this.seesNet(AHEAD))
        {
            this.toss();
        }
        else
        {
            this.hop();
        }
    }
    
    /**
     * Check if Jeroo reaches the origin
     * @return It will return 1 if Jeroo reach the origin. 
     * Otherwise, it will return 0
     */
    public int reachOrigin()
    {
        if (this.getX() == 1 && this.getY() == 1)
        {
            return 1;
        }
        
        return 0;
    }
    
    /**
     * Get the number of direction which there is no water in
     * @return If there are two directions (AHEAD & RIGHT), it will return 2
     * Otherwise, it will return 1
     */
    public int startCheck()
    {
        if (!this.seesWater(AHEAD) && !this.seesWater(RIGHT))
        {
            return 2;
        }
        
        else
        {
            return 1;
        }
    }
    //~ Methods ...............................................................
}
