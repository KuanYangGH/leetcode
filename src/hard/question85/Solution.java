package hard.question85;

import java.util.Stack;

/**
 * Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's
 * and return its area.
 * Example:
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * @author yangkuan
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] histogram = new int[cols + 1];
        int MaxRectangle = 0;
        for (int i = 0; i < rows; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < cols + 1; j++) {
                if (j == cols || matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j] = histogram[j] + 1;
                }

                if (stack.empty() || histogram[stack.peek()] < histogram[j]) {
                    stack.push(j);
                } else {
                    int area = 0;
                    while (!stack.empty() && histogram[stack.peek()] > histogram[j]) {
                        int height = histogram[stack.pop()];
                        int width = j - 1 - (stack.empty() ? -1 : stack.peek());
                        area = height * width;
                        MaxRectangle = Math.max(area, MaxRectangle);
                    }
                    stack.push(j);
                }
            }
        }
        return MaxRectangle;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}
