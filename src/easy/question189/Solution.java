package easy.question189;

/**
 * Rotate Array
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * @author yangkuan
 * @date 2018/10/20
 */
public class Solution {
    /**
     * by myself, is not a perfect solution, just right when len is odd number
     * @param nums
     * @param k
     */
    public void rotateByMyself(int[] nums, int k) {
        if(k <= 0){
            return;
        }
        int len = nums.length;
        int oldIndex = 0;
        int oldValue = nums[oldIndex];
        int newIndex;
        for(int i=0;i<len;i++){
            newIndex = (oldIndex+k)%len;

            int tmp = oldValue;
            oldValue = nums[newIndex];
            oldIndex = newIndex;

            nums[newIndex] = tmp;
        }
    }
    public void rotate(int[] nums, int k) {
        if(k <= 0){
            return;
        }
        int len = nums.length;
        k %= nums.length;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);

    }

    private void reverse(int[] nums,int startIndex,int endIndex){
        while (startIndex<endIndex){
            swap(nums,startIndex,endIndex);
            startIndex++;
            endIndex--;
        }
    }
    private void swap(int[] nums,int idx1,int idx2){
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new Solution().rotate(nums,5);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
