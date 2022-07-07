// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.micro.jeroo.*;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  jeroos can pick flowers, keep them in their pocket 
 *  and carries where it places each flower it picks. 
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.19
 */
public class FlowerCollector
    extends Jeroo
{
    //~ Fields ................................................................
    private List<Flower> basket;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created FlowerCollector object.
     */
    public FlowerCollector()
    {
        super();
        basket = new ArrayList<Flower>();
    }

    //~ Methods ...............................................................
    /**
     * Walk the island and pick all the flowers
     */
    public void collectFlowers()
    {
        for (int y = 1 ; y <= this.getWorld().getHeight() - 2; y++)
        {
            for (int x = 1; x <= this.getWorld().getWidth() - 2; x++)
            {
                this.setLocation(x, y);
                this.pick();
            }
        }
 
    }
    
    /**
     * The getter method of the basket
     * @return the basket
     */
    public List<Flower> getBasket()
    {
        return this.basket;
    }
    
    /**
     * A new pick method
     */
    public void pick()
    {
        if (this.seesFlower(HERE))
        {
            Flower flower = this.getOneIntersectingObject(Flower.class);
            flower.remove();
            basket.add(flower);
        }
    }
}
