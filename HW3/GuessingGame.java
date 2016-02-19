/**
 * @author: Ericca Speed
 * @email: espeed@ucsd.edu
 * @pid: A11295678
 *
 * @compile: javac GuessingGame.java
 * @run: java GuessingGame
 */
import java.util.Scanner;

public class GuessingGame {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    System.out.println("Your number is in this range... (enter 2 numbers)");
    int lowerBound = 0; //initialize lower bound
    int upperBound = 0; //initialize upper bound
    lowerBound = scnr.nextInt() - 1; //user inputs low end of range
    upperBound = scnr.nextInt() + 1; //user inputs high end of range
    //bounds +/- 1 so max min entered are valid, should not be rejected
    //so +/- 1 because guessing range is exclusive of bound values
    System.out.print("Type 'h' for too high, 'l' for too low, and 'c' if I");
    System.out.println(" got it right"); //instructions print out
    int guess = 0; //computer's guess for your number
    guess = average(lowerBound, upperBound); //initial guess

    if (lowerBound + 1 == upperBound - 1) {
      System.out.println("I win, it's " + (lowerBound + 1));
      //check input, if same then answer is obvious
    }
    else {
      System.out.println("Is it " + guess + "?");
      String info = ""; //info given to computer
      info = scnr.next();
      char hint = 'a'; //initialize hint to test
      hint = info.charAt(0); //turns input into char for easier loop condition
      while (hint != 'c') {
        //when asking if correct number is higher or lower
        //rejection is when h or l is input, that guess is incorrect
        if (hint == 'l') {
          lowerBound = guess; //reject all value of guess and lower
          guess = average(guess, upperBound); //new guess

          if (guess == lowerBound + 1 && guess == upperBound - 1) {
          System.out.println("I win, it's " + guess);
          //if upper and lower have already been rejected must be number between
          break; //leave while loop
          }
          else {
            //don't have answer yet ask again
            System.out.println("Is it " + guess + "?");
            info = scnr.next();
            hint = info.charAt(0);
            continue; //evaluate another input
          }
        }

        else if (hint == 'h') {
          upperBound = guess; //reject all value guess and higher
          guess = average(lowerBound, guess); //new guess inside new bounds

          if (guess == upperBound - 1 && guess == lowerBound + 1) {
          System.out.println("I win, it's " + guess);
          //if upper and lower have already been rejected must be number between
          break; //leave while loop
          }
          else {
            //don't know the correct answer yet so ask again
            System.out.println("Is it " + guess + "?");
            info = scnr.next();
            hint = info.charAt(0);
            continue; //evaluate another input
          }
        }

        else {
          System.out.println("Not a valid input");
          //check input is c or h or l, if not quits
          break; //quits
        }
      }

      if (hint == 'c') {
        System.out.println("I always win"); //computer guesses correctly
      }

    }
  }

  /**
   * Calculates the rounded down average of two numbers
   * @param low first number
   * @param high second number
   * @return int calculated average
   */
  public static int average(int low, int high) {
    //compute rounded down average of two numbers
    int avg = 0;
    avg = (low + high) / 2;
    return avg;
  }
}
