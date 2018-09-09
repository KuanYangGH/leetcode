package easy.question26;

/**
 * Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear
 * only once and return the new length.
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * @author yangkuan
 * @date 2018/09/09
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        int len = nums.length;
        int index = 0;
        for (int i=1;i<len;i++){
            if(nums[i]!=nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

    public void test(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    public static void main(String[] args) {
        new Solution().test();
    }

}
