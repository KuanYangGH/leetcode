package medium.question621;

/**
 * Task Scheduler
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z
 * where different letters represent different tasks. Tasks could be done without original order.
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 *
 * @author yangkuan
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        // 最频繁任务出现的次数
        int maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (maxCnt < cnt[i]) {
                maxCnt = cnt[i];
            }
        }
        // 最频繁任务的个数
        int time = 0;
        for (int i = 0; i < 26; i++) {
            if (maxCnt == cnt[i]) {
                time++;
            }
        }
        // 根据最高频任务，分成多个部分
        int part = maxCnt - 1;
        // 每个部分的空位数
        int emptyPosition = n + 1 - time;
        int sumEmptyPosition = part * emptyPosition;
        // 额外需要的位置数
        int additionalPosition = Math.max(0, tasks.length - maxCnt * time - sumEmptyPosition);
        return part * (n + 1) + time + additionalPosition;
    }

    public static void main(String[] args) {
        char[] tasks = "AAABBB".toCharArray();
        System.out.println(new Solution().leastInterval(tasks, 2));
    }
}
