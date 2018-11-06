package medium.question279;

/**
 * Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * @author yangkuan
 * @date 2018/11/06
 */
public class Solution {
    public int numSquares(int n) {
        if(n<=0){
            return 0;
        }
        int[] logs = new int[n+1];
        logs[0] = 0;
        for(int i=1;i<=n;i++){
            logs[i] = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                logs[i] = logs[i]<(logs[i-j*j]+1)?logs[i]:(logs[i-j*j]+1);
            }
        }
        return logs[n];
    }

    public static void main(String[] args) {
        System.out.print(new Solution().numSquares(9));
    }
}
