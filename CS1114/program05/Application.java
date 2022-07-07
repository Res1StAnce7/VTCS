import student.media.*;
import java.awt.Color;

//-------------------------------------------------------------------------
/**
 *  An application launcher for running your simulation to see what
 *  happens. Edit the code below to set your simuation size and speed
 *  (by specifying a delay to use). Use the setter methods below to
 *  customize the satisfaction threshold and redline values for your
 *  simulation.
 *
 *  @author Stephen Edwards
 *  @version 2021.09.29
 */
public class Application
    extends Program05ApplicationBase
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Run an instance of your simulation.
     */
    public Application()
    {
        // Size of your simulation
        int width = 200;
        int height = 200;

        // delay between frames of the animation:
        // use a larger number for slower steps, or a smaller
        // number for faster steps.
        // 300 == 0.300 seconds between frames
        int delay = 300;
        
        // Total number of cycles to animate
        int totalCycles = 100;
        
        // Note: This WILL NOT COMPILE until you create your
        // SchellingSimulation class and have something that supports
        // the basic operations
        
        SchellingSimulation simulation =
            new SchellingSimulation(width, height);
        
        // Set the satisfaction threshold, if desired
        // simulation.setSatisfactionThreshold(0.3);

        // Set the redline, if desired (based on height)
        // simulation.setRedLine(100);
        
        // Pick you proportions of agents
        simulation.populate(0.30, 0.30);

        // Animate your simulation
        runSimulation(simulation, delay, totalCycles);
    }
}
