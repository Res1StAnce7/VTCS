// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Siliang Zhang (906467527)

/**
 *  Represents a weekly event at a specified time, including a
 *  description.
 *
 *  @author Siliang Zhang (906467527)
 *  @version 2021.11.03
 */
public class Event
{
    private int hour;
    private String description;
    
    /**
     * Creates a new Event object.
     * 
     * @param hour The hour (time) of this event, in military time
     *             (0-23).
     * @param description The description of this event.
     */
    public Event(int hour, String description)
    {
        this.hour = hour;
        this.description = description;
    }
    
    /**
     * Creates a new Event object
     * @param time The time of this event (non-militray time).
     * @param description The description of this event.
     */
    public Event(String time, String description)
    {
        setTime(time);
        this.description = description;
    }
    
    /**
     * Get the description of this event.
     * @return This event's description.
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Get the hour of this event.
     * @return This event's hour, in military time.
     */
    public int getHour()
    {
        return this.hour;
    }
    
    /**
     * Set the description of this event.
     * @param newDescription The new description for this event.
     */
    public void setDescription(String newDescription)
    {
        this.description = newDescription;
    }

    /**
     * Set the hour of this event.
     * @param newHour The new hour for this  event, in military
     *                time.
     */
    public void setHour(int newHour)
    {
        this.hour = newHour;
    }
    
    /**
     * Set the hour of this event, using a more human-friendly
     * string.
     * @param newHour The new hour for this event, using an
     *                am/pm designation such as "9am" or "5pm".
     */
    public void setTime(String newHour)
    {
        int index = 0;
        if (newHour.substring(1, 3).equals("am") 
            || newHour.substring(1, 3).equals("pm")) 
        {
            index = 1;
        }
        else
        {
            index = 2;
        }
        
        String digits = newHour.substring(0, index);
        int tempHour = Integer.parseInt(digits);
        if (tempHour != 12)
        {
            if (newHour.substring(index, index + 2).equals("pm") )
            {
                setHour(tempHour + 12);
            }
            else
            {
                setHour(tempHour);
            }
        }
        else
        {
            if (newHour.substring(index, index + 2).equals("pm") )
            {
                setHour(12);
            }
            else
            {
                setHour(0);
            }
        }
    }

    /**
     * Get a string representation of this event.
     * @return A human-readable representation of this event
     * that includes the time (in am/pm format) and the description,
     * such as "11am: CS 1114".
     */
    @Override 
    public String toString()
    {
        if (getHour() == 0)
        {
            return 12 + "am: " + getDescription();
        }
        else if (getHour() == 12)
        {
            return 12 + "pm: " + getDescription();
        }
        else if (getHour() < 12)
        {
            return getHour() + "am: " + getDescription();
        }
        else
        {
            return getHour() - 12 + "pm: " + getDescription();
        }
    }
}
