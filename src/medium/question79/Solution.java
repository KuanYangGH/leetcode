package medium.question79;

/**
 * Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * @author yangkuan
 * @date 2018/10/14
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||word==null||word.length()==0){
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(isMatched(board,word,0,i,j,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isMatched(char[][] board,String word,int wordIndex,int rowIndex,int colIndex,boolean[][] isVisited){
        if(wordIndex==word.length()){
            return true;
        }
        if(rowIndex<0||colIndex<0||rowIndex>=board.length
                ||colIndex>=board[0].length||word.charAt(wordIndex)!=board[rowIndex][colIndex]||isVisited[rowIndex][colIndex]){
            return false;
        }
        isVisited[rowIndex][colIndex] = true;
        boolean flag = isMatched(board,word,wordIndex+1,rowIndex+1,colIndex,isVisited)
        ||isMatched(board,word,wordIndex+1,rowIndex-1,colIndex,isVisited)
        ||isMatched(board,word,wordIndex+1,rowIndex,colIndex+1,isVisited)
        ||isMatched(board,word,wordIndex+1,rowIndex,colIndex-1,isVisited);

        isVisited[rowIndex][colIndex] = false;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new Solution().exist(board,word));
    }
}
