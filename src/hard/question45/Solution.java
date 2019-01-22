package hard.question45;

/**
 * Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * @author yangkuan
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null||nums.length<=1) {
            return 0;
        }
        int n = nums.length;
        int step = 0;
        int last = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (i > last) {
                step++;
                last = current;
            }
            current = current > (i + nums[i]) ? current : (i + nums[i]);
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}
