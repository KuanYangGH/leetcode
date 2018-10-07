package medium.question240;

/**
 * Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * @author yangkuan
 * @date 2018/10/07
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return false;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int rowIndex = 0;
        int colIndex = colLen-1;
        while (rowIndex<rowLen&&colIndex>=0){
            if(target==matrix[rowIndex][colIndex]){
                return true;
            }
            else if(target<matrix[rowIndex][colIndex]){
                colIndex--;
            }
            else {
                rowIndex++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(new Solution().searchMatrix(matrix,4));
    }
}
