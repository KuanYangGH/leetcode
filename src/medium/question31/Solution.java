package medium.question31;

/**
 * Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * @author yangkuan
 * @date 2018/10/25
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i= nums.length-1;
        while (i>0&&nums[i-1]>=nums[i]){
            i--;
        }
        i--;
        if(i>=0){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    swap(nums,i,j);
                    break;
                }
            }
        }
        reverse(nums,i+1,nums.length-1);
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums,int i,int j){
        while (i<j){
            swap(nums,i++,j--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2};
        new Solution().nextPermutation(nums);
        for (int num:nums){
            System.out.print(num+" ");
        }
    }
}
