// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
public class LeetCode1493 {
}

class Solution {

    private static final int UNDEFINED = -1;

    public int longestSubarray(int[] nums) {

        final int n = nums.length;

        if (n == 0 || n == 1) {
            return 0;
        }

        int maxlen = UNDEFINED;
        int left = 0;
        int right = 0;
        int zeroPos = nums[0] == 0 ? 0 : UNDEFINED;

        for(int i=1; i < n; ++i) {

            right = i;

            if (nums[i] == 1) {

                if (zeroPos != UNDEFINED) {
                    maxlen = max(maxlen, right - left );
                }

            } else {

                if (zeroPos == UNDEFINED) {

                    zeroPos = i;

                } else {

                    left = zeroPos + 1;
                    zeroPos = i;

                }

                maxlen = max(maxlen, right - left );
            }

        }

        if (zeroPos == UNDEFINED) {
            return n - 1;
        } else {
            return maxlen;
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
