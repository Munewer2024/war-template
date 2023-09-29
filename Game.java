
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    // instance variables - replace the example below with your own int x;
    private Deck playerOne;
    private Deck playerTwo;
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        playerOne = new Deck();
        playerTwo = new Deck();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void gameStarter()
    {
        // put your code here
        playerOne.initializeNewDeck();
        playerOne.dealDeck();
    }
    
    public static void main(String[] args) {
        Game war = new Game();
    }
}
