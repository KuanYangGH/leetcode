package medium.question74;

/**
 * Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * @author yangkuan
 * @date 2018/10/12
 */
public class Solution {
    /**
     * O(n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixOn(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int rowIndex = 0;
        int colIndex = col-1;
        while (rowIndex<row&&colIndex>=0){
            if(matrix[rowIndex][colIndex]<target){
                rowIndex++;
            }
            else if(matrix[rowIndex][colIndex]>target){
                colIndex--;
            }
            else {
                return true;
            }
       }
       return false;
    }

    public boolean searchMatrixOlogn(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int startRowIndex = 0;
        int startColIndex = 0;
        int endRowIndex = row-1;
        int endColIndex = col-1;
        int midRowIndex;
        int midColIndex;
        while ((startRowIndex*col+startColIndex)<=(endRowIndex*col+endColIndex)){
            int tmp = (startRowIndex*col+startColIndex+endRowIndex*col+endColIndex);
            midRowIndex = (tmp/2)/col;
            midColIndex = ((tmp)/2)%col;
            if(target>matrix[midRowIndex][midColIndex]){
                startRowIndex = (tmp/2+1)/col;
                startColIndex = (tmp/2+1)%col;
            }
            else if(target<matrix[midRowIndex][midColIndex]){
                endRowIndex = (tmp/2-1)/col;
                endColIndex = (tmp/2-1)%col;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1},{3},{5}};
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};

        System.out.println(new Solution().searchMatrixOn(matrix,3));
        System.out.println(new Solution().searchMatrixOlogn(matrix,3));
    }
}
