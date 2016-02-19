/**
 * @author: Ericca Speed
 * @email: espeed@ucsd.edu
 * @pid: A11295678
 * @about: Draws out CS11WBKU Java UC San Diego
 *
 * @compile: javac -cp turtleClasses.jar:. CS11TurtleGraphics.java
 * @run: java -cp turtleClasses.jar:. CS11TurtleGraphics
 */

import turtleClasses.*;
import java.awt.Color;

public class CS11TurtleGraphics extends Turtle {
  private final static int CHAR_WIDTH = 40;
  private final static int CHAR_HEIGHT = 80;
  private final static int PADDING_BETWEEN_CHARS = 40;
  private final static int PADDING_BETWEEN_LINES = 40;
  private final static int CHAR_SPACING = CHAR_WIDTH  + PADDING_BETWEEN_CHARS;
  private final static int LINE_SPACING = CHAR_HEIGHT + PADDING_BETWEEN_LINES;

  private final static int START_X_1 = 40; // starting x offset for line 1
  private final static int START_X_2 = 40; // starting x offset for line 2
  private final static int START_X_3 = 40; // starting x offset for line 3
  private final static int START_Y = 40;   // starting y offset

  private final static int PEN_WIDTH = 12;
  private final static Color PEN_COLOR = Color.RED;
  private final static int WORLD_WIDTH = 1080;
  private final static int WORLD_HEIGHT = 480;

  /*
   * Delay between turtle actions (turns, moves) in milliseconds
   * 1000 = 1 sec. so 200 = 0.2 sec.
   */
  private final static int DELAY = 200;

  /**
   * The constructor. Sets up the turtle world.
   */
  public CS11TurtleGraphics(World w, int delay) {
    super(w, delay);
  }

  /**
   * Draw the letter C at position x, y
   * @param x - starting x position
   * @param y - starting y position
   */
  private void drawC(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); //face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
  }

  /**
   * Draw the letter S at position x, y
   * @param x - starting x position
   * @param y - starting y position
   */
  private void drawS(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); //face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH); //top horizonal line of S
    turnRight();
    forward((CHAR_HEIGHT) / 2); //first vertical line section
    turnLeft();
    forward(CHAR_WIDTH); //middle horiz line
    turnRight();
    forward((CHAR_HEIGHT) / 2);
    turnRight();
    forward(CHAR_WIDTH);
  }

  /**
   *Draws number 1 at x,y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void draw1(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //face right
    forward((CHAR_WIDTH / 2));
    final int EIGHTH_TURN_RIGHT = 45; //int for 45 deg right turn
    turnRight();
    turn(EIGHTH_TURN_RIGHT);
    penDown();
    forward((CHAR_WIDTH / 2)); //top diagonal section
    backward((CHAR_WIDTH / 2));
    final int EIGHTH_TURN_LEFT = -45; //int for 45 deg left turn
    turn(EIGHTH_TURN_LEFT);
    forward(CHAR_HEIGHT); //main body
    turnRight();
    forward((CHAR_WIDTH) / 2); //bottom horizontal line
    backward(CHAR_WIDTH);
  }

  /**
   *Draws letter W at x, y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawW(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //face right
    turnRight();
    penDown();
    forward(CHAR_HEIGHT); //first leg of W
    final int EIGHTH_TURN_LEFT = -45; //int to turn left 45 deg
    turn(EIGHTH_TURN_LEFT);
    turnLeft();
    final int MIDDLE_W_LENGTH = 28; //length of middle leg of W
    forward(MIDDLE_W_LENGTH);
    turnRight();
    forward(MIDDLE_W_LENGTH);
    turnLeft();
    turn(EIGHTH_TURN_LEFT);
    forward(CHAR_HEIGHT);
  }

  /**
   *Draws letter B at x, y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawB(int x, int y) {
    penUp();
    moveTo(x,y); //upper left of charblock
    turnToFace(getXPos() + 1, getYPos()); //face right
    penDown();
    forward(CHAR_WIDTH / 2); //top horizontal bar
    final int EIGHTH_TURN_RIGHT = 45; //int to turn right 45 deg
    turn(EIGHTH_TURN_RIGHT);
    final int BUMP_ON_B = 29; //length for bumps on letter B
    forward(BUMP_ON_B); //bump one
    turnRight();
    forward(BUMP_ON_B);
    turn(EIGHTH_TURN_RIGHT);
    forward(CHAR_WIDTH / 2);
    backward(CHAR_WIDTH / 2);
    turnRight();
    turnRight();
    turn(EIGHTH_TURN_RIGHT);
    forward(BUMP_ON_B); //bump two
    turnRight();
    forward(BUMP_ON_B);
    turn(EIGHTH_TURN_RIGHT);
    forward(CHAR_WIDTH / 2); //bottom horizontal bar
    turnRight();
    forward(CHAR_HEIGHT); //vertical bar
  }

  /**
   *Draws letter K at x, y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawK(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT / 2); //top half of K vertical line
    turnLeft();
    final int EIGHTH_TURN_LEFT = -45; //int to turn left 45 deg
    turn(EIGHTH_TURN_LEFT);
    final int K_LEG_LENGTH = 54; //length of leg of letter K
    forward(K_LEG_LENGTH); //top leg of K
    backward(K_LEG_LENGTH);
    turnRight();
    forward(K_LEG_LENGTH); //bottom leg of K
    backward(K_LEG_LENGTH);
    final int EIGHTH_TURN_RIGHT = 45; //int to turn right 45 deg
    turn(EIGHTH_TURN_RIGHT);
    forward(CHAR_HEIGHT / 2); //bottom half of K vertical line
  }

  /**
   *Draws the letter U at x, y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawU(int x, int y) {
    penUp();
    moveTo(x,y); //upper left of char block
    turnToFace(getXPos() + 1, getYPos()); //face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT); //left vertical line
    turnLeft();
    forward(CHAR_WIDTH); //bottom horizontal line
    turnLeft();
    forward(CHAR_HEIGHT); //right vertical line
  }

  /**
   *Draws letter J at x, y
   *@param x - starting x position
   *@param y- starting y position
   */
  private void drawJ(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //face right
    forward(CHAR_WIDTH); //move to right side no drawing
    penDown();
    turnRight();
    forward(CHAR_HEIGHT); //vertical line in J
    turnRight();
    forward(CHAR_WIDTH); //bottom horizonal line in J
    turnRight();
    forward(CHAR_HEIGHT / 4); //hook at end of J tail
  }

  /**
   *Draws letter A at x,y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawA(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    forward(CHAR_WIDTH); //top horizontal bar in A
    turnRight();
    forward(CHAR_HEIGHT); //right vertical bar in A
    backward(CHAR_HEIGHT / 2);
    turnRight();
    forward(CHAR_WIDTH); // center horizonal bar in A
    turnLeft();
    forward(CHAR_HEIGHT / 2);
    backward(CHAR_HEIGHT); //left vertical line in A
  }

  /**
   *Draws letter V at x,y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawV(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    final int DIAG_TURN_RIGHT = 76; //int to turn right 76 deg for legs of V
    turn(DIAG_TURN_RIGHT);
    final int V_DIAGONAL = 83; //length of each leg of letter V
    forward(V_DIAGONAL); //left leg of V
    final int DIAG_TURN_LEFT = -76; //int to turn left 76 deg for legs of V
    turn(DIAG_TURN_LEFT);
    turn(DIAG_TURN_LEFT);
    forward(V_DIAGONAL); //right leg of V
  }

  /**
   *Draws letter N at x,y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawN(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT);
    final int N_DIAG_ANGLE = -27; //left turn ang for 1st diagonal section of N
    turn(N_DIAG_ANGLE);
    final int N_DIAG_LENGTH = 89; //length of diagonal in N
    forward(N_DIAG_LENGTH);
    final int N_DIAG_ANGLE2 = -63; //left turn ang for 2nd diagonal section of N
    turn(N_DIAG_ANGLE2);
    turnLeft();
    forward(CHAR_HEIGHT);
  }

  /**
   *Draws letter D at x,y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawD(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    forward(CHAR_WIDTH / 2);
    final int TOP_D_ANGLE = 63; //int to turn right at top of D
    turn(TOP_D_ANGLE);
    final int D_CURVED_LENGTH = 45; //length of curved section side of D
    forward(D_CURVED_LENGTH);
    final int MID_D_ANGLE = 54; //int to turn right at middle of D
    turn(MID_D_ANGLE);
    forward(D_CURVED_LENGTH);
    turn(TOP_D_ANGLE); //bottom angle same as top because symmetry
    forward(CHAR_WIDTH / 2);
    turnRight();
    forward(CHAR_HEIGHT);
  }

  /**
   *Draws letter I at x,y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawI(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    forward(CHAR_WIDTH); //top horizontal bar of I
    backward(CHAR_WIDTH / 2);
    turnRight();
    forward(CHAR_HEIGHT); //main body of I
    turnRight();
    forward(CHAR_WIDTH / 2); //bottom horizontal bar of I
    backward(CHAR_WIDTH);
  }

  /**
   *Draws letter E at x,y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawE(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    forward(CHAR_WIDTH); //top horizontal bar
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT / 2);
    turnLeft();
    forward(CHAR_WIDTH / 2); //middle horizontal bar
    backward(CHAR_WIDTH / 2);
    turnRight();
    forward(CHAR_HEIGHT / 2);
    turnLeft();
    forward(CHAR_WIDTH); //bottom horizontal bar
  }

  /**
   *Draw letter G at x, y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawG(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    forward(CHAR_WIDTH); //top horizontal bar of G
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT); //vertical bar of G
    turnLeft();
    forward(CHAR_WIDTH); //bottom bar of G
    turnLeft();
    forward(CHAR_HEIGHT / 2); //hook section of G
    turnLeft();
    forward(CHAR_WIDTH / 2);
  }

  /**
   *Draws letter O at x, y
   *@param x - starting x position
   *@param y - starting y position
   */
  private void drawO(int x, int y) {
    penUp();
    moveTo(x,y); //upper left corner of char block
    turnToFace(getXPos() + 1, getYPos()); //turn right
    penDown();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    turnRight();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
  }

  /**
   * The main method starts at program execution and calls methods
   * in this class to draw letters as required in the assignment
   */
  public static void main(String[] args) {
    int startX1 = START_X_1;
    int startX2 = START_X_2;
    int startX3 = START_X_3;
    int startY  = START_Y;

    int x, y;

    World w = new World(WORLD_WIDTH, WORLD_HEIGHT);
    CS11TurtleGraphics myTurtle = new CS11TurtleGraphics(w, DELAY);

    myTurtle.setPenWidth(PEN_WIDTH);
    myTurtle.setPenColor(PEN_COLOR);

    // Line1: CSE11WBKU
    x = startX1;
    y = startY;
    myTurtle.drawC(x, y);

    x += CHAR_SPACING; //move starting point over for next character
    myTurtle.drawS(x, y); //letter s

    x += CHAR_SPACING;
    myTurtle.draw1(x,y); //first 1

    x += CHAR_SPACING;
    myTurtle.draw1(x,y); //second 1

    x += CHAR_SPACING;
    myTurtle.drawW(x,y); //letter W

    x += CHAR_SPACING;
    myTurtle.drawB(x,y); //letter B

    x += CHAR_SPACING;
    myTurtle.drawK(x,y); //letter K

    x += CHAR_SPACING;
    myTurtle.drawU(x,y); //letter U

    x = startX2;//start line 2 reads JAVA
    y = startY + LINE_SPACING;
    myTurtle.drawJ(x,y); //letter J

    x += CHAR_SPACING;
    myTurtle.drawA(x,y); //letter A

    x +=CHAR_SPACING;
    myTurtle.drawV(x,y); //letter V

    x += CHAR_SPACING;
    myTurtle.drawA(x,y); //letter A

    x = startX3; //line 3 reads UC SAN DIEGO
    y = y + LINE_SPACING;
    myTurtle.drawU(x,y); //letter U

    x += CHAR_SPACING;
    myTurtle.drawC(x,y);//letter C

    x += CHAR_SPACING / 2; //space between UC and SAN

    x += CHAR_SPACING;
    myTurtle.drawS(x,y); //letter S

    x += CHAR_SPACING;
    myTurtle.drawA(x,y); //draw A

    x += CHAR_SPACING;
    myTurtle.drawN(x,y); //letter N

    x += CHAR_SPACING / 2; //space between SAN and DIEGO

    x += CHAR_SPACING;
    myTurtle.drawD(x,y); //letter D

    x += CHAR_SPACING;
    myTurtle.drawI(x,y); //letter I

    x += CHAR_SPACING;
    myTurtle.drawE(x,y); //letter E

    x += CHAR_SPACING;
    myTurtle.drawG(x,y); //letter G

    x += CHAR_SPACING;
    myTurtle.drawO(x,y); //letter O
  }
}
