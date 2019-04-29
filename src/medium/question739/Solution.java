package medium.question739;

import java.util.Arrays;
import java.util.Stack;

/**
 * Daily Temperatures
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 * @author yangkuan
 */
public class Solution {

    public int[] dailyTemperatures(int[] T) {
        int[] output = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<T.length;i++){
           while (!stack.empty()&&T[stack.peek()]<T[i]){
               int index = stack.pop();
               output[index] = i-index;
           }
           stack.push(i);
        }
        return output;
    }

    public int[] dailyTemperaturesOn2(int[] T) {
        int[] output = new int[T.length];
        for(int i=0;i<T.length;i++){
            int tem = T[i];
            for(int j=i+1;j<T.length;j++){
                if(T[j]>tem){
                    output[i] = j-i;
                    break;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new Solution().dailyTemperaturesOn2(T)));
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(T)));
    }
}
