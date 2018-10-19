package medium.question120;

import java.util.ArrayList;
import java.util.List;

/**
 * Triangle
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * @author yangkuan
 * @date 2018/10/19
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        int rows = triangle.size();

        List<Integer> bottom = new ArrayList<>();
        bottom.addAll(triangle.get(rows-1));

        for (int i=rows-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                bottom.set(j,min(bottom.get(j),bottom.get(j+1))+triangle.get(i).get(j));
            }
        }
        return bottom.get(0);
    }
    private int min(int a,int b){
        return a>b?b:a;
    }

    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);
        System.out.print(new Solution().minimumTotal(triangle));
    }
}
