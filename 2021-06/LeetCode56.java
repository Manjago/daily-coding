// https://leetcode.com/problems/merge-intervals/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {
}

class Solution {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        final List<Integer> leftResult = new ArrayList<>();
        final List<Integer> rightResult = new ArrayList<>();

        int prevLeft = intervals[0][0];
        int prevRight = intervals[0][1];

        for (int i = 1; i < intervals.length; ++i) {

            final int left = intervals[i][0];
            final int right = intervals[i][1];

            if (prevRight >= left && prevLeft <= right) {
                prevLeft = min(prevLeft, left);
                prevRight = max(prevRight, right);
            } else {
                leftResult.add(prevLeft);
                rightResult.add(prevRight);
                prevLeft = left;
                prevRight = right;
            }
        }

        leftResult.add(prevLeft);
        rightResult.add(prevRight);

        final int n = leftResult.size();
        final int[][] result = new int[n][2];

        for (int i = 0; i < n; ++i) {
            result[i][0] = leftResult.get(i);
            result[i][1] = rightResult.get(i);
        }

        return result;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
