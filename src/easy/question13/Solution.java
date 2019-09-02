package easy.question13;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 */
public class Solution {
    static Map<Character, Integer> romanToIntMap;

    public Solution() {
        romanToIntMap = new HashMap<>();
        romanToIntMap.put('I',1);
        romanToIntMap.put('V',5);
        romanToIntMap.put('X',10);
        romanToIntMap.put('L',50);
        romanToIntMap.put('C',100);
        romanToIntMap.put('D',500);
        romanToIntMap.put('M',1000);
    }

    public int romanToInt(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum += romanToIntMap.get(s.charAt(i));
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='I'&&s.charAt(i+1)=='V'){
                sum -= 2;
            }
            if(s.charAt(i)=='I'&&s.charAt(i+1)=='X'){
                sum -= 2;
            }
            if(s.charAt(i)=='X'&&s.charAt(i+1)=='L'){
                sum -= 20;
            }
            if(s.charAt(i)=='X'&&s.charAt(i+1)=='C'){
                sum -= 20;
            }
            if(s.charAt(i)=='C'&&s.charAt(i+1)=='D'){
                sum -= 200;
            }
            if(s.charAt(i)=='C'&&s.charAt(i+1)=='M'){
                sum -= 200;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sum = solution.romanToInt("LVIII");
        System.out.println(sum);
    }
}
