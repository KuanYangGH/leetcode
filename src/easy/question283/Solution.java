package easy.question283;

import java.util.Arrays;

/**
 * Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution {
    /**
     * 冒泡的方法，是0就往后冒
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * O(n)的方法，有点类似快排的partition函数，设置指针指向0，以及另一个指向非0
     *
     * @param nums
     */
    public void moveZeroesWithOn(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                swap(nums,i,j++);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 0, 2, 3, 1};
//        new Solution().moveZeroes(nums);
        new Solution().moveZeroesWithOn(nums);
        System.out.println(Arrays.toString(nums));
    }
}
