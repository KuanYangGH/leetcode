package hard.question32;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                if(!stack.empty()){
                    if(s.charAt(stack.peek())=='('){
                        stack.pop();
                    }
                    else {
                        stack.push(i);
                    }
                }
                else {
                    stack.push(i);
                }
            }
        }
        int endIndex = s.length();
        int startIndex = 0;
        int maxLen = 0;
        if(stack.empty()){
            maxLen = s.length();
        }
        while (!stack.empty()) {
            startIndex = stack.pop();
            int len = endIndex-startIndex-1;
            maxLen = maxLen>len?maxLen:len;
            endIndex = startIndex;
        }
        int len = endIndex-(-1)-1;
        return maxLen>len?maxLen:len;
    }

    public static void main(String[] args) {
        String s = "(((())())";
        System.out.print(new Solution().longestValidParentheses(s));
    }
}
