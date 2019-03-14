package medium.question494;

/**
 * Target Sum
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class Solution {
    int count = 0;

    /**
     * 利用递归的方法，速度慢
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null) return 0;
        findTargetSumWaysCore(nums, S, 0, 0);
        return count;
    }

    private void findTargetSumWaysCore(int[] nums, int S, int currentSum, int i) {
        if (i == nums.length) {
            if (currentSum == S) count++;
            return;
        }
        findTargetSumWaysCore(nums, S, currentSum + nums[i], i + 1);
        findTargetSumWaysCore(nums, S, currentSum - nums[i], i + 1);
    }

    /**
     * 将此问题转化为求子集满足和为（S+Sum）/2的问题
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWaysWithDP(int[] nums, int S) {
        if (nums == null) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (sum<S||(S+sum)%2!=0)?0:findSubsetSum(nums,(S+sum)>>1);
    }
    private int findSubsetSum(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int n:nums){
            for(int i=target;i>=n;i--){
                dp[i] += dp[i-n];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,9,981};
        System.out.println(new Solution().findTargetSumWaysWithDP(nums,100000000));
    }

}
