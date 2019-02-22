package Array_Leetcode;

public class BattleShipInABoard {

	public int countBattleships(char[][] board) {

		if (board == null || board.length == 0)
			return 0;

		int result = 0;
		int row = board.length;
		int col = board[0].length;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				if (board[i][j] == 'X') {

					result++;
					sinkBattleShip(board, i, j, row, col);

				}

			}
		}

		return result;

	}

	private void sinkBattleShip(char[][] board, int i, int j, int row, int col) {

		if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'X')
			return;
		board[i][j] = '.';
		sinkBattleShip(board, i + 1, j, row, col);
		sinkBattleShip(board, i, j + 1, row, col);
		sinkBattleShip(board, i - 1, j, row, col);
		sinkBattleShip(board, i, j - 1, row, col);

	}

}
