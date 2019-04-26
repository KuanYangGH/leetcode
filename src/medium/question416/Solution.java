package medium.question416;

/**
 * Partition Equal Subset Sum
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * @author yangkuan
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        int[][] dp = new int[sum + 1][nums.length];
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    if (i > nums[j]) {
                        dp[i][j] = nums[j];
                    }
                } else {
                    if (i < nums[j]) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - nums[j]][j - 1] + nums[j], dp[i][j - 1]);
                    }
                }
            }
        }
        if (dp[sum][nums.length - 1] != sum) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8};
        System.out.println(new Solution().canPartition(nums));
    }
}
