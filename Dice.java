import java.util.Random;
/**
 * This is class Dice, it creates a Dice object that will return a int between low and high
 * 
 * @author Jaakko Koistinen 
 * @version (a version number or a date)
 */
public class Dice
{
    // instance variables
    private int low;
    private int high;

    /**
     * Constructor for objects of class Dice
     */
    public Dice()
    {
        // initialise instance variables
        // 6 sided dice
        low = 1;
        high = 6;
    }

    /**
     * rollDice method
     * 
     * @param  no parameters
     * @return     int result
     */
    
    public int rollDice() {
        Random random = new Random();
		int result = random.nextInt(high) + low;
		//System.out.println("Dice roll is:"+result);
		return result;
	}

}
