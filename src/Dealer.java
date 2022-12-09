/**
 * This class represents a dealer in our blackjack game
 *  @author Anaastasia Tomuz & Connie Liu
 *
 */

import java.util.ArrayList;

public class Dealer {
    // instance variables

    /** The sum of the cards in the dealer's deck */
    private int sum;

    /** List that stores the cards in dealer's hand*/
    private ArrayList<Integer> dealerHand;

    /**
     * Instantiates a Dealer object
     *
     * 
     */
    public Dealer() {
        sum = 0;
        dealerHand = new ArrayList<Integer>();
    }

    // setter and getter methods

    public int getSum() {
        return sum;
    }

    public void setSum(int newSum) {
        sum = newSum;
    }

    public ArrayList<Integer> getHand() {
        return dealerHand;
    }

    /* CARD STUFF FOUND IN EVERY CLASS BUT THE MAIN CLASS */

    // returns the sum of the dealer's cards
    public int deckSum() {
        sum = 0;// resets the sum each time sum is counted to make sure it's not doubled
        for (int i = 0; i < dealerHand.size(); i++) {
            int currentNum = dealerHand.get(i);
            // spades
            if (currentNum >= 1 && currentNum <= 13) {
                if (currentNum > 10) {
                    sum += 10;
                } else if (currentNum >= 2 & currentNum <= 10) {
                    sum += currentNum;
                } else {
                    sum += aceValue();
                }
                // hearts
            } else if (currentNum >= 14 && currentNum <= 26) {
                currentNum -= 13;
                if (currentNum > 10) {
                    sum += 10;
                } else if (currentNum >= 2 & currentNum <= 10) {
                    sum += currentNum;
                } else {
                    sum += aceValue();
                }
                // clover
            } else if (currentNum >= 27 && currentNum <= 39) {
                currentNum -= 26;
                if (currentNum > 10) {
                    sum += 10;
                } else if (currentNum >= 2 & currentNum <= 10) {
                    sum += currentNum;
                } else {
                    sum += aceValue();
                }
                // diamonds
            } else {
                currentNum -= 39;
                if (currentNum > 10) {
                    sum += 10;
                } else if (currentNum >= 2 & currentNum <= 10) {
                    sum += currentNum;
                } else {
                    sum += aceValue();
                }
            }
        }
        return sum;
    }

    // private method to decide the value of the Ace card
    private int aceValue() {
        if (hasAce() && sum > 10) {
            return 1;
        } else {
            return 11;
        }
    }

    // private method to check if the player has an ace in their hand
    private boolean hasAce() {
        return dealerHand.contains(1) || dealerHand.contains(14) || dealerHand.contains(27) || dealerHand.contains(40);
    }

    public void clearHand() {
        dealerHand.clear();
    }

    // "setter" method for adding new card to player deck
    public void addCard(int newCard) {
        dealerHand.add(newCard);
    }
}