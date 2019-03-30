package hard.question128;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * @author yangkuan
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(max<nums[i]){
                max = nums[i];
            }
            if(min>nums[i]){
                min = nums[i];
            }
        }
        boolean[] flags = new boolean[max-min+1];
        for(int i=0;i<nums.length;i++){
            flags[nums[i]-min] = true;
        }
        int longestCon = 0;
        int len = 0;
        for(int i=0;i<flags.length;i++){
            if(flags[i]){
                len++;
            }
            else {
                longestCon = Math.max(longestCon,len);
                len = 0;
            }
        }
        return longestCon;
    }

    public int longestConsecutiveWithSet(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longestCon = 1;
        for(int i=0;i<nums.length;i++){
            int low = nums[i]-1;
            int up = nums[i]+1;
            while (set.remove(low)) low--;
            while (set.remove(up)) up++;
            longestCon = Math.max(longestCon,up-low-1);
        }
        return longestCon;
    }
    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(new Solution().longestConsecutiveWithSet(nums));
    }
}
