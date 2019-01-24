package medium.question59;

/**
 * Spiral Matrix II
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * @author yangkuan
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<=0){
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int cnt = 1;
        int index = 0;
        while (index < n / 2) {
            int i = index, j = index;
            //left to right
            for (; j < n - 1 - index; j++) matrix[i][j] = cnt++;
            //top to down
            for (; i < n - 1 - index; i++) matrix[i][j] = cnt++;
            //right to left
            for (; j > index; j--) matrix[i][j] = cnt++;
            //down to top
            for (; i > index; i--) matrix[i][j] = cnt++;
            index++;
        }
        if (n % 2 != 0) {
            matrix[n / 2][n / 2] = n * n;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(4);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
