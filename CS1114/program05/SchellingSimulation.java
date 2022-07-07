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
            double n1 = 0.0;
            double n2 = 0.0;
            double index = 0.0;
        
            while (isFraction(blue))
            {
                blue = blue * 10;
                n1++;
            }
            while (isFraction(orange))
            {
                orange = orange * 10;
                n2++;
            }
        
            if (n1 > n2)
            {
                orange = orange * Math.pow(10, n1 - n2);
                index = n1;
            }
            else 
            {
                blue = blue * Math.pow(10, n2 - n1);
                index = n2;
            }
        
            if (isTensPlace(blue, orange))
            {
                blue = blue * 10;
                orange = orange * 10;
                index++;
            }
        
            for (Pixel pix : this.getPixels())
            {  
                if (generator.nextInt((int) Math.pow(10, index)) < (int) blue)
                {
                    pix.setColor(Color.BLUE);
                }           
            }
            
            for (Pixel pix : this.getPixels())
            {
                if (generator.nextInt((int) Math.pow(10, index)) 
                    < (int) orange && isEmpty(pix))
                {
                    pix.setColor(Color.ORANGE);
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
                pix.setColor(Color.ORANGE);
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
        double sameColor = 0.0;
        double differentColor = 0.0;
        double result = 0.0;
        
        for (Pixel tempPix : this.getPixels())
        {
            int location = relativeLocation(tempPix, pix);
            
            if (location == 1)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
            else if (location == 2)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
            else if (location == 3)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
            else if (location == 4)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
            else if (location == 5)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
            else if (location == 6)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
            else if (location == 7)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
            else if (location == 8)
            {
                sameColor = isSatisfiedHelperOne(tempPix, 
                value, sameColor);
                differentColor = isSatisfiedHelperTwo(tempPix, 
                value, differentColor);
            }
        }
        
        result = (sameColor + 1) / (sameColor + differentColor + 1);

        return (result >= satisfactionThreshold);
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
        if (pix.getColor().equals(Color.BLUE))
        {
            for (Pixel tempPix : this.getPixels())
            {
                if (tempPix.getColor().equals(Color.WHITE)
                    && isSatisfied(tempPix, pix.getColor()))
                {
                    tempPix.setColor(pix.getColor());
                    pix.setColor(Color.WHITE);
                    return true; 
                }
            }
        }
        
        if (pix.getColor().equals(Color.ORANGE))
        {
            for (Pixel tempPix : this.getPixels())
            {
                if (tempPix.getColor().equals(Color.WHITE) 
                    && isSatisfied(tempPix, pix.getColor())
                    && tempPix.getY() >= this.redLine)
                {
                    tempPix.setColor(pix.getColor());
                    pix.setColor(Color.WHITE);
                    return true;   
                }
            }
        }
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
            if (!pix.getColor().equals(Color.WHITE) 
                && !isSatisfied(pix, pix.getColor())
                && maybeRelocate(pix))
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
     * @return the code of relative location of two pixels
     */
    public int relativeLocation(Pixel pix1, Pixel pix2)
    {
        if (pix1.getX() == pix2.getX() - 1)
        {
            if (pix1.getY() == pix2.getY() - 1)
            {
                return 1;  //north-west
            }
            else if (pix1.getY() == pix2.getY() + 1)
            {
                return 7;  //south-west  
            }
            else if (pix1.getY() == pix2.getY())
            {
                return 8;  //west    
            }
        }
        else if (pix1.getX() == pix2.getX())
        {
            if (pix1.getY() == pix2.getY() - 1)
            {
                return 2;  //north
            }
            else if (pix1.getY() == pix2.getY() + 1)
            {
                return 6;  //south             
            }
        }
        else if (pix1.getX() == pix2.getX() + 1) 
        {
            if (pix1.getY() == pix2.getY() - 1)
            {
                return 3;  //north-east
            }
            else if (pix1.getY() == pix2.getY())
            {
                return 4;  //east 
            }
            else if (pix1.getY() == pix2.getY() + 1)
            {
                return 5;  //south-east
            }
        }

        return 9; 
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
}
