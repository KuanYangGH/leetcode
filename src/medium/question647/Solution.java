package medium.question647;

/**
 * Palindromic Substrings
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different
 * substrings even they consist of same characters.
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
 * @author yangkuan
 */
public class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i=0;i<chars.length;i++){
            for(int j=i;j<chars.length;j++){
                if(chars[i]==chars[j]){
                    count += isPalindromic(chars,i,j);
                }
            }
        }
        return count;
    }
    private int isPalindromic(char[] chars,int i,int j){
        while (i<j){
            if(chars[i]!=chars[j]) return 0;
            i++;
            j--;
        }
        return 1;
    }
    int count = 0;
    public int countSubstringsSmartSolution(String s) {
        for(int i=0;i<s.length();i++){
            extendPalindromicString(s,i,i);
            extendPalindromicString(s,i,i+1);
        }
        return count;
    }

    private void extendPalindromicString(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Solution().countSubstrings(s));
        System.out.println(new Solution().countSubstringsSmartSolution(s));
    }
}
