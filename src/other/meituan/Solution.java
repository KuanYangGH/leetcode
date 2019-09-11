package other.meituan;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static String sum(String n1, String n2) {
        if (n1 == null || n1.equals("")) {
            return n2;
        }
        if (n2 == null || n2.equals("")) {
            return n1;
        }
        if (n1.charAt(0) == '+') {
            n1 = n1.substring(1);
        }
        if (n2.charAt(0) == '+') {
            n2 = n2.substring(1);
        }
        if (n1.charAt(0) == '-' && n2.charAt(0) != '-') {
            n1 = n1.substring(1);
            // n2 - n1
            if (greater(n2, n1)) {
                return sub(n2, n1);
            } else {
                return "-" + sub(n1, n2);
            }
        }
        if (n1.charAt(0) != '-' && n2.charAt(0) == '-') {
            n2 = n2.substring(1);
            // n1 - n2
            if (greater(n1, n2)) {
                return sub(n1, n2);
            } else {
                return "-" + sub(n2, n1);
            }
        }
        StringBuilder r = new StringBuilder(n1);
        StringBuilder s = new StringBuilder(n2);
        StringBuilder result = add(r, s);
        return result.toString();
    }

    private static StringBuilder add(StringBuilder r, StringBuilder s) {
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

    private static String sub(String r, String s) {
        String result = "";
        int borrow = 0;
        int i = r.length() - 1, j = s.length() - 1;

        if (i > j) {
            for (int k = 0; k < (i - j); k++) {
                s = "0" + s;
            }
        }
        for (; i >= 0; i--) {
            int cur = r.charAt(i) - s.charAt(i) - borrow;
            if (cur < 0) {
                cur += 10;
                borrow = 1;
            }
            result = cur + result;
        }
        while (result.charAt(0) == '0' && result.length() != 1) {
            result = result.substring(1);
        }
        return result;
    }

    private static boolean greater(String r, String s) {
        if (r.length() > s.length()) {
            return true;
        }
        if (r.length() < s.length()) {
            return false;
        }
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) > s.charAt(i)) {
                return true;
            }
            if (r.charAt(i) < s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine();
        String n2 = in.nextLine();
        System.out.println(sum(n1, n2));

    }
}
