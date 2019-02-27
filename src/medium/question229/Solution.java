package medium.question229;

import java.util.ArrayList;
import java.util.List;

/**
 *  Majority Element II
 *  Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        int a = 0,b = -1,countA = 0,countB = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==a){
                countA++;
            }else if(nums[i]==b){
                countB++;
            }
            else if(countA==0){
                a = nums[i];
                countA++;
            }
            else if(countB==0){
                b = nums[i];
                countB++;
            }
            else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]== a) countA++;
            if(nums[i]== b) countB++;
        }
        if(countA>nums.length/3) result.add(a);
        if(countB>nums.length/3) result.add(b);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(new Solution().majorityElement(nums));
    }
}
