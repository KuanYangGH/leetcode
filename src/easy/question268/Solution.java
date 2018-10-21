package easy.question268;

/**
 * Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * @author yangkuan
 * @date 2018/10/21
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int len = nums.length;
        int res = 0;
        for(int i=0;i<len;i++){
            res = res^i^nums[i];
        }
        return res^len;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.print(new Solution().missingNumber(nums));

    }
}
