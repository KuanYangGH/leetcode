package medium.question221;

import javax.lang.model.util.ElementScanner6;
import java.util.Stack;

/**
 * Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * Example:
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Output: 4
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols+1];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<rows;i++){
            Stack<Integer> stack = new Stack<>();
            for(int j=0;j<=cols;j++){
                if(j==cols||matrix[i][j]=='0'){
                    heights[j] = 0 ;
                }
                else {
                    heights[j] += 1;
                }

                if (stack.empty() || heights[stack.peek()] <= heights[j]) {
                    stack.push(j);
                } else {
                    int area = 0;
                    while (!stack.empty() && heights[stack.peek()] > heights[j]) {
                        int height = heights[stack.pop()];
                        int width = j - 1 - (stack.empty() ? -1 : stack.peek());
                        area = width>height?height*height:width*width;
                        maxArea = Math.max(area, maxArea);
                    }
                    stack.push(j);
                }

            }
        }
        return maxArea;
    }

    public int maximalSquareWithDP(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        int maxEdge = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='0'){
                    dp[i+1][j+1]=0;
                }
                else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i][j]))+1;
                }
                maxEdge = Math.max(dp[i+1][j+1],maxEdge);
            }
        }
        return maxEdge*maxEdge;
    }

    public static void main(String[] args) {

    }
}
