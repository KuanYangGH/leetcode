package hard.question768;

/**
 * Max Chunks To Make Sorted II
 * This question is the same as "Max Chunks to Make Sorted" except the integers of
 * the given array are not necessarily distinct,the input array could be up to length 2000,
 * and the elements could be up to 10**8.
 * Given an array arr of integers (not necessarily distinct), we split the array into some number
 * of "chunks" (partitions), and individually sort each chunk.  After concatenating them,
 * the result equals the sorted array.
 * @author yangkuan
 * @date 2018/10/08
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr==null||arr.length==0){
            return 0;
        }
        int length = arr.length;
        int[] maxOfLeft = new int[length];
        int[] minOfRight = new int[length];

        maxOfLeft[0] = arr[0];
        for(int i=1;i<length;i++){
            maxOfLeft[i] = maxOfLeft[i-1]>arr[i]?maxOfLeft[i-1]:arr[i];
        }

        minOfRight[length-1]=arr[length-1];
        for(int i=length-2;i>=0;i--){
            minOfRight[i] = minOfRight[i+1]<arr[i]?minOfRight[i+1]:arr[i];
        }
        int cnt = 1;
        for(int i=0;i<length-1;i++){
            if(maxOfLeft[i]<=minOfRight[i+1]){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(new Solution().maxChunksToSorted(arr));
    }
}
