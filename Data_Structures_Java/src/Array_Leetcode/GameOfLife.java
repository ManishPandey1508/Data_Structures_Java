package Array_Leetcode;

/*According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.*/
public class GameOfLife {

	public static void main(String[] args) {

		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		gameOfLife(board);

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			
			for (int j = 0; j < n; j++) {
				System.out.println(board[i][j]);
			}
		}

	}

	public static void gameOfLife(int[][] board) {

		int m = board.length;
		int n = board[0].length;

		int copy[][] = board;

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				int liveNeighbours = liveNeighbourCount(copy, i, j, m, n);
				System.out.println("i "+i+ " j "+j+" Live Neighbours "+ liveNeighbours );

				// Any live cell with fewer than two live neighbors dies, as if caused by
				// under-population.

				if (copy[i][j] == 1 && liveNeighbours < 2) {
					board[i][j] = 0;
				} else if (copy[i][j] == 1 && liveNeighbours > 3) {
					board[i][j] = 0;
				}

				else if (copy[i][j] == 1 && (liveNeighbours == 2 || liveNeighbours == 3))
					board[i][j] = 1;

				else if (copy[i][j] == 0 && liveNeighbours == 3)
					board[i][j] = 1;
			}
		}

	}

	public static int liveNeighbourCount(int[][] board, int i, int j, int m, int n) {

		int live = 0;

		// bottom row same column
		if (isValid(i + 1, j, m, n) && board[i + 1][j] == 1) {
			live++;
		}
		// top row same column
		if (isValid(i - 1, j, m, n) && board[i - 1][j] == 1) {
			live++;
		}
		// same row next column
		if (isValid(i, j + 1, m, n) && board[i][j + 1] == 1) {
			live++;
		}
		if (isValid(i, j - 1, m, n) && board[i][j - 1] == 1) {
			live++;
		}
		// left to right diagonal top element
		if (isValid(i - 1, j - 1, m, n) && board[i - 1][j - 1] == 1) {
			live++;
		}
		// left to right diagonal bottom element
		if (isValid(i + 1, j + 1, m, n) && board[i + 1][j + 1] == 1) {
			live++;
		}
		// right to left top elemnt
		if (isValid(i - 1, j + 1, m, n) && board[i - 1][j + 1] == 1) {
			live++;
		}
		// right to left bottom element

		if (isValid(i + 1, j - 1, m, n) && board[i + 1][j - 1] == 1) {
			live++;
		}

		return live;
	}

	public static boolean isValid(int i, int j, int m, int n) {
		  if(i<0 || i>=m || j<0 || j >= n)
	            return false;
	        else 
	            return true;

	}

}
