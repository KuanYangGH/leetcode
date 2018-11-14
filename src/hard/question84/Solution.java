package hard.question84;


/**
 * Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * @author yangkuan
 * @date 2018/11/14
 */
public class Solution {
    /**
     * O(n^2)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        return largestRectangleArea(heights,0,heights.length-1);
    }
    private int largestRectangleArea(int[] heights, int startIndex, int endIndex){
        if(startIndex>endIndex){
            return 0;
        }
        int minHeightIndex = startIndex;
        for(int i=startIndex+1;i<=endIndex;i++){
            minHeightIndex = heights[minHeightIndex]<heights[i]?minHeightIndex:i;
        }
        int maxArea = heights[minHeightIndex]*(endIndex-startIndex+1);
        int leftMaxArea = largestRectangleArea(heights,startIndex,minHeightIndex-1);
        int rightMaxArea = largestRectangleArea(heights,minHeightIndex+1,endIndex);
        maxArea = maxArea>leftMaxArea?maxArea:leftMaxArea;
        maxArea = maxArea>rightMaxArea?maxArea:rightMaxArea;

        return maxArea;
    }

    public int largestRectangleAreaOn(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        int len = heights.length;

        int[] leftSmaller = new int[len];
        int[] rightSmaller = new int[len];
        leftSmaller[0] = -1;
        rightSmaller[len-1]= len;

        for(int i=1;i<len;i++){
            int tmpIndex = i-1;
            while (tmpIndex>=0&&heights[tmpIndex]>=heights[i]){
                tmpIndex = leftSmaller[tmpIndex];
            }
            leftSmaller[i] = tmpIndex;
        }

        for(int i=len-2;i>=0;i--){
            int tmpIndex = i+1;
            while (tmpIndex<len&&heights[tmpIndex]>=heights[i]){
                tmpIndex = rightSmaller[tmpIndex];
            }
            rightSmaller[i] = tmpIndex;
        }
        int maxArea = 0;
        for(int i=0;i<len;i++){
            int currentArea = heights[i]*(rightSmaller[i]-leftSmaller[i]-1);
            maxArea = maxArea>currentArea?maxArea:currentArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new Solution().largestRectangleArea(heights));
        System.out.print(new Solution().largestRectangleAreaOn(heights));
    }
}
