package medium.question49;

import java.util.*;

/**
 * Group Anagrams
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * @author yangkuan
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.isEmpty() || !map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            } else {
                map.get(s).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] strs = {"hos", "boo", "hos", "boo"};
        List<List<String>> lists = new Solution().groupAnagrams(strs);
    }
}
