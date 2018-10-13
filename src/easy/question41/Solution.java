package easy.question41;

/**
 *  First Missing Positive
 *  Given an unsorted integer array, find the smallest missing positive integer.
 * @author yangkuan
 * @date 2018/10/13
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0){
            return 1;
        }
        int len = nums.length;
        for(int i=0;i<len;i++){
            if (nums[i]>0&&nums[i]<=len&&nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
                i--;
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums[len-1]+1;
    }

    private void swap(int[] nums,int idx1,int idx2){
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(new Solution().firstMissingPositive(nums));
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
