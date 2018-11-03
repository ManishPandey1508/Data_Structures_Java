package Array_Leetcode;
/*Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|*/

public class TicTacToe {
	   int[] rows, cols;
	   int diagonal, anti_diagonal, target;

	   public TicTacToe(int n) {
	       rows = new int[n];
	       cols = new int[n];
	       diagonal = 0;
	       anti_diagonal = 0;
	       target = n;
	   }

	   public int move(int row, int col, int player) {
	       int sign = player == 1 ? 1 : -1, res = sign * target;
	       rows[row] += sign;
	       cols[col] += sign;
	       if(row == col) diagonal += sign;
	       if(row == target-1-col) anti_diagonal += sign;
	       if(rows[row] == res || cols[col] == res || diagonal == res || anti_diagonal == res) return player;
	       else return 0;
	   }
}
