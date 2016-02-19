/**
 *Takes a file and provides the most frequently used words.
 *Displays the amount of words requested by the user.
 *Prints the word and amount of times it appears in the file.
 * @author: Ericca Speed
 * @compile: javac WordCloud.java
 * @run: java WordCloud file numberWords
 */

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class WordCloud {
  private static HashMap<String, Integer> wordFreq =
    new HashMap<String, Integer>();
  //words from input file
  private static HashSet<String> commons = new HashSet<String>();
  //words in common file

  private static FileInputStream c = null;
  private static Scanner commonWords = null;
  //common words text file reading setup

  private static FileInputStream inFile = null;
  private static Scanner inputFile = null;
  //given file reading setup

  private static String aCommonWord = null; //each word read from common.txt
  private static String aFileWord = null; //word read from input file

  /**
   * Provides highest frequency words in input file
   * @param args file name and highest frequency words
   */
  public static void main (String[] args) throws IOException {
    final int ARGS_AMOUNT = 2; //program must take 2 args
    final int FILE_ARG = 0; //file is arg index 0
    final int PRINT_AMOUNT_ARG = 1; //number words to print is arg index 1

    if (args.length != ARGS_AMOUNT) {
      //user didnt enter correct args on command line
      System.out.println("Usage: java WordCloud <file name> <#words>");
    }

    else { //if two args are entered
      String fileName = args[FILE_ARG]; //input file
      String stringWords = args[PRINT_AMOUNT_ARG]; //how many words to show
      int numberWords = Integer.parseInt(stringWords);
      //number of words to print
      int maximumFreq = 0; //how much the most frequent word appears

      inFile = new FileInputStream(fileName);
      inputFile = new Scanner(inFile);
      c = new FileInputStream("/home/linux/ieng6/cs11wb/public/HW6/common.txt");
      commonWords = new Scanner(c); //remaining scanner setup

      SetOfCommonWords(); //common words to hash set
      maximumFreq = MapInputFile(); //input file to hash map and finds
      //how many times the highest frequency word appears
      //does not inlude words from common.txt

      if (numberWords > wordFreq.size()) {
        numberWords = wordFreq.size();
      }
      //if user wants to print more words than are in the file just
      //print all words and frequencies

      PrintLargest(numberWords, maximumFreq);
      //prints numberWords words of highest frequency
      //caution: deletes printed words from hash map

      inputFile.close();
      commonWords.close(); //close scanners
    }
  }


  /**
   * Changes a given string to all lowercase and only a-z letters
   * @param word String that will be changed
   * @return changed string
   */
  public static String CapitalAndPunctuationRemoval(String word) {
      word = word.replaceAll("[^a-zA-Z]", ""); //remove punctuation
      word = word.toLowerCase(); //make word lowercase
      return word;
  }


  /**
   * Stores common.txt words to HashSet commons
   */
  public static void SetOfCommonWords() {
    while (commonWords.hasNext() == true) {
      aCommonWord = commonWords.next();
      aCommonWord = CapitalAndPunctuationRemoval(aCommonWord);
      commons.add(aCommonWord);
    } //reads in all common words and stores in HashSet commons
  }


  /**
   * Places words from input file into hash map with values of their frequency
   * But does not place words that are also in common.txt
   * @return Frequency of most occuring word in original hashmap for input file
   */
  public static int MapInputFile() {
    int maxFreq = 0; //initialize max freq of any word while mapping

    while (inputFile.hasNext() == true) { //not end of file
      aFileWord = inputFile.next(); //read next word
      aFileWord = CapitalAndPunctuationRemoval(aFileWord); //normalize words

      if (commons.contains(aFileWord) == false &&
          wordFreq.containsKey(aFileWord) == false) {
        //if not a common word and not in map
        wordFreq.put(aFileWord, 1);
      } //put in word with frequency of 1

      else if (commons.contains(aFileWord) == false &&
               wordFreq.containsKey(aFileWord) == true) {
        int freq = (wordFreq.get(aFileWord));
        freq++; //add to frequency count if already in map
        wordFreq.put(aFileWord, freq); //update map

        if (freq > maxFreq) {
          maxFreq = freq; //if a freq is greater it is new maxFreq
        }
      }
    }
    return maxFreq;
  }


  /**
   * Prints keys from inputfile hashmap in order of descending frequency
   * @param printThisMany How many words to be printed
   * @param maxVal Initial max of original hashmap of input file
   */
  public static void PrintLargest(int printThisMany, int maxVal) {
    int val = maxVal; //initial max freq found previously
    String wordCopy = null;

    for (int i = 0; i < printThisMany; i++) {
      innerblock: {
        for (String w : wordFreq.keySet()) { //each key in hashmap
          if (wordFreq.get(w) == val) { //if key has the frequency value print
            System.out.println(w + " : " + val);
            wordCopy = w; //save which word for deletion
            break innerblock; //word is printed so exit block to update counter
          }
        }
      }
      wordFreq.remove(wordCopy); //delete word from hashmap
      val = getMaxFreq(); //find new max frequency in updated hashmap
    }
  }


  /**
   * Finds maximum value in hash map from input file
   * @return Largest value in hash map
   */
  public static int getMaxFreq() {
    int max = 0;

    for (String w : wordFreq.keySet()) {
      if (wordFreq.get(w) > max) {
        max = wordFreq.get(w);
      }
    }
    return max;
  }

}