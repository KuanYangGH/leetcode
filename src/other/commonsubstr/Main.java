package other.commonsubstr;


import java.util.Scanner;

/**
 * 最长公共连续子串
 * 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
 * @author yangkuan
 */
public class Main {
    public int maxSubString(String str1,String str2){
        int rows = str1.length();
        int cols = str2.length();
        int maxLen = 0;
        int[][] matrix = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    if(i>0&&j>0){
                        matrix[i][j] = matrix[i-1][j-1]+1;
                    }
                    else {
                        matrix[i][j] = 1;
                    }
                }
                maxLen = maxLen>matrix[i][j]?maxLen:matrix[i][j];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1  = in.nextLine();
        String str2  = in.nextLine();
        System.out.print(new Main().maxSubString(str1,str2));
    }
}
