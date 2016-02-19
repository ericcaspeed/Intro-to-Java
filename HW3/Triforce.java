/**
 * @author: Ericca Speed
 * @email: espeed@ucsd.edu
 * @pid: A11295678
 *
 * @compile: javac Triforce.java
 * @run: java Triforce
 */
import java.util.Scanner;

public class Triforce {
  public static void main(String[] args) {
    int size = 0;
    System.out.print("Enter size: ");
    Scanner scnr = new Scanner(System.in);
    size = scnr.nextInt(); //take size from user
    makeTriangle(size); //call makeTriangle of size
  }

  /**
   * Creates upside down triforce symbol of #s
   * @param x height in lines of each triangle
   */
  public static void makeTriangle(int x) {
    int i = 0; //counter for outer for loop
    int numSpaces1 = 0; //number spaces before #s
    int j = 0; //loop counter inner for loops
    int numChar1 = 0; //number # printed each row before additional spaces
    int numSpaces2 = 0; //number spaces after first set of #s
    int numChar2 = 0; //number # after second set of spaces
    for (i = 1; i <= (2 * x); ++i) {
      //for rows 1 to end where end is 2* height of a triangle
      numSpaces1 = i - 1; //num spaces proceeding trianges
      if (i <= x) {
        //if doing the top two triangles
        numChar1 = (2 * x) - (i + numSpaces1); //num # in left triangle
        numChar2 = numChar1; //right triangle #s
        numSpaces2 = i + numSpaces1; //spaces before right triangle
      }
      else {
        numChar1 = (4 * x) - (i + numSpaces1); //bottom triangle #s
        numChar2 = 0; //no second triangle on bottom
        numSpaces2 = 0; //no space needed after bottom triangle
      }

      for (j = 1; j <= numSpaces1; ++j) {
        System.out.print(" "); //print initial spaces
      }

      for (j = 1; j <= numChar1; ++j) {
        System.out.print("#"); //print initial #s
      }

      for (j = 1; j <= numSpaces2; ++j) {
        System.out.print(" "); //print spaces after intial #s
      }

      for (j = 1; j <= numChar2; ++j) {
        System.out.print("#"); //print #s after second set of spaces
      }

      System.out.println(""); //go to next line of triforce
    }
  }
}
