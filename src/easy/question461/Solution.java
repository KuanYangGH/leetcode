package easy.question461;

/**
 *  Hamming Distance
 * The Hamming distance between two integers is the number of positions
 * at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        // 先进行异或
        int z = x^y;
        //再统计结果中1的个数
        return bitCount(z);
    }
    private int bitCount(int z){
        int count = 0;
        while (z!=0){
            count += (z&1);
            z = z>>1;
        }
        return count;
    }
    private int bitCount2(int z){
        int count = 0;
        while (z!=0){
            count ++;
            z = z&(z-1);
        }
        return count;
    }
}
