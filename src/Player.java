/**
 * This class represents a player object
 *
 * @author Anastasia Tomuz & Connie Liu
 */

import java.util.ArrayList;


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
     * Sets the bet
     * @param newBet
     */
    public void setBet(int newBet){
        bet = newBet;
    }

    public void setBet(){
        bet = automaticBet();
    }

    public int automaticBet(){
        return Math.round(Math.round(money/10.0));
    }

    public int getBet() {
        return bet;
    }

    public String getName() {
        return name;
    }

    public int getSum(){
        return sum;
    }

    public ArrayList<Integer> getHand(){
        return hand;
    }

    public void subtractMoney(int lose) {
        money -= lose;
    }

    public void addMoney(double add) {
        money += add;
    }

    public void setSum(int newSum) {
        sum = newSum;
    }

    public int getMoney() {
        return money;
    }

    //boolean to determine if the player still has money
    public boolean hasMoney() {
        return money > 0;
    }



    /*CARD STUFF FOUND IN EVERY CLASS BUT THE MAIN CLASS*/

    //returns the sum of the player's cards
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
        return hand.contains(1) || hand.contains(14) || hand.contains(27) || hand.contains(40);
    }

    public void clearHand(){
        hand.clear();
    }

    //"setter" method for adding new card to player deck
    public void addCard(int newCard){
        hand.add(newCard);
    }
}