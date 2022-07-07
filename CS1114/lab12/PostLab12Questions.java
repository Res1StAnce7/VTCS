//-------------------------------------------------------------------------
/**
 *  Post-lab questions for you to answer. Be sure to fill in the next
 *  two lines with your information.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.10
 */
public interface PostLab12Questions
{
    // ----------------------------------------------------------
    /**
     * Question 1: Assume you have a Scanner object reading from
     * the following text, and the Scanner has currently read just
     * past the word 'first':
     * 
     * This is the first line of text.
     * Here is the second sentence.
     * 
     * What will be returned if you call scanner.next()? 
     * 
     * A: first
     * B: line
     * C: of
     * D: text.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question1 = "B";


    // ----------------------------------------------------------
    /**
     * Question 2: What is a stream?
     * 
     * A: It is the memory used by your program.
     * B: It is a sequence of method calls in a program.
     * C: It is the text located inside of a file.
     * D: It is a sequence of text or data coming from some source
     *    or going to some destination.
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question2 = "D";


    // ----------------------------------------------------------
    /**
     * Question 3: What does the Scanner class consider to be a word
     * (assuming the default delimiters are used)?
     * 
     * A: A single character
     * B: Whitespace characters
     * C: Any series of non-whitespace characters
     * D: Any series of characters
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question3 = "C";

 
    // ----------------------------------------------------------
    /**
     * Question 4: Consider the following input:
     * 
     * This is the first line of text.
     * This is the second line of text.
     * 
     * Assuming you have a brand new Scanner object named scanner
     * that was created to read from this text. Assume nothing has
     * been read from the Scanner yet. If scanner.nextLine() is
     * called, what will be returned? 
     * 
     * A: This is the first line of text.
     * B: This is the second line of text.
     * C: This is the first line of text.\nThis is the second line of text.
     * D: This
     * 
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question4 = "A";

 
    // ----------------------------------------------------------
    /**
     * Question 5: What method should you use to ensure the Scanner
     * object still contains information?
     * 
     * A: next()
     * B: hasNextWord
     * C: hasNext()
     * D: nextWord()
     *
     * Place your letter choice answer (A-D) between the two double-quotes
     * in the following line.
     */
    String question5 = "C";
}
