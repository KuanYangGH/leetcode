package medium.question96;

/**
 * Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author yangkuan
 */
public class Solution {
    /**
     * 找规律，f(n)=\sum_{k=1}^n{f(k-1)*f(n-k)}
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n==0){
            return 1;
        }
        int[] counts = new int[n+1];
        counts[0] = 1;
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int k=1;k<=i;k++){
                count += counts[k-1]*counts[i-k];
            }
            counts[i] = count;
        }
        return counts[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}
