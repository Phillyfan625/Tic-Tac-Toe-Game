
/**
	File name: ticTacToeGame.java
	Short description: A game that lets the user play a fully functional tic tac toe game
	IST 140 Assignment:  HW_P6_25
	@author PJ Johnson, Jared Furline, Chris Capaldi
	date of last revision: 2018-12-01
	details of the revision: none
*/


import java.util.Scanner;
public class ticTacToeGame {

  // declare global scanner
  public static Scanner input = new Scanner(System.in);

	public static void main (String[] args) {
    	int result;
    	int currentPlayer;
    	int ties = 0;
    	int playerOneWins = 0;
    	int playerTwoWins = 0;
    	char[][] gameboard;
        char playing = 'Y';

      // loop until they request exit
      while(playing == 'Y' || playing == 'y') {
        // commence game
      	result = game();
      	//input = updateBoard();
        if (result == 0)
        {
            System.out.println("It is a tie!");
        }
        else if(result == 1)
        {
            System.out.println("Player 1 Won!");
        }
        else if(result == 2)
        {
            System.out.println("Player 2 Won!");
        }

        // see if they want to play again
        System.out.println("Would you like to play again?");
        playing = input.next().charAt(0);
      }
	}

	public static int game () {
  	boolean isFull = false;
  	int winner = 0;
  	int input1, input2;
  	char[][] gameBoard = {
         	{'1' ,  '2' , '3'},
         	{'4', '5' , '6'},
         	{'7', '8', '9'},
   	};
   	drawBoard(gameBoard);

  	while(!isFull && winner == 0)
    {
      // player 1
      System.out.println("Who wants x:");
      input1 = input.nextInt();
      updateBoard(input1, gameBoard, 'x');
      drawBoard(gameBoard);
      winner = whoWon(gameBoard);
      isFull = isFull(gameBoard);

      if(!isFull && winner == 0)
      {
        // player 2
        System.out.println("who wants o:");
        input2 = input.nextInt();
        updateBoard(input2, gameBoard, 'o');
        drawBoard(gameBoard);

        winner = whoWon(gameBoard);
        isFull = isFull(gameBoard);
      }
    }

    return winner;
  }

	public static void drawBoard(char[][] gameboard) {
                  System.out.print(gameboard[0][0]);
                  System.out.print("-");
                  System.out.print(gameboard[0][1]);
                   System.out.print("-");
                  System.out.println(gameboard[0][2]);
                  System.out.print(gameboard[1][0]);
                  System.out.print("-");
                  System.out.print(gameboard[1][1]);
                  System.out.print("-");
                  System.out.println(gameboard[1][2]);
                  System.out.print(gameboard[2][0]);
                  System.out.print("-");
                  System.out.print(gameboard[2][1]);
                   System.out.print("-");
                  System.out.println(gameboard[2][2]);
   }

	public static int getPlayer( int currentPlayer) {
    	if (currentPlayer == 1) {
        	currentPlayer = 2;
    	}
    	else {
        	currentPlayer = 1;
    	}

    	return 0;
    }

  public static boolean isFull(char[][] gameBoard) {

      if(!(gameBoard[0][0] == 'x' || gameBoard[0][0] == 'o')) {
          return false;
      }
      else if(!(gameBoard[0][1] == 'x' || gameBoard[0][1] == 'o')) {
          return false;
      }
      else if(!(gameBoard[0][2] == 'x' || gameBoard[0][2] == 'o')) {
          return false;
      }
      else if(!(gameBoard[1][0] == 'x' || gameBoard[1][0] == 'o')) {
          return false;
      }
      else if(!(gameBoard[1][1] == 'x' || gameBoard[1][1] == 'o')) {
          return false;
      }
      else if(!(gameBoard[1][2] == 'x' || gameBoard[1][2] == 'o')) {
          return false;
      }
      else if(!(gameBoard[2][0] == 'x' || gameBoard[2][0] == 'o')) {
          return false;
      }
     else if(!(gameBoard[2][1] == 'x' || gameBoard[2][1] == 'o')) {
          return false;
      }
     else if(!(gameBoard[2][2] == 'x' || gameBoard[2][2] == 'o')) {
          return false;
      }

  	return true;
  }


  public static int updateBoard(int playerInput,char [][] gameBoard, char playerIcon) {
  	char newValue;
  	// ADD A DO WHILE
  	do {
    	int[] position = getPosition(playerInput);
    	newValue = gameBoard[position[0]][position[1]];
    	// check if the position is taken
    	if (newValue == 'x' || newValue == 'o') {
        	System.out.println("This place is taken!Try Again!!");
        	playerInput = input.nextInt();
    	}
    	else {
        	gameBoard[position[0]][position[1]] = playerIcon;
    	}
  	} while(newValue == 'x' || newValue == 'o');

  	return newValue;
  }

  public static int[] getPosition(int playerInput)
  {
  	//check availability
  	int[] position = new int[2];
  	switch(playerInput) {
      	case 1:
          	position[0] = 0;
          	position[1] = 0;
          	break;
      	case 2:
          	position[0] = 0;
          	position[1] = 1;
          	break;
      	case 3:
          	position[0] = 0;
          	position[1] = 2;
          	break;
      	case 4:
          	position[0] = 1;
          	position[1] = 0;
          	break;
      	case 5:
          	position[0] = 1;
          	position[1] = 1;
          	break;
      	case 6:
          	position[0] = 1;
          	position[1] = 2;
          	break;
      	case 7:
          	position[0] = 2;
          	position[1] = 0;
          	break;
      	case 8:
          	position[0] = 2;
          	position[1] = 1;
          	break;
      	case 9:
          	position[0] = 2;
          	position[1] = 2;
          	break;
      	default:
         	System.out.println("there is a error ");
  	}
  	return position;
  }

  //winning with if else statements
  // if(position [0][0]
  public static int whoWon(char[][] gameBoard)
  {
      //drawBoard(gameBoard);
      if(gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][1] == gameBoard[0][2])
      {
         return getWinner(gameBoard[0][0]);
      }
      else if ((gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[1][2]))
      {
          return getWinner(gameBoard[0][0]);
      }
      else if (gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][1] == gameBoard[2][2])
      {
          return getWinner(gameBoard[0][0]);
      }
      else if (gameBoard[0][0] == gameBoard[1][0] && gameBoard[1][0] == gameBoard[2][0])
      {
          return getWinner(gameBoard[0][0]);
      }
      else if (gameBoard[0][1] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][1])
      {
          return getWinner(gameBoard[0][0]);
      }
      else if (gameBoard[0][2] == gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][2])
      {
          return getWinner(gameBoard[0][0]);
      }
      else if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2])
      {
          return getWinner(gameBoard[0][0]);
      }
      else if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0])
      {
          return getWinner(gameBoard[0][0]);
      }
      return 0;

  }
  public static int getWinner(char winnerStatus)
  {
       if(winnerStatus == 'x')
              return 1;
          else
              return 2;
  }

}

/*
1-2-3
4-5-6
7-8-9
Who wants x:
1
x-2-3
4-5-6
7-8-9
who wants o:
3
x-2-o
4-5-6
7-8-9
Who wants x:
6
x-2-o
4-5-x
7-8-9
who wants o:
9
x-2-o
4-5-x
7-8-o
Who wants x:
5
x-2-o
4-x-x
7-8-o
who wants o:
4
x-2-o
o-x-x
7-8-o
Who wants x:
2
x-x-o
o-x-x
7-8-o
who wants o:
8
x-x-o
o-x-x
7-o-o
Who wants x:
7
x-x-o
o-x-x
x-o-o
It is a tie!
Would you like to play again?
y
1-2-3
4-5-6
7-8-9
Who wants x:
1
x-2-3
4-5-6
7-8-9
who wants o:
1
This place is taken!Try Again!!
2
x-o-3
4-5-6
7-8-9
Who wants x:
3
x-o-x
4-5-6
7-8-9
who wants o:
4
x-o-x
o-5-6
7-8-9
Who wants x:
5
x-o-x
o-x-6
7-8-9
who wants o:
6
x-o-x
o-x-o
7-8-9
Who wants x:
8
x-o-x
o-x-o
7-x-9
who wants o:
9
x-o-x
o-x-o
7-x-o
Who wants x:
7
x-o-x
o-x-o
x-x-o
Player 1 Won!
Would you like to play again?
y
1-2-3
4-5-6
7-8-9
Who wants x:
1
x-2-3
4-5-6
7-8-9
who wants o:
2
x-o-3
4-5-6
7-8-9
Who wants x:
3
x-o-x
4-5-6
7-8-9
who wants o:
5
x-o-x
4-o-6
7-8-9
Who wants x:
6
x-o-x
4-o-x
7-8-9
who wants o:
8
x-o-x
4-o-x
7-o-9
Player 1 Won!
Would you like to play again?
n
BUILD SUCCESSFUL (total time: 2 minutes 0 seconds)
*/
