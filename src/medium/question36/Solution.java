package medium.question36;

import java.util.HashSet;

/**
 * Valid Sudoku
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to
 * be validated according to the following rules:
 * 1.Each row must contain the digits 1-9 without repetition.
 * 2.Each column must contain the digits 1-9 without repetition.
 * 3.ach of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * @author yangkuan
 * @date 2018/11/03
 */
public class Solution {
    /**
     * O(n^2)
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    if(!set.add(ch+"block"+i/3+""+j/3)||!set.add(ch+"row"+i)||!set.add(ch+"col"+j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
                };
        System.out.print(new Solution().isValidSudoku(chars));
    }
}
