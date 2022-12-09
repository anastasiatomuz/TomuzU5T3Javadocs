

import java.util.ArrayList;
/**
 * This class represents a player object
 *
 * @author Anastasia Tomuz and Connie Liu
 */

public class Player {
    /** The name of the player */
    private String name;

    /** The amount of the player's bet */
    private int bet;

    /** The amount of money the player has available */
    private int money;

    /** The sum of the cards in the player's hand */
    private int sum;

    /** A list that holds the cards that represents the player's hand */
    private ArrayList<Integer> hand;

    /**
     * Instantiates a Player object.
     *
     * @param name The name of the player
     * @param money Amount of money player has
     */
    public Player(String name, int money) {
        this.name = name;
        bet = 0;
        this.money = money;
        hand = new ArrayList<Integer>();
    }

    /**
     * Instantiates a Player object.
     *
     * @param name The name of the player
     * @param money Amount of money player has
     * @param bet The bet the player places
     */
    public Player(String name, int money, int bet){
        this.name = name;;
        this.bet = bet;
        this.money = money;
        hand = new ArrayList<Integer>();
    }

    /**
     * Sets the new bet the player made for the round
     *
     * @param newBet The new bet made by player
     */
    public void setBet(int newBet){
        bet = newBet;
    }

    /**
     * Sets an automatic bet by calling to private method 'automaticBet()'
     *
     */
    public void setBet(){
        bet = automaticBet();
    }

    /**
     * Returns the current bet set by author.
     *
     * @return The bet amount player set at the beginning of the round
     */
    public int getBet() {
        return bet;
    }

    /**
     * Returns the name of the player
     *
     * @return The name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current sum of the cards of player's hand.
     *
     * @return The sum of the cards of player's hand
     */
    public int getSum(){
        return sum;
    }

    /**
     * Returns the current sum of the cards of player's hand.
     *
     * @return The sum of the cards of player's hand
     */
    public ArrayList<Integer> getHand(){
        return hand;
    }

    /**
     * subtracts the money the player lost
     * @param lose The amount the player bet and lost in the round
     */
    public void subtractMoney(int lose) {
        money -= lose;
    }

    /**
     * adds the money the player won by gambling
     * @param add The amount of money the player won
     */
    public void addMoney(double add) {
        money += add;
    }

    /**
     * updates the sum of the cards in the deck
     * @param newSum The new sum of the cards in the player's deck
     */
    public void setSum(int newSum) {
        sum = newSum;
    }

    /**
     * Returns the amount of money the player has
     * @return The amount of money the player has
     */
    public int getMoney() {
        return money;
    }

    /**
     * Creates and returns a boolean to determine if the player still has money
     * @return If the player has money (> $0)
     */
    public boolean hasMoney() {
        return money > 0;
    }



    /*CARD STUFF FOUND IN EVERY CLASS BUT THE MAIN CLASS*/

    /**
     * calculates and returns the sum of the player's cards
     * @return the sum of the cards in the player's hand
     */
    public int deckSum() {
        sum = 0;// resets the sum each time sum is counted to make sure it's not doubled
        for (int i = 0; i < hand.size(); i++) {
            int currentNum = hand.get(i);
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



    /**
     * decides and returns the value of the Ace card
     * @return the value of ace (1 or 11)
     */
    private int aceValue() {
        if (hasAce() && sum > 10) {
            return 1;
        } else {
            return 11;
        }
    }



    /**
     * checks if the player has an ace in their hand (true if has ace)
     * @return if the player has an ace in their hand
     */
    private boolean hasAce() {
        return hand.contains(1) || hand.contains(14) || hand.contains(27) || hand.contains(40);
    }

    /**
     * clears the player's hand list
     */
    public void clearHand(){
        hand.clear();
    }


    /**
     * "setter" method for adding new card to player deck
     *
     * @param newCard the new card to add to the player's hand
     */
    public void addCard(int newCard){
        hand.add(newCard);
    }

    /**
     * creates an automatic bet (1/10 of the value of the player's current money
     *
     * @return the automatic bet created
     */
    private int automaticBet(){
        return Math.round(Math.round(money/10.0));
    }
}