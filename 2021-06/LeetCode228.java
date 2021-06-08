// https://leetcode.com/problems/summary-ranges
import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
}

class Solution {
    public List<String> summaryRanges(int[] nums) {

        final int n = nums.length;
        final List<String> answer = new ArrayList<>();

        if (n == 0) {
            return answer;
        }

        if (n == 1) {
            answer.add(Integer.toString(nums[0]));
            return answer;
        }

        int left = nums[0];
        int right = nums[0];

        for (int i=1; i < n; ++i) {
            int current = nums[i];

            if ((current - right) == 1) {
                right = current;
            } else {
                out(answer, left, right);
                left = current;
                right = current;
            }

        }
        out(answer, left, right);

        return answer;

    }

     /*
       current 7
       left 7
       right 7

       [0,1,2,4,5,7] ->  ["0->2", "4->5", "7"]
     */

    private void out(List<String> result, int left, int right) {
        if (left == right) {
            result.add(Integer.toString(left));
        } else {
            final StringBuilder sb = new StringBuilder();
            sb.append(left);
            sb.append("->");
            sb.append(right);
            result.add(sb.toString());
        }
    }
}

