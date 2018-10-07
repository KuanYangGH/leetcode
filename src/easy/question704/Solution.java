package easy.question704;

/**
 * Binary Search
 * given a sorted (in ascending order) integer array nums of n element and a target value,
 * write a function to search target in nums. If target exists, then return its index, otherwise return -1
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * @author yangkuan
 * @date 2018/10/07
 */
public class Solution {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        if(target<nums[leftIndex]||target>nums[rightIndex]){
            return -1;
        }
        int midIndex = 0;
        while (leftIndex<=rightIndex){
            midIndex = (rightIndex+leftIndex)/2;
            if(nums[midIndex]==target){
                return midIndex;
            }
            // target may be in left
            if(target<nums[midIndex]){
                rightIndex = midIndex-1;
            }
            // target may be in right
            else if(target>nums[midIndex]){
                leftIndex = midIndex+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(new Solution().search(nums,2));
    }
}
