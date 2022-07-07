// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.media.*;
import student.util.Random;
import java.awt.Color;
//-------------------------------------------------------------------------
/**
 *  It represents an image that will model the neighborhood, 
 *  with each pixel representing a location 
 *  that is either occupied or empty
 *  
 *  @author Siliang Zhang (906467527)
 *  @version 2021.10.02
 */
public class SchellingSimulation
      extends Picture
{
    //~ Fields ................................................................
    private double satisfactionThreshold;
    private int redLine;  
    private int x;
    private int y;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created SchellingSimulation object.
     * @param width the width of the image
     * @param height the height of the image
     */
    public SchellingSimulation(int width, int height)
    {
        super(width, height);
        this.satisfactionThreshold = 0.3;
        this.redLine = 0;
        this.x = -1;
        this.y = -1;
    }
    
    //~ Methods ...............................................................
    /**
     * A getter method that returns the satisfaction threshold 
     * @return the value of satisfactionThreshold
     */ 
    public double getSatisfactionThreshold()
    {
        return this.satisfactionThreshold;
    }
    
    /**
     * A setter method that takes a double parameter and 
     * changes the satisfaction threshold to the specified value
     * @param temp the value of the satisfaction threshold
     */
    public void setSatisfactionThreshold(double temp)    
    {
        this.satisfactionThreshold = temp;
    }
    
    /**
     *     A getter method that returns the redline value     
     *     @return the value of this.redLine
     */
    public int getRedLine()
    {
        return this.redLine;
    }
    
    /**
     * A setter method that takes an integer parameter and 
     * changes the redline to the specified value.
     * @param temp the value of redLine
     */
    public void setRedLine(int temp)
    {
        this.redLine = temp;
    }
    
    /**
     * This method will "paint" the image 
     * with a randomized collection of blue and orange pixels.
     * @param blue the percentage of blue pixels
     * @param orange the percentage of orange pixels
     */
    public void populate(double blue, double orange)
    {
        if (blue != 1 && orange != 1)
        {
            Random generator = Random.generator();
            double num = 0.0;

            for (Pixel pix : this.getPixels())
            {
                num = generator.nextDouble();
                if (num < orange && pix.getY() >= this.redLine)
                {
                    pix.setColor(Color.ORANGE);
                }
            }
            blue = blue / (1 - orange);
            for (Pixel pix : this.getPixels())
            {
                num = generator.nextDouble();
                if (num < blue && pix.getColor().equals(Color.WHITE))
                {
                    pix.setColor(Color.BLUE);
                }
            }  
        }
        else if (blue == 1)
        {
            for (Pixel pix : this.getPixels())
            {
                pix.setColor(Color.BLUE);
            }
        }
        else
        {
            for (Pixel pix : this.getPixels())
            {
                if (pix.getY() >= this.redLine)
                {
                    pix.setColor(Color.ORANGE);
                }  
            }
        }
    }
    
    /**
     * Takes two Pixel objects and returns a boolean value 
     * indicating whether the two pixels have the same color.
     * @param pix1 an Pixel object to be compared
     * @param pix2 another Pixel object to be compared
     * @return the result of if two pixels have the same color
     */
    public boolean areSameColor(Pixel pix1, Pixel pix2)
    {
        return (pix1.getColor().equals(pix2.getColor()));
    }
    
    /**
     * Takes one Pixel object and returns true 
     * if its color is Color.WHITE, representing an empty location.
     * @param pix a Pixel object
     * @return the result of if the location is empty
     */ 
    public boolean isEmpty(Pixel pix)
    {
        return (pix.getColor().equals(Color.WHITE));
    }
    
    /**
     * Takes one Pixel object and a Color value, 
     * and returns a boolean result indicating 
     * whether an agent of the specified Color 
     * would be satisfied at the given Pixel location.
     * @param pix a Pixel object
     * @param value the color of the pixel
     * @return the result of if the color is satisfied
     */
    public boolean isSatisfied(Pixel pix, Color value)
    {
        if (value.equals(Color.BLUE) || value.equals(Color.ORANGE))
        {
            double sameColor = 0.0;
            double differentColor = 0.0;
            double result = 0.0;
        
            if (!isBelowRedLine(pix.getY(), value))
            {
                return false;
            }

            for (Pixel tempPix : this.getPixels())
            {
                if (!isThePixel(tempPix, this.x, this.y) 
                    && areNeighbors(tempPix, pix))
                {
                    sameColor = isSatisfiedHelperOne(tempPix, 
                    value, sameColor);
                    differentColor = isSatisfiedHelperTwo(tempPix, 
                    value, differentColor);
                }
            }
        
            if (sameColor + differentColor == 0)
            {
                return false;
            }
        
            result = sameColor / (double) (sameColor + differentColor);
        
            return (result >= this.satisfactionThreshold);
        }
        return false;
    } 

    /**
     * Takes one Pixel object as a parameter and returns a boolean result. 
     * This method tries to move the corresponding 
     * agent to a new pixel location.
     * @param pix a Pixel object
     * @return the result of if the pixel can be relocated
     */
    public boolean maybeRelocate(Pixel pix)
    {
        relocateHelper(pix.getX(), pix.getY());
        
        if (pix.getColor().equals(Color.BLUE))
        {
            for (Pixel tempPix : this.getPixels())
            {
                if (tempPix.getColor().equals(Color.WHITE)
                    && isSatisfied(tempPix, pix.getColor()))
                {
                    tempPix.setColor(pix.getColor());
                    pix.setColor(Color.WHITE);
                    relocateHelper(-1, -1);
                    return true; 
                }
            }
        }
        
        else if (pix.getColor().equals(Color.ORANGE))
        {
            for (Pixel tempPix : this.getPixels())
            {
                if (tempPix.getColor().equals(Color.WHITE) 
                    && isSatisfied(tempPix, pix.getColor())
                    && tempPix.getY() >= this.redLine)
                {
                    tempPix.setColor(pix.getColor());
                    pix.setColor(Color.WHITE);
                    relocateHelper(-1, -1);
                    return true;   
                }
            }
        }
        
        relocateHelper(-1, -1);
        return false;
    }
    
    /**
     * Takes no parameters and returns an integer result. 
     * This method uses a loop over all pixels, 
     * checking each pixel in turn.
     * f the pixel is empty, leave it alone. 
     * If it is occupied, check to see if the agent there is satisfied
     * if so, leave the agent alone. 
     * Otherwise, attempt to relocate it to a new position
     * @return the total number of successful moves 
     * after processing all pixels
     */
    public int cycleAgents()
    {
        int nums = 0;
        for (Pixel pix : this.getPixels())
        {
            if (!isSatisfied(pix, pix.getColor()) && maybeRelocate(pix))
            {
                nums++;
            }
        }
        return nums;
    }
    
    /**
     * The helper method of isSatisfied which takes a 
     * Pixel object, a color value and a double
     * which is designed to identify blue agents
     * @param pix the Pixel object
     * @param value the color of the pixel
     * @param num the total number of the same color
     * @return the num of the same color
     */
    public double isSatisfiedHelperOne(Pixel pix, Color value, double num)
    {
        if (pix.getColor().equals(value))
        {
            num++;
        }
        return num;
    }
    
    /**
     * The helper method of isSatisfied which takes a 
     * Pixel object, a color value and a double
     * which is designed to identify orange agents
     * @param pix the Pixel object
     * @param value the color of the pixel
     * @param num the total number of the different color
     * @return the num of the different color
     */
    public double isSatisfiedHelperTwo(Pixel pix, Color value, double num)
    {
        if (!pix.getColor().equals(Color.WHITE) 
            && !pix.getColor().equals(value))
        {
            num++;
        }
        return num;
    }
    
    /**
     * Take two Pixel objects and determine 
     * the relative location of two pixels
     * @param pix1 a pixel object
     * @param pix2 a pixel object
     * @return if two pixles are neighbours return true
     */
    public boolean areNeighbors(Pixel pix1, Pixel pix2)
    {
        if (pix1.getX() == pix2.getX() - 1)
        {
            if (pix1.getY() == pix2.getY() - 1)
            {
                return true;  //north-west
            }
            else if (pix1.getY() == pix2.getY() + 1)
            {
                return true;  //south-west  
            }
            else if (pix1.getY() == pix2.getY())
            {
                return true;  //west    
            }
        }
        else if (pix1.getX() == pix2.getX())
        {
            if (pix1.getY() == pix2.getY() - 1)
            {
                return true;  //north
            }
            else if (pix1.getY() == pix2.getY() + 1)
            {
                return true;  //south             
            }
        }
        else if (pix1.getX() == pix2.getX() + 1) 
        {
            if (pix1.getY() == pix2.getY() - 1)
            {
                return true;  //north-east
            }
            else if (pix1.getY() == pix2.getY())
            {
                return true;  //east 
            }
            else if (pix1.getY() == pix2.getY() + 1)
            {
                return true;  //south-east
            }
        }

        return false; 
    }
    
    /**
     * Takes a double and check if it's fraction
     * @param num the fraction to check
     * @return if the param is double, it will return true
     * Otherwise, it will return false
     */
    public boolean isFraction(double num)
    {
        int temp = (int) num;
        return (num > temp);
    }
    
    /**
     * Takes two numbers and check if they belong to ten's place
     * @param num1 the first number to check
     * @param num2 the second number to check
     * @return if the param is, it will return true
     * Otherwise, it will return false
     */
    public boolean isTensPlace(double num1, double num2)
    {
        double temp1 = num1 / 10;
        double temp2 = num2 / 10;
        return (temp1 < 1 || temp2 < 1);
    }

    /**
     * Takes an integer and a color check if it needs to be
     * set under the redline
     * @param num the y-coordinate
     * @param value the color of the pixel
     * @return if it passes the test, returns true
     */
    public boolean isBelowRedLine(int num, Color value)
    {
        if (value.equals(Color.ORANGE))
        {
            return (num >= this.redLine);
        }
        return true;
    }
    
    /**
     * Takes one pixel and two integers
     * check if the x and y value are equal to the coordinate 
     * of the pixel
     * @param pix the first pixel
     * @param num1 x coordinate
     * @param num2 y coordinate
     * @return if they are the same, return true
     */
    public boolean isThePixel(Pixel pix, int num1, int num2)
    {
        return (pix.getX() == num1 && pix.getY() == num2);
    }
    
    /**
     * Store the coordinates of the pixel to be relocate to ensure
     * isSatisfied will not take this pixel into consideration
     * @param num1 x coordinate
     * @param num2 y coordinate
     */
    public void relocateHelper(int num1, int num2)
    {
        this.x = num1;
        this.y = num2;
    }
}
