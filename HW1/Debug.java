/**
 * @author: Ericca Speed
 * @email: espeed@ucsd.edu
 * @pid: A11295678
 * @about: This program should prompt for the user's full name (not just 
 *         their first name and print back "Hello, <name>" but there 
 *         are errors that you'll need to fix first. Double check
 *         the expected output!
 *
 * @compile: javac Debug.java
 * @run: java Debug
 *       Enter your name: Adam Jundt
 *       Your name is: Adam Jundt
 */

import java.util.Scanner;

public class Debug {
  
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    // Scanner scnr = new Scanner();
    System.out.print("Enter your name: ");
    // System.out.print("Enter your name: ")
    String name = scnr.nextLine();
    // String name = scnr.next();
    System.out.println("Your name is: " + name);
    // System.out.println("Your name is: " name);
  }
}