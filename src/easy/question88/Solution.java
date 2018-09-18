package easy.question88;

/**
 * Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * @author yangkuan
 * @date 2018/09/18
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int index = m+n-1;
        while (i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[index--] = nums1[i--];
            }
            else {
                nums1[index--] = nums2[j--];
            }
        }
        /*while (i>=0){
            nums1[index--] = nums1[i--];
        }*/
        while (j>=0){
            nums1[index--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {4,5,6};
        new Solution().merge(nums1,3,nums2,3);
        for(int num:nums1){
            System.out.print(num+" ");
        }
    }
}
