package medium.question238;

import java.util.Arrays;

/**
 * Product of Array Except Self
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is
 * equal to the product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra
 * space for the purpose of space complexity analysis.)
 *
 * @author yangkuan
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        int[] products = new int[len];
        products[0] = 1;
        int fromBegin = 1;
        int fromEnd = 1;
        for (int i = 1; i < len; i++) {
            fromBegin = fromBegin * nums[i - 1];
            products[i] = fromBegin;
        }
        for (int i = len - 2; i >= 0; i--) {
            fromEnd = fromEnd * nums[i + 1];
            products[i] *= fromEnd;
        }
        return products;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
    }
}
