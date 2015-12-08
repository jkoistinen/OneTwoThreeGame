
/**
 * "1+2*3. Summan av antalet ögon i 1:a och 2:a kasten multipliceras med antalet ögon i 3:e kastet.
 * Den som får högst vinner.
 * Lämpligen spelas 10 rundor."
 * @author Jaakko Koistinen 
 * @version 2015-12-07
 */
public class OneTwoThreeGame
{
    // instance variables - replace the example below with your own
    private int numberRounds;

    /**
     * Constructor for objects of class OneTwoThreeGame
     */
    public OneTwoThreeGame(int rounds)
    {
        // initialise instance variables
        this.numberRounds = rounds;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int playRound()
    {
        Dice myDice = new Dice();
        int result = ( myDice.rollDice() + myDice.rollDice() ) * myDice.rollDice();
        return result;
    }
}
