package easy.qusetion136;

/**
 * Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * @author yangkuan
 * @date 2018/10/21
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int len = nums.length;
        int res = 0;
        for(int i=0;i<len;i++){
            res = res^nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.print(new Solution().singleNumber(nums));
    }
}
