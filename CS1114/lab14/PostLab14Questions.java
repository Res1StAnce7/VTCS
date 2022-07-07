//-------------------------------------------------------------------------
/**
 *  Post-lab questions for you to answer. Be sure to fill in the next
 *  two lines with your information.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.12.01
 */
public interface PostLab14Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: Identify the line number of the error in the
     * following code. The line numbers are for readability and
     * convenience. The method accepts a string and returns the
     * middle letter. 
     * 
     * 1  public String getMiddleLetter(String word)
     * 2  {
     * 3      int length = word.length();
     * 4      int position = length / 2;
     * 5      char letter = word.charAt(position);
     * 6      return letter;
     * 7  }
     * 
     * A: Line 5: charAt returns a String instead of a char
     * B: Line 6: the return type is incorrect
     * C: Line 1: the parameter is not declared correctly
     * D: Line 4: the result of length/2 cannot be stored in an int variable
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "B";


    // ----------------------------------------------------------
    /**
     * Question 2: Identify the line number of the error in the
     * following code. The line numbers are for readability and
     * convenience. The method accepts an integer value. The loop
     * counts down from this value until zero has been reached.
     * 
     * 1  public void countingLoop(int val)
     * 2  {
     * 3      int counter = val;
     * 4      while (counter > 0)
     * 5      {
     * 6          System.out.println(counter);
     * 7          counter-;
     * 8      }
     * 9  }
     * 
     * A: Line 4: The while condition should be counter < val
     * B: Line 1: the val parameter should be of type double
     * C: Line 7: counter-- is used to decrement by one
     * D: Line 4: The loop will never terminate
     * 
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "C";


    // ----------------------------------------------------------
    /**
     * Question 3: Identify the line number of the error in the
     * following code. The line numbers are for readability and
     * convenience. The code is for the simple Car class. It contains
     * two constructors, two fields with getters and setters, and
     * a toString() method.
     * 
     * 1  public class Car
     * 2  {
     * 3      private String make;
     * 4      private String color;
     * 5
     * 6      public Car()
     * 7      {
     * 8          make = "Car";
     * 9          color = "beige";
     * 10     }
     * 11
     * 12     public Car(String make, String carColor)
     * 13     {
     * 14         make = make;
     * 15         color = carColor;
     * 16     }
     * 17
     * 18     public String getMake()
     * 19     {
     * 20         return make;
     * 21     }
     * 22
     * 23     public void setMake(String m)
     * 24     {
     * 25         make = m;
     * 26     }
     * 27
     * 28     public String getColor()
     * 29     {
     * 30         return color;
     * 31     }
     * 32
     * 33     public void setColor(String c)
     * 34     {
     * 35         color = c;
     * 36     }
     * 37
     * 38     public String toString()
     * 39     {
     * 40         String str = "Make: " + make + "\n" +
     * 41             "Color: " + color;
     * 42         return str;
     * 43     }
     * 44
     * 45  }
     * 
     * A: Line 14: assignment has no effect
     * B: Line 40: "\n" is an illegal escape character
     * C: The code contains no errors
     * D: Line 28: method should take a String parameter
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "A";

 
    // ----------------------------------------------------------
    /**
     * Question 4: Identify the line number of the error in the
     * following code. The line numbers are for readability and
     * convenience. The method accepts a String array and adds all
     * strings in that array to a single String object and then
     * returns that.
     * 
     * 1  public String concatenateArray(String[] array)
     * 2  {
     * 3      String concatenatedString = "";
     * 4      for (i = 0; i < array.length; i++)
     * 5      {
     * 6          concatenatedString += array[i] + " ";
     * 7      }
     * 8
     * 9      return concatenatedString;
     * 10  }
     * 
     * A: Line 6: the += operator cannot be used with Strings
     * B: Line 4: a variable name is used without being declared
     * C: Line 4: array.length( ) should be called to obtain the
     *    number of elements in an array
     * D: Line 9: the variable name is misspelled
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "B";

 
    // ----------------------------------------------------------
    /**
     * Question 5: Identify the error present in the following code.
     * 
     * public void calcDistance(int x1, int y1, int x2, int y2)
     * {
     *     return Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
     * }
     * 
     * A: cannot find symbol (unrecognized identifier)
     * B: This code produces no errors
     * C: ')' expected
     * D: Inncompatible types: unexpected return value
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "D";
}
