// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)
import student.TestCase;
import static org.assertj.core.api.Assertions.*;

/**
 *  Tests for the Calendar class.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.03
 */
public class CalendarTest
    extends TestCase
{
    private Calendar calendar;

    /**
     * Creates a new CalendarTest test object.
     */
    public CalendarTest()
    {
        //Creates a new CalendarTest test object.
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        calendar = new Calendar();
    }

    /**
     * Test the addEvent() method
     */
    public void testAddEvent()
    {
        Event event = new Event(11, "CS1114");
        calendar.addEvent(0, event);
        assertThat(calendar.getEvent(0, 11).getDescription())
                  .isEqualTo("CS1114");
        calendar.addEvent(6, event);        
        assertThat(calendar.getEvent(6, 11).getDescription())
                  .isEqualTo("CS1114");    
        
        event = new Event("12am", "CS1114");
        calendar.addEvent(0, event);
        assertThat(calendar.getEvent(0, 0)).isEqualTo(null);
        
        event = new Event("12pm", "CS1114");
        calendar.addEvent(0, event);
        assertThat(calendar.getEvent(0, 12).getDescription())
                  .isEqualTo("CS1114");
        
        event = new Event("1pm", "CS1114");
        calendar.addEvent(2, event);
        assertThat(calendar.getEvent(2, 13).getDescription())
                  .isEqualTo("CS1114"); 
                  
        event = new Event("1am", "CS1114");
        calendar.addEvent(2, event);
        assertThat(calendar.getEvent(2, 1)).isEqualTo(null);
        
        event = new Event("1am", "CS1114");
        calendar.addEvent(2, event);
        assertThat(calendar.getEvent(7, 1)).isEqualTo(null); 
        
        event = new Event("1am", "CS1114");
        calendar.addEvent(2, event);
        assertThat(calendar.getEvent(-1, 1)).isEqualTo(null); 
        
        assertThat(calendar.getEvent(0, 16)).isEqualTo(null); 
        assertThat(calendar.getEvent(0, 15)).isEqualTo(null); 
        
        event = new Event("6pm", "CS1114");
        calendar.addEvent(2, event);
        assertThat(calendar.getEvent(-1, 18)).isEqualTo(null); 
        
        event = new Event("10pm", "CS1114");
        calendar.addEvent(-22, event);
        assertThat(calendar.getEvent(-22, 22)).isEqualTo(null); 
        assertThat(calendar.getEvent(22, 22)).isEqualTo(null);
        calendar.addEvent(-2, event);
        calendar.addEvent(99, event);
        assertThat(calendar.getEvent(99, 22)).isEqualTo(null);
    }
}
