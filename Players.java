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
    private Deck player;
    private List<Card> winningPile;
    /**
     * Constructor for objects of class Players
     */
    public Players()
    {
        // initialise instance variables
        player = new Deck();
        winningPile = new ArrayList<Card>();
    }
    /**
     * Get the number of cards in the deck
     * 
     * @returns The number of cards in the deck
     */
    public int getDeckSize() {
        return player.getDeckSize();
    }
    /**
     * Get the number of cards in the winning pile
     * 
     * @returns The number of cards in the winning pile
     */
    public int getWinningPileSize() {
        return this.winningPile.size();
    }
    /**
     * Shuffle the cards in the deck
     */
    public void shuffle() {
        player.shuffle();
    }
    /**
     * Shuffle the cards in the winning pile
     */
    public void shuffleWinningPile() {
        List<Integer> randomNumbers = new ArrayList<Integer>();
        List<Card> shuffledCards = new ArrayList<Card>();
        for (int i = 0; i < this.winningPile.size(); i++) {
            int j = (int)(Math.random() * this.winningPile.size());
            Card newCard = this.winningPile.get(j);
            if (randomNumbers.contains(j)) {
                i--;
                continue;
            }
            shuffledCards.add(i, newCard);
            randomNumbers.add(j);
        }
        this.winningPile = shuffledCards;
    }
    /**
     * Deal the top card of the deck
     * 
     * @returns The top card of the deck
     */
    public Card dealCardFromDeck() {
        return player.dealCardFromDeck();
    }
    /**
     * Adds the winning pile to the deck
     */
    public void winningPileToDeck() {
        player.winningPileToDeck(this.winningPile);
    }
    /**
     * Add cards to the winning pile
     * @params yourCard: The card the player placed & opponentCard: The card the opponent player placed
     */
    public void addToWinningPile(Card yourCard, Card opponentCard) {
        this.winningPile.add(yourCard);
        this.winningPile.add(opponentCard);
    }
}