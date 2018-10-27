package medium.question152;

/**
 * Maximum Product Subarray
 * Given an integer array nums, find the contiguous
 * subarray within an array (containing at least one number) which has the largest product.
 * @author yangkuan
 * @date 2018/10/27
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int minPro = nums[0];
        int maxPro = nums[0];
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int tmp = minPro;
                minPro = maxPro;
                maxPro = tmp;
            }
            maxPro = maxPro*nums[i]>nums[i]?maxPro*nums[i]:nums[i];
            minPro = minPro*nums[i]<nums[i]?minPro*nums[i]:nums[i];
            if(result<maxPro){
                result = maxPro;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,3,-2,4};
        System.out.print(new Solution().maxProduct(nums));
    }
}
