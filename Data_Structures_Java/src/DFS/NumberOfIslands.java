package DFS;import javafx.util.converter.NumberStringConverter;

/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3*/

public class NumberOfIslands {

	static int count = 0;
	
	public static void main(String[] args) {
		
		char[][] matrix = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(numIslands(matrix));
		
	}
	
	
	
	public static int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int n = grid.length;
		int m = grid[0].length;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				if (grid[i][j] == '1') {
					markIslandcounted(grid, n,m,i, j);
					++count;
				}

			}

		}

		return count;
	}

	private static void markIslandcounted(char[][] grid,int row, int col, int i, int j) {
	
		if(i<0||j<0 || i>=row|| j>=col|| grid[i][j] !=1) return;
		
		grid[i][j] = '0';
		
		markIslandcounted(grid, row, col, i++, j);
		markIslandcounted(grid, row, col, i--, j);
		markIslandcounted(grid, row, col, i, j++);
		markIslandcounted(grid, row, col, i, j--);
	}

}
