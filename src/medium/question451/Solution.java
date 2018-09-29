package medium.question451;

import java.util.*;

/**
 * Sort Characters By Frequency
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * @author yangkuan
 * @date 2018/09/27
 */
public class Solution {

    public String frequencySort(String s) {
        if(s==null){
            return null;
        }
        char[] chars = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        for(char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>[] bucket = new List[chars.length];
        for(char key:map.keySet()){
            int value = map.get(key);
            List<Character> list = bucket[value-1];
            if(list==null){
                list = new ArrayList<>();
            }
            for (int i=0;i<value;i++){
                list.add(key);
            }
            bucket[value-1]=list;
        }
        StringBuilder result = new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int j=0;j<bucket[i].size();j++){
                    result.append(bucket[i].get(j));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("eeee");
        System.out.println(new Solution().frequencySort("eeee"));
    }
}
