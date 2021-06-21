// https://leetcode.com/problems/reverse-integer/
public class LeetCode7 {
}

/*
123 -> 321
-123 -> -321
120 -> 21
0 -> 0

1534236469 -> 0
9646324351
*/
class Solution7 {

    public static void main(String[] args) {
        final Solution7 solution = new Solution7();
        System.out.println(solution.reverse(-2147483648));
        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(100));
    }

    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        // 2147483647
        final int[] maxValue = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7}; // 2^31 + 1
        final int[] minValue = {2, 1, 4, 7, 4, 8, 3, 6, 4, 8}; // |-2^31|

        boolean minusFlag = false;
        if (x < 0) {
            x = -x;
            minusFlag = true;
        }

        // 123
        // 120
        final int[] buffer = new int[20];
        final int pos = fillBuffer(x, buffer);

        // 3 2 1
        // 0 2 1

        // 321

        int result = 0;
        int mult = 1;
        for (int i = pos - 1; i >= 0; --i) {
            result += buffer[i] * mult;
            mult *= 10;
        }

        //lame check
        // 100
        // 0 0 1
        // 1
        final int[] cleaned = new int[20];
        int ctrlPos = 0;
        boolean skipZeroMode = true;
        for (int i = 0; i < pos; ++i) {

            if (buffer[i] == 0 && skipZeroMode) {
                continue;
            } else {
                skipZeroMode = false;
            }

            cleaned[ctrlPos++] = buffer[i];
        }

        if (ctrlPos > maxValue.length) {
            return 0;
        }

        if (minusFlag) {
            if (ctrlPos == minValue.length && !isLessOrEqual(cleaned, minValue, ctrlPos)) {
                return 0;
            }
            result = -result;
        } else {
            if (ctrlPos == maxValue.length && !isLessOrEqual(cleaned, maxValue, ctrlPos)) {
                return 0;
            }
        }

        return result;
    }

    private boolean isLessOrEqual(int[] a, int[] b, int len) {
        for (int i = 0; i < len; ++i) {
            if (a[i] < b[i]) {
                return true;
            } else if (a[i] > b[i]) {
                return false;
            }
        }

        return true;
    }

    private int fillBuffer(int x, int[] buffer) {
        int pos = 0;
        while (x >= 10) {
            final int digit = x % 10;
            x = (x - digit) / 10;
            buffer[pos++] = digit;
        }
        buffer[pos++] = x;
        return pos;
    }
}
