package other.pincoumoney;

import java.util.Scanner;

/**
 * 给你六种面额 1、5、10、20、50、100 元的纸币，
 * 假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 * @author yangkuan
 * @date 2018/11/1
 */
public class Main {
    public long getCombination(int n, int[] value){
        long[][] matrix = new long[n+1][value.length];
        for(int i=0;i<value.length;i++){
            matrix[0][i] = 1;
        }
        for(int i=0;i<=n;i++){
            matrix[i][0] = 1;
        }
        for(int j=1;j<value.length;j++){
            for(int i=1;i<=n;i++){
                int m = i/value[j];
                for(int k=0;k<=m;k++){
                    matrix[i][j] += matrix[i-k*value[j]][j-1];
                }
            }
        }
        return matrix[n][value.length-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] value = {1, 5, 10, 20, 50, 100};
        System.out.print(new Main().getCombination(n,value));
    }
}
