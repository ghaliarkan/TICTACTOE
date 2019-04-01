import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics, non-OO version.
 * All variables/methods are declared as static (belong to the class)
 *  in the non-OO version.
 */
public class test {
   // Name-constants to represent the seeds and cell contents
   public static final int EMPTY = 0;
   public static final int CROSS = 1;
   public static final int NOUGHT = 2;
 
   // Name-constants to represent the various states of the game
   public static final int PLAYING = 0;
   public static final int DRAW = 1;
   public static final int CROSS_WON = 2;
   public static final int NOUGHT_WON = 3;
 
   // The game board and the game status
   public static int ROW3 = 3, COL3 = 3; // number of rows and columns
   public static int ROW4 = 4, COL4 = 4; // number of rows and columns
   public static int ROW5 = 5, COL5 = 5; // number of rows and columns
   public static int[][] board = new int[ROW3][COL3]; // game board in 2D array
   public static int[][] board4 = new int[ROW4][COL4]; // game board in 2D array
   public static int[][] board5 = new int[ROW5][COL5]; // game board in 2D array
                                                      //  containing (EMPTY, CROSS, NOUGHT)
   public static int currentState;  // the current state of the game
                                    // (PLAYING, DRAW, CROSS_WON, NOUGHT_WON)
   public static int currentPlayer; // the current player (CROSS or NOUGHT)
   public static int currntRow, currentCol; // current seed's row and column
 
   public static Scanner in = new Scanner(System.in); // the input Scanner
 
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      // Initialize the game-board and current status
      startGame();
   }
 
   /** Initialize the game-board contents and the current states */
   public static void startGame() {
      System.out.println("Please choose the game :");
      System.out.println("1. Scalable 3x3 ");
      System.out.println("2. Scalable 4x4 ");
      System.out.println("3. Scalable 5x5 ");
      int choose = in.nextInt() - 1;

      if(choose == 0)
      {
         game3x3();
      }
      else if(choose == 1)
      {
         game4x4();
      }
      else if(choose == 2)
      {
         game5x5();
      }
      else{
         System.out.print("Please choose 1-3");
         startGame();
      }

   }

   public static void game3x3()
   {
      for (int row = 0; row < ROW3; ++row) {
         for (int col = 0; col < COL3; ++col) {
            board[row][col] = EMPTY;  // all cells empty
         }
      }
      currentState = PLAYING; // ready to play
      currentPlayer = CROSS;  // cross plays first

      do {
         playerMove(currentPlayer); // update currentRow and currentCol
         updateGame(currentPlayer, currntRow, currentCol); // update currentState
         printBoard();
         // Print message if game-over
         if (currentState == CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == DRAW) {
            System.out.println("It's a Draw! Bye!");
         }
         // Switch player
         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
      } while (currentState == PLAYING); // repeat if not game-over
   }
   public static void game4x4()
   {
      for (int row = 0; row < ROW4; ++row) {
         for (int col = 0; col < COL4; ++col) {
            board4[row][col] = EMPTY;  // all cells empty
         }
      }
      currentState = PLAYING; // ready to play
      currentPlayer = CROSS;  // cross plays first

      do {
         playerMove4(currentPlayer); // update currentRow and currentCol
         updateGame4(currentPlayer, currntRow, currentCol); // update currentState
         printBoard4();
         // Print message if game-over
         if (currentState == CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == DRAW) {
            System.out.println("It's a Draw! Bye!");
         }
         // Switch player
         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
      } while (currentState == PLAYING); // repeat if not game-over
   }
   public static void game5x5()
   {
    //   int[][] board = new int[ROW5][COL5];
      for (int row = 0; row < ROW5; ++row) {
         for (int col = 0; col < COL5; ++col) {
            board5[row][col] = EMPTY;  // all cells empty
         }
      }
      currentState = PLAYING; // ready to play
      currentPlayer = CROSS;  // cross plays first

      do {
         playerMove5(currentPlayer); // update currentRow and currentCol
         updateGame5(currentPlayer, currntRow, currentCol); // update currentState
         printBoard5();
         // Print message if game-over
         if (currentState == CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == DRAW) {
            System.out.println("It's a Draw! Bye!");
         }
         // Switch player
         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
      } while (currentState == PLAYING); // repeat if not game-over
   }
 
   /** Player with the "theSeed" makes one move, with input validation.
       Update global variables "currentRow" and "currentCol". */
   public static void playerMove(int theSeed) {
      boolean validInput = false;  // for input validation
      do {
         if (theSeed == CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
         int col = in.nextInt() - 1;
         if (row >= 0 && row < ROW3 && col >= 0 && col < COL3 && board[row][col] == EMPTY) {
            currntRow = row;
            currentCol = col;
            board[currntRow][currentCol] = theSeed;  // update game-board content
            validInput = true;  // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  // repeat until input is valid
   }
 
   public static void playerMove4(int theSeed) {
      boolean validInput = false;  // for input validation
      do {
         if (theSeed == CROSS) {
            System.out.print("Player 'X', enter your move (row[1-4] column[1-4]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-4] column[1-4]): ");
         }
         int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
         int col = in.nextInt() - 1;
         if (row >= 0 && row < ROW4 && col >= 0 && col < COL4 && board4[row][col] == EMPTY) {
            currntRow = row;
            currentCol = col;
            board4[currntRow][currentCol] = theSeed;  // update game-board content
            validInput = true;  // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  // repeat until input is valid
   
   }
   public static void playerMove5(int theSeed) {
      boolean validInput = false;  // for input validation
      do {
         if (theSeed == CROSS) {
            System.out.print("Player 'X', enter your move (row[1-5] column[1-5]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-5] column[1-5]): ");
         }
         int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
         int col = in.nextInt() - 1;
         if (row >= 0 && row < ROW5 && col >= 0 && col < COL5 && board5[row][col] == EMPTY) {
            currntRow = row;
            currentCol = col;
            board5[currntRow][currentCol] = theSeed;  // update game-board content
            validInput = true;  // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  // repeat until input is valid
   }
 
   /** Update the "currentState" after the player with "theSeed" has placed on
       (currentRow, currentCol). */
   public static void updateGame(int theSeed, int currentRow, int currentCol) {
      if (hasWon(theSeed, currentRow, currentCol)) {  // check if winning move
         currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
      } else if (isDraw()) {  // check for draw
         currentState = DRAW;
      }
      // Otherwise, no change to currentState (still PLAYING).
   }
 
   /** Update the "currentState" after the player with "theSeed" has placed on
       (currentRow, currentCol). */
   public static void updateGame4(int theSeed, int currentRow, int currentCol) {
      if (hasWon4(theSeed, currentRow, currentCol)) {  // check if winning move
         currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
      } else if (isDraw4()) {  // check for draw
         currentState = DRAW;
      }
      // Otherwise, no change to currentState (still PLAYING).
   }
 
   /** Update the "currentState" after the player with "theSeed" has placed on
       (currentRow, currentCol). */
   public static void updateGame5(int theSeed, int currentRow, int currentCol) {
      if (hasWon5(theSeed, currentRow, currentCol)) {  // check if winning move
         currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
      } else if (isDraw5()) {  // check for draw
         currentState = DRAW;
      }
      // Otherwise, no change to currentState (still PLAYING).
   }
 
   /** Return true if it is a draw (no more empty cell) */
   // TODO: Shall declare draw if no player can "possibly" win
   public static boolean isDraw() {
      for (int row = 0; row < ROW3; ++row) {
         for (int col = 0; col < COL3; ++col) {
            if (board[row][col] == EMPTY) {
               return false;  // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no empty cell, it's a draw
   }

   public static boolean isDraw4() {
      for (int row = 0; row < ROW4; ++row) {
         for (int col = 0; col < COL4; ++col) {
            if (board4[row][col] == EMPTY) {
               return false;  // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no empty cell, it's a draw
   }
   public static boolean isDraw5() {
      for (int row = 0; row < ROW5; ++row) {
         for (int col = 0; col < COL5; ++col) {
            if (board5[row][col] == EMPTY) {
               return false;  // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no empty cell, it's a draw
   }
 
   /** Return true if the player with "theSeed" has won after placing at
       (currentRow, currentCol) */
   public static boolean hasWon(int theSeed, int currentRow, int currentCol) {
      return (board[currentRow][0] == theSeed         // 3-in-the-row
                   && board[currentRow][1] == theSeed
                   && board[currentRow][2] == theSeed
              || board[0][currentCol] == theSeed      // 3-in-the-column
                   && board[1][currentCol] == theSeed
                   && board[2][currentCol] == theSeed
              || currentRow == currentCol            // 3-in-the-diagonal
                   && board[0][0] == theSeed
                   && board[1][1] == theSeed
                   && board[2][2] == theSeed
              || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
                   && board[0][2] == theSeed
                   && board[1][1] == theSeed
                   && board[2][0] == theSeed);
   }
 
   /** Return true if the player with "theSeed" has won after placing at
       (currentRow, currentCol) */
   public static boolean hasWon4(int theSeed, int currentRow, int currentCol) {
      return (board4[currentRow][0] == theSeed         // 3-in-the-row
                   && board4[currentRow][1] == theSeed
                   && board4[currentRow][2] == theSeed
                   && board4[currentRow][3] == theSeed
              || board4[0][currentCol] == theSeed      // 3-in-the-column
                   && board4[1][currentCol] == theSeed
                   && board4[2][currentCol] == theSeed
                   && board4[3][currentCol] == theSeed
              || currentRow == currentCol            // 3-in-the-diagonal
                   && board4[0][0] == theSeed
                   && board4[1][1] == theSeed
                   && board4[2][2] == theSeed
                   && board4[3][3] == theSeed
              || currentRow + currentCol == 3  // 3-in-the-opposite-diagonal
                   && board4[0][3] == theSeed
                   && board4[1][2] == theSeed
                   && board4[2][1] == theSeed
                   && board4[3][0] == theSeed);
   }

   /** Return true if the player with "theSeed" has won after placing at
       (currentRow, currentCol) */
   public static boolean hasWon5(int theSeed, int currentRow, int currentCol) {
      return (board5[currentRow][0] == theSeed         // 3-in-the-row
                   && board5[currentRow][1] == theSeed
                   && board5[currentRow][2] == theSeed
                   && board5[currentRow][3] == theSeed
                   && board5[currentRow][4] == theSeed
              || board5[0][currentCol] == theSeed      // 3-in-the-column
                   && board5[1][currentCol] == theSeed
                   && board5[2][currentCol] == theSeed
                   && board5[3][currentCol] == theSeed
                   && board5[4][currentCol] == theSeed
              || currentRow == currentCol            // 3-in-the-diagonal
                   && board5[0][0] == theSeed
                   && board5[1][1] == theSeed
                   && board5[2][2] == theSeed
                   && board5[3][3] == theSeed
                   && board5[4][4] == theSeed
              || currentRow + currentCol == 4  // 3-in-the-opposite-diagonal
                   && board5[0][4] == theSeed
                   && board5[1][3] == theSeed
                   && board5[2][2] == theSeed
                   && board5[3][1] == theSeed
                   && board5[4][0] == theSeed);
   }
 
   /** Print the game board */
   public static void printBoard() {
      for (int row = 0; row < ROW3; ++row) {
         for (int col = 0; col < COL3; ++col) {
            printCell(board[row][col]); // print each of the cells
            if (col != COL3 - 1) {
               System.out.print("|");   // print vertical partition
            }
         }
         System.out.println();
         if (row != ROW3 - 1) {
            System.out.println("-----------"); // print horizontal partition
         }
      }
      System.out.println();
   }
 
   public static void printBoard4() {
      for (int row = 0; row < ROW4; ++row) {
         for (int col = 0; col < COL4; ++col) {
            printCell(board4[row][col]); // print each of the cells
            if (col != COL4 - 1) {
               System.out.print("|");   // print vertical partition
            }
         }
         System.out.println();
         if (row != ROW4 - 1) {
            System.out.println("-----------"); // print horizontal partition
         }
      }
      System.out.println();
   }

   public static void printBoard5() {
      for (int row = 0; row < ROW5; ++row) {
         for (int col = 0; col < COL5; ++col) {
            printCell(board5[row][col]); // print each of the cells
            if (col != COL5 - 1) {
               System.out.print("|");   // print vertical partition
            }
         }
         System.out.println();
         if (row != ROW5 - 1) {
            System.out.println("-----------"); // print horizontal partition
         }
      }
      System.out.println();
   }
 
   /** Print a cell with the specified "content" */
   public static void printCell(int content) {
      switch (content) {
         case EMPTY:  System.out.print("   "); break;
         case NOUGHT: System.out.print(" O "); break;
         case CROSS:  System.out.print(" X "); break;
      }
   }
}