import student.micro.jeroo.*;
import student.util.Random;

//-------------------------------------------------------------------------
/**
 *  An island with either a fixed or random pattern of flowers for
 *  Lab 09.
 *
 *  @author Stephen Edwards
 *  @version 2021.09.12
 */
public class FlowerIsland
    extends Island
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created FlowerIsland object with a random
     * pattern of flowers.
     */
    public FlowerIsland()
    {
        this(7, 7, 0.4);
    }


    // ----------------------------------------------------------
    /**
     * Initializes a newly created FlowerIsland object of a specific
     * size with a fixed crosshatch pattern of flowers.
     * @param width   The width of the island
     *                (including the surrounding water).
     * @param height  The height of the island
     *                (including the surrounding water).
     */
    public FlowerIsland(int width, int height)
    {
        super(width, height);
        plantFixedFlowers();
    }


    // ----------------------------------------------------------
    /**
     * Initializes a newly created FlowerIsland object of a specific
     * size with a random arrangement of flowers.
     * @param width        The width of the island
     *                     (including the surrounding water).
     * @param height       The height of the island
     *                     (including the surrounding water).
     * @param probability  The chance than any individual cell will
     *                     contain a flower.
     */
    public FlowerIsland(int width, int height, double probability)
    {
        super(width, height);
        plantRandomFlowers(probability);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Plants a fixed crosshatch pattern of flowers on the island.
     */
    public void plantFixedFlowers()
    {
        for (int x = 1; x < this.getWidth() - 1; x++)
        {
            for (int y = 1; y < this.getHeight() - 1; y++)
            {
                // If (x + y) is an even number, plant a flower
                if ((x + y) % 2 == 0)
                {
                    this.addObject(new Flower(), x, y);
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Plants a random pattern of flowers on the island.
     * @param probability Chance that any given cell will contain a flower.
     */
    public void plantRandomFlowers(double probability)
    {
        Random generator = Random.generator();
        for (int x = 1; x < this.getWidth() - 1; x++)
        {
            for (int y = 1; y < this.getHeight() - 1; y++)
            {
                // If (x + y) is an even number, plant a flower
                if (generator.nextDouble() < probability)
                {
                    this.addObject(new Flower(), x, y);
                }
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * The main program to create your jeroo and place it on the island.
     */
    public void myProgram()
    {
        FlowerCollector jeroo = new FlowerCollector();
        this.addObject(jeroo, 1, 1);
        jeroo.collectFlowers();

    }
}
