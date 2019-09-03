package medium.question43;

/**
 * Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder r = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder s = new StringBuilder();
            int carry = 0;
            int j = num2.length() - 1;
            for (; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                carry = sum / 10;
                sum = sum % 10;
                s.append(String.valueOf(sum));
            }
            if (carry != 0) s.append(carry);
            s.reverse();
            for (int k = num1.length() - 1; k > i; k--) {
                s.append("0");
            }
            r = add(r, s);
        }
        return r.toString();
    }

    private StringBuilder add(StringBuilder r, StringBuilder s) {
        StringBuilder sums = new StringBuilder();
        int len1 = r.length() - 1, len2 = s.length() - 1;
        if (len1 < len2) {
            for (int k = 0; k < len2 - len1; k++) {
                r.insert(0, "0");
            }
        } else {
            for (int k = 0; k < len1 - len2; k++) {
                s.insert(0, "0");
            }
        }
        int carry = 0;
        for (int i = r.length() - 1; i >= 0; i--) {
            int sum = (r.charAt(i) - '0') + (s.charAt(i) - '0') + carry;
            carry = sum / 10;
            sum = sum % 10;
            sums.append(String.valueOf(sum));
        }
        if (carry != 0) sums.append(carry);
        sums.reverse();
        return sums;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String num = new Solution().multiply(num1, num2);
        System.out.println(num);
        System.out.println(Integer.valueOf(num1) * Integer.valueOf(num2));
    }
}
