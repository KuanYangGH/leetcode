package easy.question38;

/**
 * Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * Input: 1
 * Output: "1"
 * Example 2:
 * Input: 4
 * Output: "1211"
 */
public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = say(s);
        }
        return s;
    }

    private String say(String s) {
        StringBuilder seq = new StringBuilder();
        int begin = 0;
        int i = 1;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(begin)) {
                seq.append(i - begin);
                seq.append(s.charAt(i-1));

                begin = i;
            }
        }
        seq.append(i - begin);
        seq.append(s.charAt(i-1));
        return seq.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(30));
    }
}
