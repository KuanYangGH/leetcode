package easy.question438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * @author yangkuan
 */
public class Solution {
    /**
     * 截取s中的子串，和p一一对比
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null) {
            return result;
        }
        for (int i = 0; i + p.length() <= s.length(); i++) {
            String subString = s.substring(i, i + p.length());
            if (match(subString, p)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 一个字符一个字符对比
     *
     * @param p1
     * @param p2
     * @return
     */
    private boolean match(String p1, String p2) {
        char[] c1 = p1.toCharArray();
        char[] c2 = p2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用hash map
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsUsingHash(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null) {
            return result;
        }
        for (int i = 0; i + p.length() <= s.length(); i++) {
            String subString = s.substring(i, i + p.length());

            HashMap<Character, Integer> pMap = new HashMap<>();
            for (int j = 0; j < p.length(); j++) {
                pMap.put(p.charAt(j), pMap.getOrDefault(p.charAt(j), 0) + 1);
            }
            if (matchWithHash(subString, pMap)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean matchWithHash(String p1, HashMap<Character, Integer> pMap) {
        for (int i = 0; i < p1.length(); i++) {
            int value = pMap.getOrDefault(p1.charAt(i), 0);
            if (value <= 0) {
                return false;
            }
            pMap.put(p1.charAt(i), value - 1);
        }
        return true;
    }

    /**
     * 滑动窗口的方法
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsUsingSlideWindows(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null) {
            return result;
        }
        HashMap<Character, Integer> reference = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            reference.put(p.charAt(i), reference.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, matches = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {

            Character rc = s.charAt(right);
            if (reference.containsKey(rc)) {
                map.put(rc, map.getOrDefault(rc, 0) + 1);
                if (map.get(rc).equals(reference.get(rc))) {
                    matches++;
                }
            }

            while (matches==reference.size()){
                if(right-left+1==p.length()){
                    result.add(left);
                }
                char lc = s.charAt(left);
                if(reference.containsKey(lc)){
                    map.put(lc,map.getOrDefault(lc,0)-1);
                    if(reference.get(lc)>map.get(lc)){
                        matches--;
                    }
                }
                left++;
            }
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "cbaabacdcab";
        String p = "abc";
//        System.out.println(new Solution().findAnagrams(s, p));
//        System.out.println(new Solution().findAnagramsUsingHash(s, p));
        System.out.println(new Solution().findAnagramsUsingSlideWindows(s, p));
    }
}
