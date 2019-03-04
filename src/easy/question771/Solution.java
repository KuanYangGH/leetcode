package easy.question771;

import java.util.HashMap;
import java.util.Map;

/**
 * Jewels and Stones
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * @author yangkuan
 */
public class Solution {
    /**
     * 使用HashMap保存珠宝类型
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        if (J == null || S == null) {
            return cnt;
        }
        Map<Character, Integer> reference = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            reference.put(J.charAt(i), 1);
        }
        for (int i = 0; i < S.length(); i++) {
            if (reference.containsKey(S.charAt(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String J = "as";
        String S = "abcsda";
        System.out.println(new Solution().numJewelsInStones(J, S));
    }
}
