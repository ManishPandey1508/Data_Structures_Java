package Strings;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(" Is Word Exist " + exist(board, "ABCB"));
	}

	public static boolean exist(char[][] board, String word) {

		int row = board.length;
		int col = board[0].length;
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char c = board[i][j];
				if (c == word.charAt(0)) {
					StringBuilder sb = new StringBuilder();
					if (helper(board, word, visited, 0, i, j, row, col, sb)) {
						return true;
					}
				}

			}
		}

		return false;

	}

	private static boolean helper(char[][] board, String word, boolean[][] visited, int index, int i, int j, int row,
			int col, StringBuilder sb) {

		if (index == word.length())
			return true;

		if (i < 0 || j < 0 || i >= row || j >= col ||  visited[i][j] || board[i][j] != word.charAt(index))
			return false;

	
		
		visited[i][j] = true;
		if (board[i][j] == word.charAt(index)) {
			sb.append(board[i][j]);

			if (helper(board, word, visited, index + 1, i + 1, j, row, col, sb)
					|| helper(board, word, visited, index + 1, i - 1, j, row, col, sb)
					|| helper(board, word, visited, index + 1, i, j - 1, row, col, sb)
					|| helper(board, word, visited, index + 1, i, j + 1, row, col, sb))
				return true;

		}
		visited[i][j] = false;
		return false;

	}

}
