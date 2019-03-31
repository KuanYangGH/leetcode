package hard.question76;

import java.util.HashMap;

/**
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @author yangkuan
 */
public class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = t.length();
        int[] minWin = {0, s.length()};
        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    counter--;
                }
                map.put(c, map.get(c) - 1);
            }
            while (counter == 0) {
                if (minWin[1] - minWin[0] > end - begin) {
                    minWin[1] = end;
                    minWin[0] = begin;
                }
                if (map.containsKey(s.charAt(begin))) {
                    if (map.get(s.charAt(begin)) >= 0) {
                        counter++;
                    }
                    map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
                }
                begin++;
            }
            end++;
        }
        String minWindowString = "";
        if (minWin[1] - minWin[0] != s.length()) {
            minWindowString = s.substring(minWin[0], minWin[1] + 1);
        }
        return minWindowString;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
//        String S = "AABC";
        String T = "ABC";
        System.out.println(new Solution().minWindow(S, T));
    }
}
