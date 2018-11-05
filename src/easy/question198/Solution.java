package easy.question198;

/**
 * House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @author yangkuan
 * @date 2018/11/04
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int len = nums.length;
        int[] sums = new int[len];
        sums[0] = nums[0];
        sums[1] = nums[1];
        sums[2] = nums[0]+nums[2];
        for(int i=3;i<len;i++){
            sums[i] = sums[i-2]>sums[i-3]?sums[i-2]+nums[i]:sums[i-3]+nums[i];
        }
        return sums[len-1]>sums[len-2]?sums[len-1]:sums[len-2];
    }

    public static void main(String[] args) {
        int[] nums = {20,0};
        System.out.print(new Solution().rob(nums));
    }
}
