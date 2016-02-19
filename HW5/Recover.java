/**
 * @author Ericca Speed
 */

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.util.Arrays;

public class Recover {

  /**
   * Recovers deleted files from a memory card
   */
  public static void main(String[] args) throws IOException {
    final int NUM_BYTES = 512; //num bytes per block
    final int END_OF_FILE = -1; //end of file return value

    FileInputStream inS = null;
    inS = new FileInputStream("/home/linux/ieng6/cs11wb/public/HW5/card.raw");
    //input stream
    BufferedInputStream buffInStream = new BufferedInputStream(inS);
    //buffer input

    FileOutputStream outStream = null;
    BufferedOutputStream buffOutStream = null;
    //output stream

    byte[] block = new byte[NUM_BYTES]; //each block is NUM_BYTES of bytes

    byte[] checkjpg = {(byte)0xff, (byte)0xd8, (byte)0xff, (byte)0xe0};
    byte[] checkjpg2 = {(byte)0xff, (byte)0xd8, (byte)0xff, (byte)0xe1};
    //starting bytes of a jpg file

    int file = 0; //file number

    byte[] beginningOfBlock = new byte[checkjpg.length];
    //initialize array to test if new jpg

    while (buffInStream.read(block) != END_OF_FILE) {
      //while not end of file

      for (int i = 0; i < checkjpg.length; i++) {
        beginningOfBlock[i] = block[i];
      } //first bytes of block for jpg testing

      if (Arrays.equals(beginningOfBlock, checkjpg) ||
          Arrays.equals(beginningOfBlock, checkjpg2)) {
        if (file != 0) { //if starting new file
          buffOutStream.flush();
          //make sure output has gone to file
        }
        file++; //change to next file if starting new jpg
        outStream = new FileOutputStream(file + ".jpg");
        buffOutStream = new BufferedOutputStream(outStream);
        //create new file and buffer output if new jpg
      }

      buffOutStream.write(block); //write block to file
    }

    buffOutStream.flush(); //output all to file
    buffOutStream.close(); //close stream
  }
}