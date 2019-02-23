package medium.question33;

/**
 * Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * @author yangkuan
 */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length<=0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right&&nums[left]>=nums[right]){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            // mid 在左边
            if(nums[mid]>=nums[left]){
                // target 在左边有序部分
                if(target>=nums[left]&&target<nums[mid]){
                    return binaryReaserch(nums,left,mid-1,target);
                }
                // target 在右边循环部分
                else {
                    left = mid+1;
                }
            }
            // mid 在右边
            else {
                // target 在右边有序部分
                if(target>nums[mid]&&target<=nums[right]){
                    return binaryReaserch(nums,mid+1,right,target);
                }
                // target 在左边循环部分
                else {
                    right = mid-1;
                }

            }
        }
        return binaryReaserch(nums,left,right,target);
    }
    private int binaryReaserch(int[] nums,int left,int right,int target){
        while (left<=right){
            int mid = (left+right)/2;
            if(target<nums[mid]){
                right = mid-1;
            }
            else if(target>nums[mid]){
                left = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(new Solution().search(nums,1));
    }
}
