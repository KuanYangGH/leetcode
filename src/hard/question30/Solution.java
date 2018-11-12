package hard.question30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Substring with Concatenation of All Words
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return indexes;
        }
        Map<String,Integer> wordsCount = new HashMap<>();
        for(String word:words){
            wordsCount.put(word,wordsCount.getOrDefault(word,0)+1);
        }
        int size = s.length();
        int num = words.length;
        int len = words[0].length();
        for(int i=0;i<size-num*len+1;i++){
            String subString = s.substring(i,i+len);
            if(wordsCount.containsKey(subString)){
                Map<String,Integer> container = new HashMap<>();
                container.put(subString,container.getOrDefault(subString,0)+1);
                int j = i+len;
                boolean flag = true;
                while (j<=(i+len*(num-1))){
                    subString = s.substring(j,j+len);
                    if(wordsCount.containsKey(subString)
                            &&container.getOrDefault(subString,0)<wordsCount.getOrDefault(subString,0)){
                        container.put(subString,container.getOrDefault(subString,0)+1);
                    }
                    else {
                        flag = false;
                        break;
                    }
                    j = j+len;
                }
                if(flag){
                    indexes.add(i);
                }
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> indexs = new Solution().findSubstring(s,words);
        for(Integer integer:indexs){
            System.out.print(integer+" ");
        }
    }
}
