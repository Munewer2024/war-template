
/**
 * Write a description of class Players here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Players
{
    // instance variables - replace the example below with your own
    private Deck player;

    /**
     * Constructor for objects of class Players
     */
    public Players()
    {
        // initialise instance variables
        player = new Deck();
    }

    /**
     * An example of a method - Determines if the player has enough cards
     *
     * @return either true or false depending on how many cards the player has
     */
    public boolean enoughCards()
    {
        if (player.getDeckSize() < 0) {
            return true;
        }
        return false;
    }
    
    public Players[] winningPile() {
        
    }
}
