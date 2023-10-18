
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    // instance variables - replace the example below with your own int x;
    public Players playerOne;
    public Players playerTwo;
    private War war;
    private Deck test;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        playerOne = new Players();
        playerTwo = new Players();
        war = new War();
        this.starter();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void starter()
    {
        // put your code here
        playerOne.initializeDeck();
        playerTwo.initializeDeck();
        
        for (int i = 0; i < 300; i++) {
            if (playerOne.getDeckSize() == 0) {
                if (playerOne.getWinningPileSize() == 0) {
                    System.out.println("Player Two has won the game since Player One doesn't have any cards!");
                    break;
                }
                playerOne.shuffleWinningPile();
                playerOne.winningPileToDeck();
            }
            if (playerTwo.getDeckSize() == 0) {
                if (playerTwo.getWinningPileSize() == 0) {
                    System.out.println("Player One has won the game since Player Two doesn't have any cards!");
                    break;
                }
                playerTwo.shuffleWinningPile();
                playerTwo.winningPileToDeck();
            }
            
            Card playerOneCard = playerOne.dealCardFromDeck();
            Card playerTwoCard = playerTwo.dealCardFromDeck();
            
            if (playerOneCard.getRank() > playerTwoCard.getRank()) {
                playerOne.addToWinningPile(playerOneCard, playerTwoCard);
                System.out.println("Player One Won! Player One's Card: " + playerOneCard.getRank() + " " + playerOneCard.getFace() + " " + playerOneCard.getSuit() + " Player Two's Card: " + playerTwoCard.getRank() + " " + playerTwoCard.getFace() + " " + playerTwoCard.getSuit());
                System.out.println("Player One has " + playerOne.getDeckSize() + " cards in their deck & " + playerOne.getWinningPileSize() + " cards in winning pile.");
                System.out.println("-------------------------------------------------------");
            }
            if (playerTwoCard.getRank() > playerOneCard.getRank()) {
                playerTwo.addToWinningPile(playerTwoCard, playerOneCard);
                System.out.println("Player Two Won! Player Two's Card: " + playerTwoCard.getRank() + " " + playerTwoCard.getFace() + " " + playerTwoCard.getSuit() + " Player One's Card: " + playerOneCard.getRank() + " " + playerOneCard.getFace() + " " + playerOneCard.getSuit());
                System.out.println("Player Two has " + playerTwo.getDeckSize() + " cards in their deck & " + playerTwo.getWinningPileSize() + " cards in winning pile.");
                System.out.println("-------------------------------------------------------");
            }
            if (playerOneCard.getRank() == playerTwoCard.getRank()) {
                war.runEventLoop();
            }
            
            if (i == 299) {
                if (playerTwo.getDeckSize() > playerOne.getDeckSize()) {
                    System.out.println("Player Two has won the game since it has reached the 300th iteration!");
                } else {
                    System.out.println("Player One has won the game since it has reached the 300th iteration!");
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
        Game war = new Game();
    }
}
