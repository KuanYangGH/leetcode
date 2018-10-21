package medium.question137;

/**
 * Single Number II
 * Given a non-empty array of integers,
 * every element appears three times except for one, which appears exactly once.
 * Find that single one.
 * @author yangkuan
 * @date 2018/10/21
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int low = 0,high = 0;
        for(int i=0;i<nums.length;i++){
            low = (low^nums[i])&(~high);
            high = (high^nums[i])&(~low);
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        System.out.print(new Solution().singleNumber(nums));
    }
}
