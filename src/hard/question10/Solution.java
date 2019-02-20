package hard.question10;

/**
 * Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] bp = new boolean[s.length() + 1][p.length() + 1];
        bp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*' && bp[0][j - 2]) {
                bp[0][j] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    bp[i][j] = bp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // * is empty
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        bp[i][j] = bp[i][j - 2];
                    } else {
                        // * is one/empty/multiple
                        bp[i][j] = bp[i][j - 1] || bp[i][j - 2] || bp[i - 1][j];
                    }
                }
            }
        }
        return bp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b*";
        System.out.println(new Solution().isMatch(s, p));
    }
}
