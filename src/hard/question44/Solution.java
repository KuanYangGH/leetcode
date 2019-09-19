package hard.question44;

import java.util.Scanner;

/**
 * Wildcard Matching
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int rows = s.length() + 1;
        int cols = p.length() + 1;
        boolean[][] matchMatrix = new boolean[rows][cols];
        for (int j = 0; j < cols; j++) {
            if (j == 0) {
                matchMatrix[0][j] = true;
            } else if (p.charAt(j - 1) == '*') {
                matchMatrix[0][j] = matchMatrix[0][j - 1];
            }
        }
        for (int i = 1; i < rows; i++) {
            matchMatrix[i][0] = false;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    matchMatrix[i][j] = matchMatrix[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    matchMatrix[i][j] = false;
                    for (int k = i; k >= 0; k--) {
                        if (matchMatrix[k][j - 1]) {
                            matchMatrix[i][j] = true;
                        }
                    }
                }
            }
        }
        return matchMatrix[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        System.out.println(new Solution().isMatch(s, p));
    }
}
