package medium.question3;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author yangkuan
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] characters = s.toCharArray();
        // 记录字符出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 1;
        for (int i = 0; i < characters.length; i++) {
            if (!map.containsKey(characters[i])) {
                end = i;
                map.put(characters[i], i);
            } else {
                start = start > (map.get(characters[i]) + 1) ? start : (map.get(characters[i]) + 1);
                end = i;
                map.put(characters[i], i);
            }
            maxLen = maxLen < (end - start + 1) ? (end - start + 1) : maxLen;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringSecondTime(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int lengthOfLongest = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                start = Math.max(start,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            lengthOfLongest = Math.max(lengthOfLongest,i-start+1);
        }
        return lengthOfLongest;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
        System.out.println(new Solution().lengthOfLongestSubstringSecondTime(s));
    }
}
