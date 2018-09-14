package medium.question80;

/**
 * Remove Duplicates from Sorted Array II
 * Given a sorted array nums, remove the duplicates
 * in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * @author yangkuan
 * @date 2018/09/14
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int index = 0;
        boolean isTwice = false;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]!=nums[index]){
                nums[++index] = nums[i];
                isTwice=false;
            }
            else if(nums[i]==nums[index]&&i!=index&&isTwice==false){
                nums[++index] = nums[i];
                isTwice=true;
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3,4,4,4};
        int len = new Solution().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
