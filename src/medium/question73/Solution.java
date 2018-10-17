package medium.question73;

/**
 * Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * @author yangkuan
 * @date 2018/10/17
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isZeroRow0 = false;
        boolean isZeroCol0 = false;

        //标记第0列是否有0
        for (int i=0;i<row;i++){
            if(matrix[i][0]==0){
                isZeroCol0 = true;
            }
        }
        //标记第0行是否有0
        for(int j=0;j<col;j++){
            if(matrix[0][j]==0){
                isZeroRow0 = true;
            }
        }

        //使用第0行和第0列作为标记
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
        //赋值0
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(isZeroRow0){
            for(int j=0;j<col;j++){
                matrix[0][j]=0;
            }
        }
        if (isZeroCol0){
            for (int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,0},{1,0,1},{1,1,1}};
        new Solution().setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
