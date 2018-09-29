package hard.question154;

/**
 * Find Minimum in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * The array may contain duplicates.
 */
public class Solution {
    public int findMin(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int midIndex = leftIndex;
        while (nums[leftIndex]>=nums[rightIndex]){
            if(rightIndex-leftIndex==1){
                return nums[rightIndex];
            }
            midIndex = leftIndex+(rightIndex-leftIndex)/2;
            if(nums[midIndex]==nums[leftIndex]&&nums[midIndex]==nums[rightIndex]){
                int min = nums[leftIndex];
                for(int i=leftIndex+1;i<=rightIndex;i++){
                    if(min>nums[i]){
                        min=nums[i];
                    }
                }
                return min;
            }
            if(nums[midIndex]>=nums[leftIndex]){
                leftIndex = midIndex;
            }
            else if(nums[midIndex]<=nums[rightIndex]){
                rightIndex = midIndex;
            }
        }
        return nums[midIndex];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5};
        System.out.println(new Solution().findMin(nums));
    }
}
