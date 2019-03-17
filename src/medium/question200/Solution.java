package medium.question200;

/**
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * @author yangkuan
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void markIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == '0') return;
        grid[i][j] = '0';
        markIsland(grid, i - 1, j);
        markIsland(grid, i + 1, j);
        markIsland(grid, i, j - 1);
        markIsland(grid, i, j + 1);
    }

}
