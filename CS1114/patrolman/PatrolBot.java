import student.micro.lightbot.*;

//---------------------------------------------------------------------------
/**
 * @author Siliang Zhang
 * @date 2021.08.30
 */
public class PatrolBot
    extends LightBot
{
    public PatrolBot()
    {
        super();
    }


    public void patrolCastle()
    {
        for(int i=0; i<4; i++)
        {
            onWall();
        }
    }
    
    public void onWall()
    {
        for(int i=0; i<4; i++)
        {
            this.move();
        }
        this.turnRight();
    }
}
