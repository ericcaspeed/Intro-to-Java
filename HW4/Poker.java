import java.util.Scanner;

/**
 * Description: Compares poker hands held by two players
 * compile: javac Poker.java
 * run: java Poker
 *
 * @author: Ericca Speed
 */
public class Poker {
  public static final int NUM_CARDS = 5; //number cards in hand
  public static final int PLAYER_1 = 1; //player 1 number
  public static final int PLAYER_2 = 2; //player 2 number
  //numerical ranking of best hand to worst hand follows
  public static final int STRAIGHT_FLUSH_RANK = 9;
  public static final int FOUR_OF_KIND_RANK = 8;
  public static final int FULL_HOUSE_RANK = 7;
  public static final int FLUSH_RANK = 6;
  public static final int STRAIGHT_RANK = 5;
  public static final int THREE_OF_KIND_RANK = 4;
  public static final int TWO_PAIR_RANK = 3;
  public static final int ONE_PAIR_RANK = 2;
  public static final int HIGH_CARD_RANK = 1;
  public static int i = 0; //card index

  /**
   * Main method takes user input for two players and compares thier
   * poker hands to determine the winner
   */
  public static void main(String[] args) {
    //player 1 entry
    System.out.print("Enter Player 1's cards: ");
    int[] cardValues = new int[NUM_CARDS]; //integer card value
    char[] cardSuits = new char[NUM_CARDS]; //suits as chars
    int handRank1 = 0; //initialize rank of player one's hand
    Scanner scnr = new Scanner(System.in);
    for (i = 0; i < NUM_CARDS; ++i) {
      //read user input into two arrays
      cardValues[i] = scnr.nextInt();
      cardSuits[i] = scnr.next().charAt(0);
    }
    PrintHand(1, cardValues, cardSuits); //print hand as shown on card
    handRank1 = DiscoverAndRankHand(cardValues, cardSuits);
    //rank and print best hand


    //player 2 entry
    System.out.print("Enter Player 2's cards: ");
    int[] cardValues2 = new int[NUM_CARDS]; //integer card value
    char[] cardSuits2 = new char[NUM_CARDS]; //suits as chars
    int handRank2 = 0; //initialize rank of player one's hand
    for (i = 0; i < NUM_CARDS; ++i) {
      //read user input into two arrays
      cardValues2[i] = scnr.nextInt();
      cardSuits2[i] = scnr.next().charAt(0);
    }
    PrintHand(2, cardValues2, cardSuits2); //print hand as shown on card
    handRank2 = DiscoverAndRankHand(cardValues2, cardSuits2);
    //rank and print best hand


    CompareHands(handRank1, handRank2); //compare hands
  }


  /**
   * Prints entered card values as their face representation
   * Eg 1 is A, 11 is J, 12 is Q, 13 is K
   * @param player The player who's hand is being tested
   * @param values Integer values of cards in hand
   * @param suits Suit of each card in hand
   */
  public static void PrintHand(int player, int[] values, char[] suits) {
    String[] cardFaceValues = new String[NUM_CARDS];
    for (i = 0; i < NUM_CARDS; ++i) {
      if (values[i] == 1) {
        cardFaceValues[i] = "A"; //card of value 1 is ace
      }
      else if (values[i] >= 2 && values[i] <= 10) {
        cardFaceValues[i] = ("" + values[i]); //card value 2 thru 9 is itself
      }
      else if (values[i] == 11) {
        cardFaceValues[i] = "J"; //card value 11 is jack
      }
      else if (values[i] == 12) {
        cardFaceValues[i] = "Q"; //card value 12 is queen
      }
      else if (values[i] == 13) {
        cardFaceValues[i] = "K"; //card value 13 is king
      }
      else {
        System.out.print("Not a valid card");
        break;
      }
    }

    System.out.print("Player " + player + "'s hand: ");
    for (i = 0; i < NUM_CARDS; i++) {
      System.out.print(cardFaceValues[i] + suits[i] + " ");
    }
    System.out.println("");
  }


  /**
   * Tests if poker hand is a straight flush
   * @param value integer values of cards in hand
   * @param suit suits of cards in hand
   * @return is this hand a straight flush
   */
  public static boolean StraightFlush(int[] value, char[] suit) {
    boolean sequence = false; //result of in order testing
    boolean sameSuit = false; //result of test if all same suit
    boolean isThisHand = false; //initialize result of hand test

    sequence = Straight(value); //test for straight sequence
    sameSuit = Flush(suit); //test for flush

    if (sequence == true && sameSuit == true) {
      isThisHand = true; //if in sequence and all same suit
    }
    else {
      isThisHand = false; //not a straight flush
    }

    return isThisHand;
  }


  /**
   * Tests if poker hand has a 4 of a kind
   * @param value integer value of cards in hand
   * @return if it is a 4 of a kind hand
   */
  public static boolean FourOfAKind(int[] value) {
    boolean isThisHand = false; //initilize result of hand test

    if ((value[0] == value[1] && value[1] == value[2] &&
         value[2] == value[3] && value[3] != value[4]) ||
        (value[1] == value[2] && value[2] == value[3] &&
         value[3] == value[4] && value[0] != value[1])) {
      //if first four values or last four values are same
      isThisHand = true;
    }
    else {
      isThisHand = false; //if there arent 4 of same card value
    }

    return isThisHand;
  }


  /**
   * Tests if poker hand has a full house
   * @param value integer value of cards in hand
   * @return if hand is a full house hand
   */
  public static boolean FullHouse(int[] value) {
    boolean isThisHand = false; //initialize result of hand test

    if ((value[0] == value[1] && value[1] == value[2] && value[3] == value[4])|| 
        (value[0] == value[1] && value[2] == value[3] &&
         value[3] == value[4])) {
      //if cards 0 to 2 are same and 3 and 4 are same
      //or if cards 0 and 1 are same and 2 to 4 are same
      isThisHand = true; //is full house
    }
    else {
      isThisHand = false; //not full house
    }

    return isThisHand;
  }


  /**
   * Tests if poker hand has a flush
   * @param suit suits of each card in hand
   * @return if hand is a flush hand
   */
  public static boolean Flush(char[] suit) {
    boolean isThisHand = false; //initialize result of hand test

    for (i = 0; i < NUM_CARDS; ++i) {
      if (suit[i] == suit[0]) {
        isThisHand = true;
      }
      else {
        isThisHand = false;
        break;
      }
    }

    return isThisHand;
  }


  /**
   * Tests if poker hand has a straight
   * @param value integer value of cards in hand
   * @return if hand is a straight hand
   */
  public static boolean Straight(int[] value) {
    boolean isThisHand = false; //initializes result of hand test

    if ((value[0] == value[1] - 1 && value[1] == value[2] - 1 &&
         value[2] == value[3] - 1 && value[3] == value[4] - 1) ||
        (value[0] == 1 && value[1] == value[2] - 1 &&
         value[2] == value[3] - 1 && value[3] == value[4] - 1 &&
         value[4] == 13)) {
      //if numbers are in sequence OR ace in beginning and
      //10,J,Q,K in index 1to4 for a 10,J,Q,K,A sequence
      isThisHand = true;
    }
    else {
      isThisHand = false; //not in a sequence
    }

    return isThisHand;
  }


  /**
   * Tests if poker hand has a three of a kind
   * @param value integer value of cards in hand
   * @return if hand is a three of a kind hand
   */
  public static boolean ThreeOfAKind(int[] value) {
    boolean isThisHand = false; //initializes result of hand test

    if ((value[0] == value[1] && value[1] == value[2]) ||
        (value[1] ==  value[2] && value[2] == value[3]) ||
        (value[2] == value[3] && value[3] == value[4])) {
      //if cards 0 to 2 are same (first 3)
      //or if cards 1 to 3 are same (middle 3)
      //or if cards 2 to 4 are same (last 3)
      isThisHand = true; //is three of kind
    }
    else {
      isThisHand = false; //not three of kind
    }

    return isThisHand;
  }


  /**
   * Tests if poker hand has two pairs
   * @param value integer value of cards in hand
   * @return if hand is a two pair hand
   */
  public static boolean TwoPair(int[] value) {
    boolean isThisHand = false; //initializes result of hand test

    if ((value[0] == value[1] && value[2] == value[3]) ||
        (value[1] == value[2] && value[3] == value[4]) ||
        (value[0] == value[1] && value[3] == value[4])) {
      //if there are two same values next to each other twice
      isThisHand = true; //have two pair
    }
    else {
      isThisHand = false;
    }

    return isThisHand;
  }


  /**
   * Tests if poker hand has one pair
   * @param value integer value of cards in hand
   * @return if hand is a one pair hand
   */
  public static boolean OnePair(int[] value) {
    boolean isThisHand = false; //initializes result of hand test

    if (value[0] == value[1] || value[1] == value[2] ||
        value[2] == value[3] || value[3] == value[4]) {
      //if there are two same values next to each other
      isThisHand = true; //have one pair
    }
    else {
      isThisHand = false;
    }

    return isThisHand;
  }


  /**
   * Finds best poker hand and ranks hand
   * @param value integer value of cards in hand
   * @param suit suits of cards in hand
   * @return rank of poker hand
   */
  public static int DiscoverAndRankHand(int[] value, char[] suit) {
    int handRank = 0; //initialize rank of hand
    System.out.print("Best hand: ");
    //tests if method for each type of hand is true
    //tests best hands to worst hands so the best hand is chosen
    //if a hand method returns true the hand is ranked for comparison later
    //if no method is true then hand is high card
    if (StraightFlush(value, suit) == true) {
      System.out.println("STRAIGHT FLUSH");
      handRank = STRAIGHT_FLUSH_RANK;
    }
    else if (FourOfAKind(value) == true) {
      System.out.println("FOUR OF A KIND");
      handRank = FOUR_OF_KIND_RANK;
    }
    else if (FullHouse(value) == true) {
      System.out.println("FULL HOUSE");
      handRank = FULL_HOUSE_RANK;
    }
    else if (Flush(suit) == true) {
      System.out.println("FLUSH");
      handRank = FLUSH_RANK;
    }
    else if (Straight(value) == true) {
      System.out.println("STRAIGHT");
      handRank = STRAIGHT_RANK;
    }
    else if (ThreeOfAKind(value) == true) {
      System.out.println("THREE OF A KIND");
      handRank = THREE_OF_KIND_RANK;
    }
    else if (TwoPair(value) == true) {
      System.out.println("TWO PAIR");
      handRank = TWO_PAIR_RANK;
    }
    else if (OnePair(value) == true) {
      System.out.println("ONE PAIR");
      handRank = ONE_PAIR_RANK;
    }
    else {
      System.out.println("HIGH CARD");
      handRank = HIGH_CARD_RANK;
    }

    return handRank;
  }


  /**
   * Compare the rank of two poker hands to determine winner
   * Prints winner or tie
   * @param rank1 rank of player 1's hand
   * @param rank2 rank of player 2's hand
   */
  public static void CompareHands(int rank1, int rank2) {
    if (rank1 > rank2) { //player one has better hand
      System.out.println("Player 1 wins!");
    }
    else if (rank2 > rank1) { //player two has better hand
      System.out.println("Player 2 wins!");
    }
    else { //tie hands
      System.out.println("Tie!");
    }
  }

}
