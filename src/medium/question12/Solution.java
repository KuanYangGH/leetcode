package medium.question12;

import java.util.HashMap;
import java.util.Map;

/**
 * Integer to Roman
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */
public class Solution {
    static Map<Integer, Character> intToRomanMap;

    public Solution() {
        intToRomanMap = new HashMap<>();
        intToRomanMap.put(1, 'I');
        intToRomanMap.put(5, 'V');
        intToRomanMap.put(10, 'X');
        intToRomanMap.put(50, 'L');
        intToRomanMap.put(100, 'C');
        intToRomanMap.put(500, 'D');
        intToRomanMap.put(1000, 'M');
    }

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder("");
        for (int i = 10; num != 0; i *= 10) {
            int remainder = num % i;
            num = num - remainder;

            if (remainder == (i / 2 - i / 10)) {
                roman.insert(0, intToRomanMap.get(i / 2));
                roman.insert(0, intToRomanMap.get(i / 10));
                continue;
            }
            if (remainder == (i - i / 10)) {
                roman.insert(0, intToRomanMap.get(i));
                roman.insert(0, intToRomanMap.get(i / 10));
                continue;
            }
            if (remainder == i / 2) {
                roman.insert(0, intToRomanMap.get(i / 2));
            } else if (remainder > i / 2) {
                StringBuilder s = new StringBuilder();
                s.append(intToRomanMap.get(i / 2));
                for (int j = 0; j < (remainder - i / 2) / (i / 10); j++) {
                    s.append(intToRomanMap.get(i / 10));
                }
                roman = roman.insert(0,s);
            } else {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < remainder / (i / 10); j++) {
                    s.append(intToRomanMap.get(i / 10));
                }
                roman.insert(0,s);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().intToRoman(1994);
        System.out.println(s);
    }
}
