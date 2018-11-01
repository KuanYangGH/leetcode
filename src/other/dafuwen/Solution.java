package other.dafuwen;

import java.util.Scanner;

/**
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，
 * 点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 * @author yangkuan
 * @date 2018/11/1
 */
public class Solution {
    public int computeTotalWay(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        int result = 1;
        for(int i=1;i<n;i++){
            result += computeTotalWay(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(new Solution().computeTotalWay(n));
    }
}
