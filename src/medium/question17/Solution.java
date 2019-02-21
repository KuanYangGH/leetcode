package medium.question17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * 一种递归方法、一种队列方法
 * @author yangkuan
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        char[] digitChars = digits.toCharArray();
        char[] letters = digit2Letters(digitChars[0]);
        for(int i=0;i<letters.length;i++){
            result.add(letters[i]+"");
        }
        return letterCombinationsCore(sliceFirstDigit(digitChars),result);
    }

    private List<String> letterCombinationsCore(char[] digits, List<String> result) {
        if (digits.length == 0) {
            return result;
        } else {
            char[] tmpDigits = sliceFirstDigit(digits);
            return letterCombinationsCore(tmpDigits,letterCombineList(result,digits[0]));
        }
    }

    private List<String> letterCombineList(List<String> result, char digit) {
        char[] letters = digit2Letters(digit);
        List<String> newResult = new ArrayList<>();
        for (int j = 0; j < result.size(); j++) {
            for (int i = 0; i < letters.length; i++) {
                newResult.add(result.get(j) + letters[i]);
            }
        }
        return newResult;
    }

    private char[] digit2Letters(char digit) {
        char[] letters = null;
        int i = digit - '2';
        if(i<5){
            letters = new char[3];
            letters[0] = (char) ('a' + 3 * i);
            letters[1] = (char) ('a' + 3 * i + 1);
            letters[2] = (char) ('a' + 3 * i + 2);
        }
        else if(i==5){
            letters = new char[4];
            letters[0] = 'p';
            letters[1] = 'q';
            letters[2] = 'r';
            letters[3] = 's';
        }
        else if(i==6){
            letters = new char[3];
            letters[0] = 't';
            letters[1] = 'u';
            letters[2] = 'v';
        }
        else if(i==7){
            letters = new char[4];
            letters[0] = 'w';
            letters[1] = 'x';
            letters[2] = 'y';
            letters[3] = 'z';
        }
        return letters;
    }

    private char[] sliceFirstDigit(char[] digits){
        char[] tmpDigits = new char[digits.length-1];
        for(int i=0;i<digits.length-1;i++){
            tmpDigits[i] = digits[i+1];
        }
        return tmpDigits;
    }

    public List<String> letterCombinationsGoodSolver(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] map = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.add("");
        while (result.peek().length()!=digits.length()){
            String peek = result.removeFirst();
            String chars = map[digits.charAt(peek.length())-'1'];
            for(char ch:chars.toCharArray()){
                result.add(peek+ch);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String digits = "7";
        System.out.println(new Solution().letterCombinations(digits));
        System.out.println(new Solution().letterCombinationsGoodSolver(digits));
    }
}
