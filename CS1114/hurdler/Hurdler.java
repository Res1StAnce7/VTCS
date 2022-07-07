import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  A jeroo that "hurdles" (crosses over) lines of nets that project
 *  up from the south shore.
 *
 *  @author Stephen Edwards (stedwar2)
 *  @version 2013.02.11
 */
public class Hurdler
    extends Jeroo
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Hurdler object.
     */
    public Hurdler()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public void myProgram()
    {       
       while (this.seesFlower(HERE))
       {
           this.pick();
           if (this.seesFlower(AHEAD))
           {
               this.hop();
           }
           else
           {
               if (this.seesFlower(LEFT))
               {
                   this.turn(LEFT);
                   this.hop();
               }
               else if (this.seesFlower(RIGHT))
               {
                   this.turn(RIGHT);
                   this.hop();
               }
           }
       }
    }

}
