package easy.question58;

/**
 * Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return end - i;
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
        String s = " ";
        int size = new Solution().lengthOfLastWord(s);
        System.out.println(size);
    }
}
