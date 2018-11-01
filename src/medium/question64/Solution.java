package medium.question64;

/**
 * Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * @author yangkuan
 * @date 2018/11/1
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] minMatrix = new int[rows][cols];
        minMatrix[0][0] = grid[0][0];
        for(int i=1;i<cols;i++){
            minMatrix[0][i]=minMatrix[0][i-1]+grid[0][i];
        }
        for(int i=1;i<rows;i++){
            minMatrix[i][0]=minMatrix[i-1][0]+grid[i][0];
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                minMatrix[i][j] = min(minMatrix[i][j-1],minMatrix[i-1][j])+grid[i][j];
            }
        }
        return minMatrix[rows-1][cols-1];
    }
    private int min(int a,int b){
        return a<b?a:b;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.print(new Solution().minPathSum(grid));
    }
}
