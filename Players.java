import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Players here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Players
{
    // instance variables - replace the example below with your own
    private Deck deck;
    private List<Card> winningPile;
    /**
     * Constructor for objects of class Players
     */
    public Players()
    {
        // initialise instance variables
        deck = new Deck();
        winningPile = new ArrayList<Card>();
    }
    /**
     * 
     */
    public int getDeckSize() {
        return deck.getDeckSize();
    }
    /**
     * 
     */
    public void shuffle() {
        deck.shuffle();
    }
    /**
     * 
     */
    public Card dealCardFromDeck() {
        return deck.dealCardFromDeck();
    }
    /**
     * 
     */
    public void addCardToDeck(Card cardToAdd) {
        deck.addCardToDeck(cardToAdd);
    }
    /**
     * 
     */
    public List placeWinningPileToDeck(List<Card> deck) {
        deck = this.winningPile;
        return deck;
    }
    /**
     * 
     */
    public void addToWinningPile(Card yourCard, Card opponentCard) {
        this.winningPile.add(yourCard);
        this.winningPile.add(opponentCard);
    }
}
