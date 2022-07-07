// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.TestCase;
import static org.assertj.core.api.Assertions.*;

/**
 *  Tests for the Event class.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.03
 */
public class EventTest
    extends TestCase
{
    private Event event;

    /**
     * Creates a new EventTest test object.
     */
    public EventTest()
    {
        //Creates a new EventTest test object.
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        event = new Event(6, "A");
    }
    
    /**
     * Test the first constructor
     */
    public void testEvent1()
    {
        assertThat(event.getHour()).isEqualTo(6);
        assertThat(event.getDescription()).isEqualTo("A");
    }
    
    /**
     * Test the second constructor
     */
    public void testEvent2()
    {
        Event newEvent = new Event("12am", "C");
        assertThat(newEvent.getHour()).isEqualTo(0);
        assertThat(newEvent.getDescription()).isEqualTo("C");
    }
    
    /**
     * Test the getHour() method
     */
    public void testGetHour()
    {
        assertThat(event.getHour()).isEqualTo(6);
    }
    
    /**
     * Test the getDescription() method
     */
    public void testGetDescription()
    {
        assertThat(event.getDescription()).isEqualTo("A");
    }
    
    /**
     * Test the setDescription() method
     */
    public void testSetDescription()
    {
        event.setDescription("B");
        assertThat(event.getDescription()).isEqualTo("B");
    }
    
    /** 
     * Test the setHour() method
     */
    public void testSetHour()
    {
        event.setHour(8);
        assertThat(event.getHour()).isEqualTo(8);
        assertThat(event.getDescription()).isEqualTo("A");
    }
    
    /**
     * Test the setHour() method
     */
    public void testSetTime()
    {
        event.setTime("10am");
        assertThat(event.getHour()).isEqualTo(10);
        
        event.setTime("10pm");
        assertThat(event.getHour()).isEqualTo(22);
        
        event.setTime("12am");
        assertThat(event.getHour()).isEqualTo(0);
        
        event.setTime("12pm");
        assertThat(event.getHour()).isEqualTo(12);
    }
    
    /**
     * Test the toString() method()
     */
    public void testToString()
    {
        event.setTime("10am");
        assertThat(event.toString()).isEqualTo("10am: A");
        
        event.setTime("10pm");
        assertThat(event.toString()).isEqualTo("10pm: A");
        
        event.setTime("12am");
        assertThat(event.toString()).isEqualTo("12am: A");
        
        event.setTime("12pm");
        assertThat(event.toString()).isEqualTo("12pm: A");
        
        event.setHour(0);
        assertThat(event.toString()).isEqualTo("12am: A");
        
        event.setHour(12);
        assertThat(event.toString()).isEqualTo("12pm: A");
        
        event.setHour(23);
        assertThat(event.toString()).isEqualTo("11pm: A");
        
        event.setHour(1);
        assertThat(event.toString()).isEqualTo("1am: A");
        
        event.setHour(13);
        assertThat(event.toString()).isEqualTo("1pm: A");
    }
}
