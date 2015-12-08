import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author Jaakko Koistinen
 * @version 2015-12-07
 */
public class Player
{
    // instance variables - replace the example below with your own
    public String name;
    public List<Integer> scoreList = new ArrayList<Integer>();
    
    public int totroundswon = 0;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        // initialise instance variables
        this.name = name;
       
    }

    /**
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addPoints(int points)
    {
       scoreList.add(points);
       //System.out.println(scoreList);
    }
    
    public void incrementRoundsWon()
    {
       totroundswon = totroundswon + 1;
    }
}
