package medium.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author yangkuan
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        backtrack("", n, n, result);
        return result;
    }

    private void backtrack(String s, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
        }
        if (left > 0) {
            backtrack(s + "(", left - 1, right, result);
        }
        if (right > 0 && right > left) {
            backtrack(s + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        List<String> rs = new Solution().generateParenthesis(3);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
