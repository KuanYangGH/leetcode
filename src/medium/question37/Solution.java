package medium.question37;


/**
 * Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 * @author yangkuan
 * @date 2018/11/19
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudukuCore(board);
    }

    private boolean solveSudukuCore(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, k, i, j)) {
                            board[i][j] = k;
                            if (solveSudukuCore(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // 如果找不到合适的数字填入，那么返回false
                    if (board[i][j] == '.') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, char c, int rowIndex, int colIndex) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][colIndex] == c && i != rowIndex) {
                return false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[rowIndex][j] == c && j != colIndex) {
                return false;
            }
        }
        int m = rowIndex / 3, n = colIndex / 3;
        for (int i = 3 * m; i < (3 * m + 3); i++) {
            for (int j = 3 * n; j < (3 * n + 3); j++) {
                if (board[i][j] == c && i != rowIndex && j != colIndex) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] chars = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
       new Solution().solveSudoku(chars);
       for(int i=0;i<chars.length;i++){
           for(int j=0;j<chars[0].length;j++){
               System.out.print(chars[i][j]+" ");
           }
           System.out.println();
       }
    }
}
