package hard.question72;

/**
 * Edit Distance
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * @author yangkuan
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int rows = word1.length() + 1;
        int cols = word2.length() + 1;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int tmp = Math.min(dp[i][j-1],dp[i-1][j]);
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j] = Math.min(tmp+1,dp[i-1][j-1]);
                    }
                    else {
                        dp[i][j] = Math.min(tmp+1,dp[i-1][j-1]+1);
                    }
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new Solution().minDistance(word1,word2));
    }
}
