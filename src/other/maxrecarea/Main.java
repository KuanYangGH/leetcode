package other.maxrecarea;

import java.util.Scanner;

/**
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。
 * 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。
 * 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 * @author yangkuan
 */
public class Main {
    public int findMaxRecArea(int[] value,int beginIndex,int endIndex){
        if(beginIndex==endIndex){
            return value[beginIndex];
        }
        else if(beginIndex>endIndex){
            return 0;
        }
        int minHeightIndex = beginIndex;
        for(int i=beginIndex+1;i<=endIndex;i++){
            minHeightIndex = value[minHeightIndex]<value[i]?minHeightIndex:i;
        }
        int maxArea = value[minHeightIndex]*(endIndex-beginIndex+1);
        int maxArea2 = findMaxRecArea(value,beginIndex,minHeightIndex-1);
        maxArea = maxArea>maxArea2?maxArea:maxArea2;
        int maxArea3 = findMaxRecArea(value,minHeightIndex+1,endIndex);
        maxArea = maxArea>maxArea3?maxArea:maxArea3;
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            value[i] = in.nextInt();
        }
        System.out.print(new Main().findMaxRecArea(value,0,value.length-1));

    }
}
