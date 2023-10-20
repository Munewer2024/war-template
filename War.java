import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class War here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class War
{
    public Players playerOne;
    public Players playerTwo;
    private Deck deck;
    /**
     * Constructor for objects of class War
     */
    public War()
    {
        playerOne = new Players();
        playerTwo = new Players();
        deck = new Deck();
        deck.initializeNewDeck();
        this.starter();
    }

    /**
     * Starts the card game War
     */
    public void starter()
    {   
        for (int i = 0; i < deck.cards.size(); i++) {
            if (i % 2 == 0) {
                playerOne.cards.add(deck.cards.get(i));
            } else {
                playerTwo.cards.add(deck.cards.get(i));
            }
        }
        playerOne.shuffle();
        playerTwo.shuffle();
        
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
                boolean war = true;
                List<Card> warWinnings = new ArrayList<Card>();
                while (war) {
                    System.out.println("War has started between Player One and Player Two!");
                    System.out.println("--------------------------------------------------");
                    if (playerTwo.getDeckSize() + playerTwo.getWinningPileSize() < 4) {
                        System.out.println("Player One has won the game because Player Two doesn't have enough cards to continue War!");
                        System.out.println("--------------------------------------------------");
                        i = 299;
                        break;
                    }
                    if (playerOne.getDeckSize() + playerOne.getWinningPileSize() < 4) {
                        System.out.println("Player Two has won the game because Player One doesn't have enough cards to continue War!");
                        System.out.println("--------------------------------------------------");
                        i = 299;
                        break;
                    }
                    for (int j = 0; j < 4; j++) {
                        if (playerOne.getDeckSize() == 0) {
                            playerOne.shuffleWinningPile();
                            playerOne.winningPileToDeck();
                        }
                        if (playerTwo.getDeckSize() == 0) {
                            playerTwo.shuffleWinningPile();
                            playerTwo.winningPileToDeck();
                        }
                        Card card = playerOne.dealCardFromDeck();
                        Card cardTwo = playerTwo.dealCardFromDeck();
                        warWinnings.add(card);
                        warWinnings.add(cardTwo);
                    }
                    if (playerOne.getDeckSize() == 0) {
                            playerOne.shuffleWinningPile();
                            playerOne.winningPileToDeck();
                    }
                    if (playerTwo.getDeckSize() == 0) {
                            playerTwo.shuffleWinningPile();
                            playerTwo.winningPileToDeck();
                    }
                    Card oneFourthCard = playerOne.dealCardFromDeck();
                    Card twoFourthCard = playerOne.dealCardFromDeck();
                    warWinnings.add(oneFourthCard);
                    warWinnings.add(twoFourthCard);
                    if (oneFourthCard.getRank() > twoFourthCard.getRank()) {
                        System.out.println("Player One has won the war!");
                        System.out.println("--------------------------------------------------");
                        for (int j = 0; j < warWinnings.size(); j++) {
                            playerOne.addToWinningPileWar(warWinnings.get(j));
                        }
                        warWinnings.clear();
                        war = false;
                    }
                    if (oneFourthCard.getRank() < twoFourthCard.getRank()) {
                        System.out.println("Player Two has won the war!");
                        System.out.println("--------------------------------------------------");
                        for (int j = 0; j < warWinnings.size(); j++) {
                            playerTwo.addToWinningPileWar(warWinnings.get(j));
                        }
                        warWinnings.clear();
                        war = false;
                    }
                    if (oneFourthCard.getRank() == twoFourthCard.getRank()) {
                        System.out.println("Both players had equal rank, so war will continue!");
                        System.out.println("--------------------------------------------------");
                    }
                }
            }
            if (i == 299) {
                System.out.println("Game is over!");
            }
        }
    }
    
    public static void main(String[] args) {
        War war = new War();
    }
}
