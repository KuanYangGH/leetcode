package medium.question56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class Solution {
    /**
     * Definition for an interval.
     */
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergeIntervals = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return mergeIntervals;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        mergeIntervals.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval a = mergeIntervals.get(mergeIntervals.size() - 1);
            Interval b = intervals.get(i);
            if (isMerge(a, b)) {
                Interval tmp = mergeCore(a,b);
                mergeIntervals.set(mergeIntervals.size() - 1,tmp);
            }
            else {
                mergeIntervals.add(b);
            }
        }
        return mergeIntervals;
    }

    private boolean isMerge(Interval a, Interval b) {
        if (a.end >= b.start) {
            return true;
        }
        return false;
    }

    private Interval mergeCore(Interval a, Interval b) {
        if (a.start > b.start) {
            a.start = b.start;
        }
        if (a.end < b.end) {
            a.end = b.end;
        }
        return a;
    }

    public void test() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 0));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        intervals = merge(intervals);
        for (Interval interval : intervals) {
            System.out.println(interval.start + "," + interval.end);
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
