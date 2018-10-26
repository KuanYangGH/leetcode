package medium.question153;

/**
 * Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * @author yangkuan
 * @date 2018/10/26
 */
public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;

        int leftIndex = 0;
        int rightIndex = len-1;
        int midIndex;

        while (leftIndex<rightIndex){
            if (nums[leftIndex]<nums[rightIndex])
                return nums[leftIndex];
            midIndex = (rightIndex+leftIndex)/2;
            if(nums[midIndex]==nums[leftIndex]&&nums[midIndex]==nums[rightIndex]){
                int min = nums[leftIndex];
                for(int i=leftIndex+1;i<=rightIndex;i++){
                    min = min<nums[i]?min:nums[i];
                }
                return min;
            }
            if(nums[midIndex]<=nums[rightIndex]){
                rightIndex = midIndex;
            }
            else if(nums[midIndex]>=nums[leftIndex]){
                leftIndex = midIndex+1;
            }
        }
        return nums[rightIndex];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,2,3};
        System.out.print(new Solution().findMin(nums));
    }
}
