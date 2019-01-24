package medium.question63;

/**
 * Unique Paths II
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * @author yangkuan
 */
public class Solution {
    /**
     * 使用递归的方法不好，会出现大量重复计算
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesNotGood(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, m, n);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1 && obstacleGrid[i][j] != 1) {
            return 1;
        }
        int result = 0;
        // right
        if (j < n - 1 && obstacleGrid[i][j + 1] != 1) {
            result += uniquePathsWithObstacles(obstacleGrid, i, j + 1, m, n);
        }
        // down
        if (i < m - 1 && obstacleGrid[i + 1][j] != 1) {
            result += uniquePathsWithObstacles(obstacleGrid, i + 1, j, m, n);
        }
        return result;
    }

    /**
     * 使用BP算法
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] bp = new int[m][n];
        // 初始化最后一列
        for(int i=m-1;i>=0;i--){
            if(obstacleGrid[i][n-1]!=1&&i==m-1){
                bp[i][n-1] = 1;
            }
            else if(obstacleGrid[i][n-1]!=1){
                bp[i][n-1] = bp[i+1][n-1];
            }
        }
        //初始化最后一行
        for(int j =n-1;j>=0;j--){
            if(obstacleGrid[m-1][j]!=1&&j==n-1){
                bp[m-1][j]=1;
            }
            else if(obstacleGrid[m-1][j]!=1){
                bp[m-1][j]=bp[m-1][j+1];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if(obstacleGrid[i][j]!=1){
                    bp[i][j] = bp[i][j+1]+bp[i+1][j];
                }
            }
        }
        return bp[0][0];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}
