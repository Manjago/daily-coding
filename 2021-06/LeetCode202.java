// https://leetcode.com/problems/happy-number/

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {
}

class Solution202 {

    public static void main(String[] args) {
        System.out.println(new Solution202().isHappy(2));
    }

    public boolean isHappy(int n) {
        final int[] buffer = new int[20];

        final Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            final int len = toDigits(buffer, n);
            n = 0;
            for (int i = 0; i < len; ++i) {
                n += buffer[i] * buffer[i];
            }
        }

        return true;
    }

    private int toDigits(int[] buffer, int n) {
        int counter = 0;

        while (n >= 10) {
            int digit = n % 10;
            n = (n - digit) / 10;
            buffer[counter++] = digit;
        }

        buffer[counter++] = n;
        return counter;
    }
}
