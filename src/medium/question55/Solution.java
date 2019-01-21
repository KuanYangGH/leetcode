package medium.question55;

/**
 * Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * @author yangkuan
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int n = nums.length;
        int maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (maxReach < i) {
                return false;
            }
            int nowMaxReach = i + nums[i];
            maxReach = maxReach > nowMaxReach ? maxReach : nowMaxReach;
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }
}
