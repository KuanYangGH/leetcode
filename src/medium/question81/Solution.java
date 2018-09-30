package medium.question81;

/**
 * Search in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * @author yangkuan
 * @date 2018/09/30
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int midIndex;
        while (leftIndex<=rightIndex){
            midIndex = (rightIndex+leftIndex)/2;
            if(nums[midIndex]==target){
                return true;
            }
            if(nums[midIndex]==nums[leftIndex]&&nums[midIndex]==nums[rightIndex]){
                rightIndex--;
            }
            //if left is sorted
            else if(nums[midIndex]>=nums[leftIndex]){
                //target is in left
                if(target>=nums[leftIndex]&&target<=nums[midIndex]){
                    rightIndex = midIndex-1;
                }
                else {
                    leftIndex = midIndex+1;
                }
            }
            //if right is sorted
            else if(nums[midIndex]<=nums[rightIndex]){
                //target is in right
                if(target>=nums[midIndex]&&target<=nums[rightIndex]){
                    leftIndex = midIndex+1;
                }
                else {
                    rightIndex = midIndex-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,5,1,1,2};
        System.out.println(new Solution().search(nums,4));
    }
}
